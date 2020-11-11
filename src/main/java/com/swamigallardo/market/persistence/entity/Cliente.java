package com.swamigallardo.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.nio.MappedByteBuffer;
import java.util.List;

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

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}
