package com.rich.springboot.mongo.service;

import java.util.List;

import com.rich.springboot.mongo.entity.TodoDTO;

/**
 * This interface declares the methods that provides CRUD operations for
 * {@link com.rich.springboot.mongo.entity.Todo} objects.
 * 
 * @author rich
 * 
 */
public interface TodoService {

    /**
     * Creates a new todo entry.
     * @param todo  The information of the created todo entry.
     * @return      The information of the created todo entry.
     */
    TodoDTO create(TodoDTO todo);

    /**
     * Deletes a todo entry.
     * @param id    The id of the deleted todo entry.
     * @return      THe information of the deleted todo entry.
     * @throws com.rich.springboot.mongo.exception.TodoNotFoundException if no todo entry is found.
     */
    TodoDTO delete(String id);

    /**
     * Finds all todo entries.
     * @return      The information of all todo entries.
     */
    List<TodoDTO> findAll();

    /**
     * Finds a single todo entry.
     * @param id    The id of the requested todo entry.
     * @return      The information of the requested todo entry.
     * @throws com.rich.springboot.mongo.exception.TodoNotFoundException if no todo entry is found.
     */
    TodoDTO findById(String id);

    /**
     * Updates the information of a todo entry.
     * @param todo  The information of the updated todo entry.
     * @return      The information of the updated todo entry.
     * @throws com.rich.springboot.mongo.exception.TodoNotFoundException if no todo entry is found.
     */
    TodoDTO update(TodoDTO todo);
}