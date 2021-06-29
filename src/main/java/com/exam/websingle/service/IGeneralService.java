package com.exam.websingle.service;

import com.exam.websingle.model.User;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> getAll();
    Optional<T> getOne(Long id);
    void save (T t);
    void delete(Long id);
    User findUserByEmail (String email);

}
