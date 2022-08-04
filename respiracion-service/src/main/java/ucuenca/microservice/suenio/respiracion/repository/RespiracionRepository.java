package ucuenca.microservice.suenio.respiracion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ucuenca.microservice.suenio.respiracion.entity.RespiracionEntity;

public interface RespiracionRepository extends MongoRepository <RespiracionEntity,String> {

}
