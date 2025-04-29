package com.lazymind.full_stack_todo_app.webservice.restfulwebservice.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoResource {

    private final TodoService todoService;

    @GetMapping(value = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable(name = "username") String username){
        return todoService.findByUsername(username);
    }

    @GetMapping(value = "/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable(name = "username") String name, @PathVariable(name = "id") int todoId){
        return todoService.findById(todoId);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable(name = "username") String username, @PathVariable(name = "id") int todoId){
        todoService.deleteById(todoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/users/{username}/todos/{id}") // for updating put
    public Todo updateTodo(@PathVariable(name = "username") String username, @PathVariable(name = "id") int todoId, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable(name = "username") String username, @RequestBody Todo todo){
        return todoService.addTodo( username, todo.getDescription(), todo.getTargetDate(), todo.isDone() );
    }

}
