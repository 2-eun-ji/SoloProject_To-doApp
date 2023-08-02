package com.soloproject.TodoApp.controller;

import com.soloproject.TodoApp.dto.ToDoRequestDto;
import com.soloproject.TodoApp.dto.ToDoResponseDto;
import com.soloproject.TodoApp.entity.ToDo;
import com.soloproject.TodoApp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin // Cors 정책 설정
@RestController
@RequestMapping("/todos")
public class TodoController {
    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // Create 할 일 목록 등록
    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoRequestDto toDoRequestDto) {
        ToDo toDo = toDoService.createToDo(toDoRequestDto);
        return new ResponseEntity<>(new ToDoResponseDto(toDo), HttpStatus.CREATED); // Response 엔티티 객체 생성 + 응답 코드 전송
    }

    // Update 한 일에 완료 표시 추가
    @PostMapping("/{id}/complete")
    public ResponseEntity updateCompleted(@PathVariable("id") Long id) {
        ToDoResponseDto toDoResponseDto = toDoService.updateCompleted(id);
        return new ResponseEntity<>(toDoResponseDto, HttpStatus.OK);
    }

    // Update 할 일 목록 수정
    @PatchMapping("/{id}")
    public ResponseEntity updateToDo(@PathVariable("id") Long id, @RequestBody ToDoRequestDto toDoRequestDto) {
        ToDo toDo = toDoService.updateToDo(id, toDoRequestDto);
        return new ResponseEntity<>(new ToDoResponseDto(toDo), HttpStatus.OK);
    }

    // Read 할 일 목록 조회
    @GetMapping("/{id}")
    public ResponseEntity findToDo(@PathVariable("id") Long id) {
        ToDo toDo = toDoService.findToDo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Read 할 일 목록 전체 조회
    @GetMapping
    public ResponseEntity findToDos() {
        toDoService.findToDos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete 할 일 목록 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") Long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete 할 일 목록 전체 삭제
    @DeleteMapping
    public ResponseEntity deleteToDos() {
        toDoService.deleteToDos();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
