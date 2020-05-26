package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter @Setter @NoArgsConstructor
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false) @Column(nullable = false)
    private String comment;

    @Basic(optional = false) @Column(nullable = false)
    private Integer rating;

    @ManyToOne
    private User user;
}
