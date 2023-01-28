package com.alexotoodev.firstapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUsername(String username);


    
}
