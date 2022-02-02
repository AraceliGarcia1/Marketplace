package mx.edu.utez.Marketplace.category.controller;

import mx.edu.utez.Marketplace.status.model.Status;

public class CategoryDTO {
    private long id;
    private String descripcion;
    private Status status;
    public CategoryDTO() {
    }

    public CategoryDTO(String descripcion, Status status) {
        this.descripcion = descripcion;
        this.status = status;
    }

    public CategoryDTO(long id, String descripcion, Status status) {
        this.id = id;
        this.descripcion = descripcion;
        this.status = status;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
