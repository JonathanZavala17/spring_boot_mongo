package salvasoft.spring_boot_mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import salvasoft.spring_boot_mongo.model.Empleados;

public interface EmpleadosRepository extends MongoRepository<Empleados, String> {
}
