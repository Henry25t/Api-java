package org.proyecto.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.naming.spi.StateFactory;

@Getter
@Setter
@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String duracion;

    @Enumerated(EnumType.STRING)
    private Status estado;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    public  static enum  Status{
        APROBADA, PROCESO, REVISION, FINALIZADO
    }
}
