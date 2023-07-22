package com.todoapp.todo.controller;

import com.todoapp.todo.model.ToDoApp;
import com.todoapp.todo.service.ToDoAppService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/toDoApps", produces = MediaType.APPLICATION_JSON_VALUE)
public class ToDoAppController {
 @Autowired
 ToDoAppService toDoAppService;



    @GetMapping
    public ResponseEntity<List<ToDoApp>> getAllToDoApps() {
        return ResponseEntity.ok(toDoAppService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDoApp>> getToDoApp(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(toDoAppService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createToDoApp(@RequestBody @Valid final ToDoApp toDoApp) {
        final Long createdId = toDoAppService.create(toDoApp);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateToDoApp(@PathVariable(name = "id") final Long id,
                                              @RequestBody @Valid final ToDoApp toDoApp) {
        toDoAppService.update(id, toDoApp);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteToDoApp(@PathVariable(name = "id") final Long id) {
        toDoAppService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
