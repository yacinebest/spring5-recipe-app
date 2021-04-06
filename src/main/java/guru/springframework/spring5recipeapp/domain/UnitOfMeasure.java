package guru.springframework.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String description;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(String description) {
        this.description = description;
    }

}
