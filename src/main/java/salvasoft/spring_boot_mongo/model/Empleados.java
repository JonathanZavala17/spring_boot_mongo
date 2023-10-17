package salvasoft.spring_boot_mongo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document
public class Empleados {
    @Id
    private String id;
    private String e_nombre;
    private String e_apellido;
    private Integer e_edad;
    private String e_cargo;
    private String e_ficha;
    private Date e_fecha;
    private String e_direccion;
    private boolean e_estado;


}
