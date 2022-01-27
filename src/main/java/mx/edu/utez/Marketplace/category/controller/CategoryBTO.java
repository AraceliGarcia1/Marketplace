package mx.edu.utez.Marketplace.category.controller;

public class CategoryBTO {
    private long id;
    private String descripcion;

    public CategoryBTO() {
    }

    public CategoryBTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoryBTO(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
}
