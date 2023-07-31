package com.soloproject.TodoApp.repository;

import com.soloproject.TodoApp.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 데이터베이스와 데이터를 주고 받기 위한 인터페이스
// CRUD를 도와주는 인터페이스

// JpaRepository <데이터베이스와 연결될 객체, 그 객체 Id의 필드 타입>
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
