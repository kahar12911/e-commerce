package com.flipkart.e_commerce.controller;

import com.flipkart.e_commerce.exception.UserNotFoundException;
import com.flipkart.e_commerce.model.User;
import com.flipkart.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdetails")
public class UserContoller {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user = userRepository.findUserByEmail(email);
        return user;
    }


    @GetMapping("/id/{id}")
    public Optional<User> getUserByID(@PathVariable Integer id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                return user;
            } else {
                throw new UserNotFoundException("User with ID " + id + " is not present.");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/add")
    public String registerUser(@RequestBody User userDetail){
        userRepository.save((userDetail));
        return "User has been added";
    }

    @GetMapping("/phone_no")
    public User getUserbyPhoneNo(@PathVariable long phone_no){
        User user = userRepository.findUserByPhoneNo(phone_no);
        return user;
    }

    @GetMapping("/username")
    public User getUserbyUsername(@PathVariable String username){
        User user = userRepository.findUserByUsername(username);
        return user;
    }

//    @PutMapping ("/update")
//    public String UpdateUser(@RequestBody User userdetail){
//
//    }
}
