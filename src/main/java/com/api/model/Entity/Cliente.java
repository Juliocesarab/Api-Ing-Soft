package com.api.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table (name = "ingreso_de_material")
public class Cliente  {

    @Id
    @Column(name = "id_ingreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdIngreso;
    @Column(name = "Material")
    private String  Material;
    @Column(name = "Cantidad")
    private Float Cantidad;
    @Column(name = "Departamento")
    private String Departamento;
    @Column(name = "Obra")
    private String Obra;

}
