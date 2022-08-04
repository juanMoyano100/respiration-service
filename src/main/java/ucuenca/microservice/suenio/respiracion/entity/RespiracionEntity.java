package ucuenca.microservice.suenio.respiracion.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "respiracion")
@Getter
@Setter
@NoArgsConstructor
public class RespiracionEntity {

    private String id;
    private String id_usuario;
    private LocalDateTime fecha;
    private Integer respiracion;

}
