package org.proyecto.controladores;

import org.proyecto.dtos.proyecto.ProyectoGuardar;
import org.proyecto.dtos.proyecto.ProyectoModificar;
import org.proyecto.dtos.proyecto.ProyectoSalida;
import org.proyecto.servicios.interfaces.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<Page<ProyectoSalida>> mostrarTodosPaginados(Pageable pPageable)
    {
        Page<ProyectoSalida> proyecto = proyectoService.obtenerTodosPaginados(pPageable);
        if(proyecto.hasContent())
            return  ResponseEntity.ok(proyecto);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProyectoSalida>> mostratTodos()
    {
        List<ProyectoSalida> proyectos = proyectoService.obtenerTodos();
        if(!proyectos.isEmpty())
        {
            return ResponseEntity.ok(proyectos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoSalida> buscarPorId(@PathVariable Integer id)
    {
        ProyectoSalida proyecto = proyectoService.obtenerPorId(id);
        if(proyecto != null)
        {
            return ResponseEntity.ok(proyecto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProyectoSalida> crear(@RequestBody ProyectoGuardar proyectoGuardar)
    {
        ProyectoSalida categoria = proyectoService.guardar(proyectoGuardar);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProyectoSalida> editar(@PathVariable Integer id, @RequestBody ProyectoModificar proyectoModificar)
    {
        ProyectoSalida proyecto = proyectoService.editar(proyectoModificar);
        return ResponseEntity.ok(proyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar (@PathVariable Integer id)
    {
        proyectoService.eliminarPorId(id);
        return ResponseEntity.ok("proyecto eliminada correctamente");
    }
}
