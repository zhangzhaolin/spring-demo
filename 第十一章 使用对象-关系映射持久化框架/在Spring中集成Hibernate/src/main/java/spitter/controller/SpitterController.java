package spitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spitter.dao.SpitterRepository;
import spitter.domain.Spitter;
import spitter.utils.DataTableInput;

import java.util.Map;

@Controller
@RequestMapping(value = {"/","/spitter"})
public class SpitterController {

    private final SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @GetMapping
    public String showSpitter(){
        return "spitter";
    }

    @PostMapping
    public ResponseEntity<Object> spitterList(@RequestBody DataTableInput dataTable) {
        // spitterRepository.findAll(dataTable);
        return new ResponseEntity<>(spitterRepository.findAll(dataTable), HttpStatus.ACCEPTED);
    }

}
