package com.exam.websingle.repository;

import com.exam.websingle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findUserByEmail (String email);
}
