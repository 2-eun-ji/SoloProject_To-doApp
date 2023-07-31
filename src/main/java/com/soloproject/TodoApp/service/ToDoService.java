package com.soloproject.TodoApp.service;

import com.soloproject.TodoApp.dto.ToDoRequestDto;
import com.soloproject.TodoApp.dto.ToDoResponseDto;
import com.soloproject.TodoApp.entity.ToDo;
import com.soloproject.TodoApp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Repository 인터페이스 가 동작하는 코드
@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    // 할 일 목록 등록
    public ToDo addToDo(ToDoRequestDto requestDto) {
        ToDo toDo = new ToDo();
        toDo.setTitle(requestDto.getTitle());
        toDo.setTodoOrder(requestDto.getTodoOrder());
        toDo.setCompleted(requestDto.getCompleted());

        return toDoRepository.save(toDo);
    }

    /* 한 일에 완료 표시 추가하기
    public ToDoResponseDto updateCompleted(Long id)
    */

    // 할 일의 내용 수정
    public ToDo updateToDo(Long id, ToDoRequestDto requestDto) {
        ToDo toDo = toDoRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당하는 할 일 목록이 없습니다. id = " + id));

        if(requestDto.getTitle() != null) {
            toDo.setTitle(requestDto.getTitle());
        }

        if(requestDto.getTodoOrder() != null) {
            toDo.setTodoOrder(requestDto.getTodoOrder());
        }

        if(requestDto.getCompleted() != null) {
            toDo.setCompleted(requestDto.getCompleted());
        }

        return toDoRepository.save(toDo);
    }

    // 등록된 할 일의 특정 ID를 입력해 조회
    public ToDo findToDo(Long id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // 전체 할 일 목록 조회
    public List<ToDo> findAllToDo() {
        return toDoRepository.findAll();
    }

    // 등록된 할 일의 특정 ID를 입력해 삭제
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 할 일 목록이 없습니다. id = " + id));
        toDoRepository.deleteById(id);
    }

    // 전체 할 일 삭제
    public void deleteAllToDo() {
        toDoRepository.deleteAll();
    }

}
