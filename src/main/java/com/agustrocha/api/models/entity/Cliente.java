package com.agustrocha.api.models.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generates IDs incrementally
    @Column(name = "id")
    private Long id;

    @NotEmpty //Valida que los campos no estén vacios.
    @Column(name = "customer_name", nullable = false)
    private String nombre;

    @NotEmpty
    @Column(name = "customer_surname", nullable = false)
    private String apellido;

    @NotEmpty
    @Column(name = "customer_email", nullable = false)
    private String email;

    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
