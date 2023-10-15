package salvasoft.spring_boot_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import salvasoft.spring_boot_mongo.model.Tarea;
import salvasoft.spring_boot_mongo.repo.TareaRepository;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepositary;

    @GetMapping("")
    List<Tarea> index() {
        return tareaRepositary.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Tarea create(@RequestBody Tarea tarea){
        return tareaRepositary.save(tarea);
    }

    @PutMapping("{id}")
    Tarea update (@PathVariable String id, @RequestBody Tarea tarea){
        Tarea tareaFromDB = tareaRepositary
                .findById(id)
                .orElseThrow(RuntimeException::new);

        tareaFromDB.setNombre(tarea.getNombre());
        tareaFromDB.setCompletado(tarea.isCompletado());

        return tareaRepositary.save(tareaFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("{id}")
    void delete (@PathVariable  String id) {
        Tarea tarea = tareaRepositary
                .findById(id)
                .orElseThrow(RuntimeException::new);
        tareaRepositary.delete(tarea);
    }
}
