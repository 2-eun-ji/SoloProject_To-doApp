package com.soloproject.TodoApp.service;

import com.soloproject.TodoApp.dto.ToDoRequestDto;
import com.soloproject.TodoApp.dto.ToDoResponseDto;
import com.soloproject.TodoApp.entity.ToDo;
import com.soloproject.TodoApp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// Repository 인터페이스가 동작하는 코드
@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    // 할 일 목록 등록
    public ToDo createToDo(ToDoRequestDto toDoRequestDto) {
        ToDo toDo = new ToDo();
        toDo.setTitle(toDoRequestDto.getTitle());
        toDo.setTodoOrder(toDoRequestDto.getTodoOrder());
        toDo.setCompleted(toDoRequestDto.getCompleted());

        return toDoRepository.save(toDo);
    }

    // 한 일에 완료 표시 추가
    public ToDoResponseDto updateCompleted(Long id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isPresent()) {
            ToDo toDo = optionalToDo.get();
            toDo.setCompleted(true);
            toDoRepository.save(toDo);

            return new ToDoResponseDto(toDo.getId(), toDo.getTitle(), toDo.getTodoOrder(), toDo.getCompleted());
        }
        throw new IllegalArgumentException("해당하는 할 일 목록이 없습니다. id = " + id);
    }

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
    public List<ToDo> findToDos() {
        return toDoRepository.findAll();
    }

    // 등록된 할 일의 특정 ID를 입력해 삭제
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 할 일 목록이 없습니다. id = " + id));
        toDoRepository.deleteById(id);
    }

    // 전체 할 일 삭제
    public void deleteToDos() {
        toDoRepository.deleteAll();
    }
}
