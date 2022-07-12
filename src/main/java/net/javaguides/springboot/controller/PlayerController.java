package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.PlayerDetails;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/players")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<PlayerDetails> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping
    public PlayerDetails createUser(@RequestBody PlayerDetails user) {
        return userRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<PlayerDetails> getUserById(@PathVariable  long id){
        PlayerDetails user =  userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

//
//    @PutMapping("{id}")
//    public ResponseEntity<PlayerDetails> updateUser(@PathVariable long id, @RequestBody PlayerDetails userDetails) {
//         PlayerDetails updateUser = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
//
//        updateUser.setFirstName(userDetails.getFirstName());
//        updateUser.setLastName(userDetails.getLastName());
//        updateUser.setEmailId(userDetails.getEmailId());
//        updateUser.setPassword(userDetails.getPassword());
//        updateUser.setUserRole(userDetails.getUserRole());
//
//        userRepository.save(updateUser);
//
//        return ResponseEntity.ok(updateUser);
//    }
//
//    // build delete employee REST API
//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
//
//        PlayerDetails PlayerDetails = userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));
//
//        userRepository.delete(PlayerDetails);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
}
