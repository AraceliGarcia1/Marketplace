package mx.edu.utez.Marketplace.category.model;

import javax.persistence.*;

//indica que es una tabala en la base de datos
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="description",unique = true)
    private String description;

    public Category(long id) {
        this.id = id;
    }

    public Category(String description) {
        this.description = description;
    }

    public Category(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
