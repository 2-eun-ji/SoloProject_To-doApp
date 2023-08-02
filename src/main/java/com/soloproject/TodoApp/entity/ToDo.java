package com.soloproject.TodoApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos")
public class ToDo {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private int todoOrder;

    @Column(nullable = false)
    private Boolean completed;
}
