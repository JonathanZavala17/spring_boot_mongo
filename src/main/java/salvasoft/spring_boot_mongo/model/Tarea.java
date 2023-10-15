package salvasoft.spring_boot_mongo.model;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tarea {
    private Integer id;
    private String nombre;

}
