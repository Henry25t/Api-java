package org.proyecto.dtos.Tarea;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class TareaCambiarEstado implements Serializable {
    private Integer id;
    private String nombre;
}
