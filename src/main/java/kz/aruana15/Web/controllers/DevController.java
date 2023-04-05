package kz.aruana15.Web.controllers;

import kz.aruana15.Web.entities.Developers;
import kz.aruana15.Web.models.dto.DevelopersDtoResponse;
import kz.aruana15.Web.services.DevService;
import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/developers")


public class DevController {
    private final DevService devService;
    @Autowired
    public DevController(DevService devService) {
        this.devService = devService;
    }

    @PostMapping("/insert")
    public ResponseEntity <Developers> create(@RequestBody DevelopersDtoResponse developersDtoResponse){ //DTO должны быть разные, отдельно responseDto и requestDto, но я не стала так делить,
        //не совсем этот момент понимаю пока
        Developers devs = devService.insert(developersDtoResponse);
        return  new ResponseEntity<>(devs, HttpStatus.BAD_REQUEST);
    }
        @GetMapping("/")
                public ResponseEntity<List<Developers>> getAll(){
            List<Developers> devList = devService.getAll();
            return new ResponseEntity<>(devList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Developers> update (@PathVariable Long id, @RequestBody DevelopersDtoResponse developersDtoResponse){
        Developers updated = devService.update(id, developersDtoResponse);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}

