package com.todoapp.todo.service;

import com.todoapp.todo.model.ToDoApp;
import com.todoapp.todo.repos.ToDoAppRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ToDoAppService {

    private final ToDoAppRepository toDoAppRepository;

    public ToDoAppService(final ToDoAppRepository toDoAppRepository) {
        this.toDoAppRepository = toDoAppRepository;
    }

    public List<ToDoApp> findAll() {
         List<ToDoApp> toDoApps = toDoAppRepository.findAll(Sort.by("id"));
        return toDoApps;

    }

    public Optional<ToDoApp> get(final Long id) {
        return toDoAppRepository.findById(id);

    }

    public Long create(final ToDoApp toDoApp) {

        return toDoAppRepository.save(toDoApp).getId();
    }

    public void update(final Long id, final ToDoApp toDoApp) {
        final ToDoApp ToDoApp = toDoAppRepository.findById(id)
                .orElse(null);
        mapToEntity(ToDoApp, toDoApp);
        toDoAppRepository.save(toDoApp);
    }

    public void delete(final Long id) {
        toDoAppRepository.deleteById(id);
    }



    private ToDoApp mapToEntity(final ToDoApp toDoApp, final ToDoApp ToDoApp) {
        toDoApp.setTodoname(ToDoApp.getTodoname());
        toDoApp.setIsdoneStatus(ToDoApp.getIsdoneStatus());
        return toDoApp;
    }

}
