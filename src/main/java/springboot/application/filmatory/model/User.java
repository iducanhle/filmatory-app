package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.application.filmatory.model.type.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false) @Column(nullable = false)
    private String email;

    @Basic(optional = false) @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Role role;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviews;

    public boolean addReview(Review review) {
        if (review != null) {
            if (reviews == null) {
                reviews = new ArrayList<>();
            }
            reviews.add(review);
            return true;
        }
        return false;
    }
}
