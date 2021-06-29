package com.exam.websingle.service.impl;

import com.exam.websingle.model.User;
import com.exam.websingle.repository.IUserRepository;
import com.exam.websingle.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
//@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private  IUserRepository pository;

    @Override
    public List<User> getAll() {
        return pository.findAll();
    }

    @Override
    public Optional<User> getOne(Long id) {
        return pository.findById(id);
    }

    @Override
    public void save(User user) {
        pository.save(user);

    }

    @Override
    public void delete(Long id) {
        pository.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return pository.findUserByEmail(email);
    }
}
