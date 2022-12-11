package com.org.minions.controller;

import com.org.minions.model.MinionsMode;
import com.org.minions.repositery.MinionsRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//mapping123
//iamm basha
@RequestMapping("/api")
public class MinionsController {
    @Autowired
    MinionsRepositery minionsRepositery;
    @PostMapping("/create")
    public MinionsMode create(@RequestBody MinionsMode minionsMode){
        return minionsRepositery.save(minionsMode);
    }
    @PostMapping("/createMul")
    public String createMul(@RequestBody List<MinionsMode> minionsModes){
        minionsRepositery.saveAll(minionsModes);
        return "succesfuly created";
    }
    @GetMapping("/getall")
    public List<MinionsMode> getAll(){
        List<MinionsMode> all = minionsRepositery.findAll();
        return all;

    }
    @GetMapping("/getbyid/{id}")
    public MinionsMode getOne(@PathVariable Integer id){

        return minionsRepositery.findById(id).orElse(null);
    }
    @GetMapping("/getbychar/{characters}")
    public MinionsMode getChar(@PathVariable String characters){
        return minionsRepositery.findByCharacters(characters);
    }
    @DeleteMapping("deleteAll")
    public String delAll(){
        minionsRepositery.deleteAll();
        return "all are deleted";
    }
    @DeleteMapping("delbyid/{id}")
    public String delOne(@PathVariable Integer id){
        minionsRepositery.deleteById(id);
        return "deleted "+id;
    }
@PutMapping("/update/{id}")
    public MinionsMode update(@RequestBody MinionsMode minionsMode){
        MinionsMode model=minionsRepositery.findById(minionsMode.getId()).orElse(null);
        model.setCharacters(minionsMode.getCharacters());
        model.setPerMarks(minionsMode.getPerMarks());
        return minionsRepositery.save(model);
    }
    @PatchMapping("/parupd/{id}/{characters}")
    public ResponseEntity<MinionsMode> parupd(@PathVariable Integer id, @PathVariable String characters){
       try {
        MinionsMode mod=minionsRepositery.findById(id).get();
        mod.setCharacters(characters);
           minionsRepositery.save(mod);
        return new ResponseEntity<MinionsMode>(mod, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    }
}
