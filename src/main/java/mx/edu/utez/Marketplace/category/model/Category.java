package mx.edu.utez.Marketplace.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.Marketplace.status.model.Status;
import mx.edu.utez.Marketplace.status.model.Subcategory;

import javax.persistence.*;
import java.util.List;

//indica que es una tabla en la base de datos
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="description",unique = true)
    private String description;
//////////
    @ManyToOne
    @JoinColumn(name ="status_id" )
    private Status status;

   @OneToMany(mappedBy = "category")
   @JsonIgnore
   private List<Subcategory> subcategories;

    public Category(long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Category(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Category() {

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
