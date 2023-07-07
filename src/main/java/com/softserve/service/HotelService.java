package com.softserve.service;

import com.softserve.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

//    @Override
//    public ToDo create(ToDo role) {
//        if (role != null) {
//            return todoRepository.save(role);
//        }
//        throw new NullEntityReferenceException("ToDo cannot be 'null'");
//    }
//
//    @Override
//    public ToDo readById(long id) {
//        return todoRepository.findById(id).orElseThrow(
//                () -> new EntityNotFoundException("ToDo with id " + id + " not found"));
//    }
//
//    @Override
//    public ToDo update(ToDo role) {
//        if (role != null) {
//            readById(role.getId());
//            return todoRepository.save(role);
//        }
//        throw new NullEntityReferenceException("ToDo cannot be 'null'");
//    }
//
//    @Override
//    public void delete(long id) {
//        todoRepository.delete(readById(id));
//    }
//
//    @Override
//    public List<ToDo> getAll() {
//        List<ToDo> todos = todoRepository.findAll();
//        return todos.isEmpty() ? new ArrayList<>() : todos;
//    }
//
//    @Override
//    public List<ToDo> getByUserId(long userId) {
//        List<ToDo> todos = todoRepository.getByUserId(userId);
//        return todos.isEmpty() ? new ArrayList<>() : todos;
//    }
}
