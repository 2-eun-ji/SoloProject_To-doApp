package com.soloproject.TodoApp.dto;

import com.soloproject.TodoApp.entity.ToDo;
import lombok.*;

// 데이터베이스로부터 응답과 관련된 DTO
@Getter
@Setter
@AllArgsConstructor
public class ToDoResponseDto {
    private Long id;
    private String title;
    private Integer todoOrder;
    private boolean completed;

    public ToDoResponseDto(ToDo toDo) {
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.todoOrder = toDo.getTodoOrder();
        this.completed = toDo.getCompleted();
    }
}
