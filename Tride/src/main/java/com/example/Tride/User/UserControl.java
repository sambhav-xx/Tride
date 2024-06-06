package com.example.Tride.User;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControl {

    private final UserRepository repo;

    public UserControl( UserRepository repo){


        this.repo = repo;
    }

    @GetMapping("/allrides")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.repo.findAll());
    }
    @PostMapping("/postride")
    public ResponseEntity<User> createUser(@RequestBody User User){
        return ResponseEntity.ok(this.repo.save(User));
    }

    @GetMapping("/ride/{id}")
    public ResponseEntity getById(@PathVariable String id){
        Optional<User> user = this.repo.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else {
            return ResponseEntity.ok("The ride you are searching for may have been deletd by the user");
        }
    }
    @DeleteMapping("ride/remove/{id}")
    public ResponseEntity deleteById(@PathVariable String id){
        Optional<User> user = this.repo.findById(id);
        if(user.isPresent()){
            this.repo.deleteById(id);
            return ResponseEntity.ok("your request for rided has been successfully deleted from the database");
        }
        else {
            return ResponseEntity.ok("The ride you are trying to delete was not found in the database");
        }
    }

//    @PutMapping Mapping("ride/update/{id}")
//    public ResponseEntity updateById(@PathVariable String id){
//        Optional<User> user = this.repo.findById(id);
//        if(user.isPresent()){
//            this.repo.deleteById(id);
//            return ResponseEntity.ok("your request for rided has been successfully deleted from the database");
//        }
//        else {
//            return ResponseEntity.ok("The ride you are trying to delete was not found in the database");
//        }
//    }






}
