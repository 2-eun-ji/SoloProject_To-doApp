package com.soloproject.TodoApp.controller;

import com.soloproject.TodoApp.dto.ToDoRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    // Create 할 일 목록 등록
    @PostMapping
    public ResponseEntity postToDo(@RequestBody ToDoRequestDto todoRequestDto) {
        return new ResponseEntity<ToDoRequestDto>(todoRequestDto, HttpStatus.CREATED); // Response 엔티티 객체 생성 + 응답 코드 전송
    }

    // Read 할 일 목록 조회
    @GetMapping("/{todos-id}")
    public ResponseEntity getToDo() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getToDos() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update 할 일 목록 수정
    @PatchMapping("/{todos-id}")
    public ResponseEntity updateToDo(@RequestBody ToDoRequestDto toDoRequestDto) {
        return new ResponseEntity<>(toDoRequestDto,HttpStatus.OK);
    }

    // Delete 할 일 목록 삭제
    @DeleteMapping("/{todos-id}")
    public ResponseEntity deleteTodo() {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
