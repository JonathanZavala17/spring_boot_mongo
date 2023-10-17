package salvasoft.spring_boot_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import salvasoft.spring_boot_mongo.model.Empleados;
import salvasoft.spring_boot_mongo.repo.EmpleadosRepository;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadosRepository empleadosRepository;

    @GetMapping("")
    List<Empleados> index() {
        return empleadosRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Empleados create(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }

    @PutMapping("{id}")
    Empleados update (@PathVariable String id, @RequestBody Empleados empleados){
        Empleados empleadosFromDB = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        empleadosFromDB.setNombre(empleados.getNombre());
        empleadosFromDB.setEstado(empleados.isEstado());
        empleadosFromDB.setApellido(empleados.getApellido());
        empleadosFromDB.setEdad(empleados.getEdad());
        empleadosFromDB.setCargo(empleados.getCargo());
        empleadosFromDB.setDireccion(empleados.getDireccion());
        empleadosFromDB.setFecha(empleados.getFecha());
        return empleadosRepository.save(empleadosFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("{id}")
    void delete (@PathVariable  String id) {
        Empleados empleados = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        empleadosRepository.delete(empleados);
    }
}
