package pl.testy.zadanie.testy_spring_homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.testy.zadanie.testy_spring_homework.service.BaseService;

import java.util.List;

public abstract class BaseController<D,S extends BaseService>{

    protected abstract S getService();

    @GetMapping("/all")
    List<D> get(){
        return getService().get();
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody D dto){
        getService().create(dto);
        return ResponseEntity.ok("Zapisano");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody D dto){
        getService().update(id,dto);
        return ResponseEntity.ok("update wykonany");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        getService().delete(id);
        return ResponseEntity.ok("Usunięto");
    }

}
