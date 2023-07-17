package com.softserve.service;

import com.softserve.exception.NullEntityReferenceException;
import com.softserve.model.User;
import com.softserve.repository.RoleRepository;
import com.softserve.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
//@EnableTransactionManagement(proxyTargetClass = true)
public class UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User create(User role) {
        if (role != null) {
            return userRepository.save(role);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }


    public User update(User role) {
        if (role != null) {
            readById(role.getId());
            return userRepository.save(role);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    public User readById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    public void delete(long id) {
        userRepository.delete(readById(id));
    }

    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> search(String keyword) {
        return userRepository.search(keyword);
    }
}
