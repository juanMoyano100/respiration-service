package ucuenca.microservice.suenio.respiracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucuenca.microservice.suenio.respiracion.entity.RespiracionEntity;
import ucuenca.microservice.suenio.respiracion.repository.RespiracionRepository;
import ucuenca.microservice.suenio.respiracion.service.RespiracionService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/respiracion")
public class RespiracionController {

    @Autowired
    private RespiracionRepository respiracionRepository;

    @Autowired
    private RespiracionService respiracionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespiracionEntity> getAllRespiracion(){
        return respiracionRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createRespiracion(@RequestBody RespiracionEntity respiracionEntity){
        respiracionRepository.save(respiracionEntity);
    }

    @GetMapping (value = "/list/{fechaIni}/{fechaFin}")
    public ResponseEntity<List<RespiracionEntity>> findListRespiracion(@PathVariable String fechaIni, @PathVariable String fechaFin){
        List<RespiracionEntity> temp = new ArrayList<>();
        temp = respiracionService.findListRespiracion(fechaIni, fechaFin);
        return ResponseEntity.ok(temp);
    }

    @GetMapping(value = "/list/{id_user}")
    public ResponseEntity<List<RespiracionEntity>> findListIdUserResp(@PathVariable String id_user){
        List<RespiracionEntity> temp = new ArrayList<>();
        temp = respiracionService.findByIdUserResp(id_user);
        return ResponseEntity.ok(temp);
    }


}
