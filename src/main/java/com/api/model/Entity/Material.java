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
@Table (name = "material_en_sistema")
public class Material {

    @Id
    @Column(name = "id_ingreso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngreso;
    @Column(name = "material")
    private String  material;
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "obra")
    private String obra;

}
