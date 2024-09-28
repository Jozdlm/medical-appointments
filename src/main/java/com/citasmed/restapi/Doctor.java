package com.citasmed.restapi;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "id_especializacion")
    private Integer idEspecializacion;

    private Long cui;
    private String telefono;
    private String correo;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "clave_doctor", insertable = false, updatable = false)
    private String claveDoctor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getIdEspecializacion() {
        return idEspecializacion;
    }

    public void setIdEspecializacion(Integer idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }

    public Long getCui() {
        return cui;
    }

    public void setCui(Long cui) {
        this.cui = cui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClaveDoctor() {
        return claveDoctor;
    }
}
