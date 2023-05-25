package pl.testy.zadanie.testy_spring_homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.testy.zadanie.testy_spring_homework.service.BaseService;

import java.util.List;

public abstract class BaseController<D, S extends BaseService> {

    protected abstract S getService();

    @GetMapping
    List<D> get() {
        return getService().get();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {

        return new ResponseEntity<>((D) getService().create(dto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<D> update(@PathVariable Long id, @RequestBody D dto) {
        return new ResponseEntity<>((D) getService().update(id, dto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        getService().delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
