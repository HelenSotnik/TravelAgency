package com.softserve.service;

import com.softserve.dto.RoleResponse;
import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.Role;
import com.softserve.model.User;
import com.softserve.repository.RoleRepository;
import com.softserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User user) {
        if (user == null) {
            throw new NullEntityReferenceException("User cannot be 'null'");
        }
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public List<RoleResponse> getAllRoles() {
        List<RoleResponse> result = new ArrayList<>();
        for (Role role : roleRepository.findAll()) {
            result.add(new RoleResponse(role.getName()));
        }
        return result;
    }

    public User readById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    public User update(User user) {
        User oldUser = readById(user.getId());
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(readById(id));
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }

    public User getUserByEmail(String email){
       return userRepository.findUserByEmail(email);
    }

    public List<User> search(String keyword) {
        return userRepository.search(keyword);
    }
}
