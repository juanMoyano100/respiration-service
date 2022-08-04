package ucuenca.microservice.suenio.respiracion.service;

import ucuenca.microservice.suenio.respiracion.entity.RespiracionEntity;

import java.util.List;

public interface RespiracionService {

    public List<RespiracionEntity> findListRespiracion(String ini, String fin);
    public List<RespiracionEntity> findByIdUserResp(String id_usuario);

}
