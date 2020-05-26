package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Getter @Setter
public class Movie extends Product {
    @Basic(optional = false) @Column(nullable = false)
    private Integer runtime;
}
