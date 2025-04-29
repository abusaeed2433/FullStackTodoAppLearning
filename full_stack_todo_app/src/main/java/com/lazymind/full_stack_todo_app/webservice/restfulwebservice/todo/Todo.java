package com.lazymind.full_stack_todo_app.webservice.restfulwebservice.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {

    private int id;

    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;

}
