package mx.edu.utez.Marketplace.status.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.Marketplace.category.model.Category;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;

    ////////////
    @ManyToOne
    @JoinColumn(name ="status_id" )
    private Status status;
    ///
    @ManyToOne
    @JoinColumn(name ="category_id" )
    private Category category;

    public Subcategory(long id, String descripcion, Status status, Category category) {
        this.id = id;
        this.descripcion = descripcion;
        this.status = status;
        this.category = category;
    }

    public Subcategory(String descripcion, Status status, Category category) {
        this.descripcion = descripcion;
        this.status = status;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
