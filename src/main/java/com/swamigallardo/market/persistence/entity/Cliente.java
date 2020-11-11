package com.swamigallardo.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;
    private String apellidos;

    @Column(name = "celular")
    private Long telefono;

    private String direccion;

    @Column(name = "correo_electronico")
    private String email;
}