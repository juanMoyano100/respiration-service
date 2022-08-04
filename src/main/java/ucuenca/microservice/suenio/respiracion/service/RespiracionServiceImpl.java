package ucuenca.microservice.suenio.respiracion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ucuenca.microservice.suenio.respiracion.entity.RespiracionEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RespiracionServiceImpl implements RespiracionService{

    private final MongoOperations mongoOperations;

    @Autowired()
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;

    public RespiracionServiceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<RespiracionEntity> findListRespiracion(String ini, String fin) {
        Query query = new Query();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(ini, format);
        LocalDateTime end = LocalDateTime.parse(fin, format);
        query.addCriteria(Criteria.where("fecha").gt(start).lt(end));
        List <RespiracionEntity> respiracionDB = this.mongoOperations.find(query,RespiracionEntity.class);
        return respiracionDB;
    }

    @Override
    public List<RespiracionEntity> findByIdUserResp(String id_usuario) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("id_usuario").is(id_usuario));
        List<RespiracionEntity> users = mongoTemplate.find(query1, RespiracionEntity.class);
        return users;
    }
}
