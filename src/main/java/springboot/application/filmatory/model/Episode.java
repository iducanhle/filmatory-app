package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "episode")
@Getter @Setter
public class Episode {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false) @Column(nullable = false)
    private String description;

    @Basic(optional = false) @Column(nullable = false)
    private String runtime;

    @ManyToOne
    private Series series;
}
