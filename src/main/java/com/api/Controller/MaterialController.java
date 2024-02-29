package com.api.Controller;

import com.api.model.Entity.Material;
import com.api.model.payload.MensajesResponse;
import com.api.service.IMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private IMaterial Clienteservicio;
    @GetMapping("/Materiales")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> showAll() {
        try {
            List<Material> userList = Clienteservicio.listall();

            if (userList.isEmpty()) {
                return new ResponseEntity<>(MensajesResponse.builder()
                        .mensaje("No se ha encontrado material")
                        .objeto(null)
                        .build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(MensajesResponse.builder()
                        .mensaje("Materiales disponibles")
                        .objeto(userList)
                        .build(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al encontrar material")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/actualizarCliente")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> update(@RequestBody Material material) {
        try {
            Material materialActualizado = Clienteservicio.save(material);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("El material se actualizó correctamente")
                    .objeto(materialActualizado)
                    .build(), HttpStatus.OK);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al actualizar el material")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/nuevoMaterial")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MensajesResponse> create(@RequestBody Material material) {
        try {
            Material nuevoMaterial = Clienteservicio.save(material);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Material ingresado correctamente")
                    .objeto(nuevoMaterial)
                    .build(), HttpStatus.CREATED);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al ingresar material")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("eliminarMaterial/{id}")
    public ResponseEntity<MensajesResponse> delete(@PathVariable Integer id) {
        try {
            Material materialDelete = Clienteservicio.findById(id);
            Clienteservicio.delete(materialDelete);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Material eliminado exitosamente")
                    .objeto(materialDelete)
                    .build(), HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al eliminar material")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/consultaMaterial/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MensajesResponse> showById(@PathVariable Integer id) {
        try {
            Material material = Clienteservicio.findById(id);
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Material obtenido exitosamente")
                    .objeto(material)
                    .build(), HttpStatus.OK);
        } catch (DataAccessException ex) {
            return new ResponseEntity<>(MensajesResponse.builder()
                    .mensaje("Error al obtener el material")
                    .objeto(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
