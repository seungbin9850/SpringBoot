package com.spring.todo.service;

import com.spring.todo.domain.Todo;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos(Sort sort) throws Exception;
    void postTodo (Todo todo) throws  Exception;
    void deleteTodo (Long id) throws Exception;
    Todo findTodoById(Long id) throws Exception;
}
