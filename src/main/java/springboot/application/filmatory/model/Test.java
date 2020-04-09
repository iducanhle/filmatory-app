package springboot.application.filmatory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }
}
