package com.exam.websingle.controller;

import com.exam.websingle.model.User;
import com.exam.websingle.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        List<User> users =  userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}/find")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getOne(id),HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody User user){
        Optional<User> user1 = userService.getOne(id);
        if (user1.isPresent()){
            user1.get().setName(user.getName());
            user1.get().setEmail(user.getEmail());
            user1.get().setPassword(user.getPassword());
            userService.save(user1.get());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping ("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
//        List<User> user = (List<User>) userService.findUserByEmail(email);
//        return new ResponseEntity<>(user,HttpStatus.OK);
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }


}
