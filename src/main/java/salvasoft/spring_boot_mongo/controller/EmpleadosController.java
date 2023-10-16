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

    /*
    @GetMapping("")
    List<Empleados> index() {
        return empleadosRepository.findAll();
    }
    */

    @GetMapping("/obtener")
    List<Empleados> index() {
        return empleadosRepository.findAll();
    }

    /*
    @GetMapping("/{id}")
    Empleados getEmpleadoById(@PathVariable String id) {
        return empleadosRepository.findById(id).orElse(null);
    }
    */

    @GetMapping("/obtener/{id}")
    Empleados getEmpleadoById(@PathVariable String id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Empleados create(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }
    */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guardar")
    Empleados create(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }

    /*
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
    */

    @PutMapping("/actualizar/{id}")
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

    /*
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("{id}")
    void delete (@PathVariable  String id) {
        Empleados empleados = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        empleadosRepository.delete(empleados);
    }
    */

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("/borrar/{id}")
    void delete (@PathVariable  String id) {
        Empleados empleados = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        empleadosRepository.delete(empleados);
    }

    /*
    @PatchMapping("/{id}")
    Empleados partialUpdate(@PathVariable String id, @RequestBody Empleados empleados) {
        Empleados empleadosFromDB = empleadosRepository.findById(id).orElse(null);
        if (empleadosFromDB != null) {
            // Realiza las actualizaciones parciales según los campos proporcionados en "empleados".
            if (empleados.getNombre() != null) {
                empleadosFromDB.setNombre(empleados.getNombre());
            }
            // Continúa actualizando otros campos según sea necesario.

            return empleadosRepository.save(empleadosFromDB);
        }
        return null;
    }
    */

    @PatchMapping("/modificacion/{id}")
    Empleados partialUpdate(@PathVariable String id, @RequestBody Empleados empleados) {
        Empleados empleadosFromDB = empleadosRepository.findById(id).orElse(null);
        if (empleadosFromDB != null) {
            // Realiza las actualizaciones parciales según los campos proporcionados en "empleados".
            if (empleados.getNombre() != null) {
                empleadosFromDB.setNombre(empleados.getNombre());
            }
            // Continúa actualizando otros campos según sea necesario.

            return empleadosRepository.save(empleadosFromDB);
        }
        return null;
    }
}
