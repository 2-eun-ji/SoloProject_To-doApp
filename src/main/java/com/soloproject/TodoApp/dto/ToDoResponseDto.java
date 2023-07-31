package com.soloproject.TodoApp.dto;

import lombok.*;

// 데이터베이스로부터 응답과 관련된 DTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDoResponseDto {
    private Long id;
    private String title;
    private Integer todoOrder;
    private boolean completed;

}
