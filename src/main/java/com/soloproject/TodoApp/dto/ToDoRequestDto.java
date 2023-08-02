package com.soloproject.TodoApp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// 데이터베이스로부터 요청과 관련된 DTO
@Getter
@Setter
@RequiredArgsConstructor
public class ToDoRequestDto {
    private String title;
    private Integer todoOrder;
    private Boolean completed;
}
