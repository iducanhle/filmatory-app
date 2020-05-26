package springboot.application.filmatory.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "series")
@Getter @Setter
public class Series extends Product {
    @OneToMany(
            mappedBy = "series",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Episode> episodes;
}
