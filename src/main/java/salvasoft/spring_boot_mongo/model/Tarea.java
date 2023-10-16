package salvasoft.spring_boot_mongo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Tarea {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String cargo;
    private boolean completado;

}
