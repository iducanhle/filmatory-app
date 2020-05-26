package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@MappedSuperclass
@Getter @Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false) @Column(nullable = false)
    private String name;

    @Basic(optional = false) @Column(nullable = false)
    private String description;

    @Basic(optional = false) @Column(nullable = false)
    private String imagePath;

    @OneToMany
    private List<Review> reviews;
}