package sk.durovic.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.durovic.springboot.beans.UsersHolder;
import sk.durovic.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@RestController
public class IndexController {

    @Autowired
    UsersHolder usersHolder;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return usersHolder.getUsers().stream().filter(t -> t.equals(new User(id, "")))
                    .findFirst().orElse(null);

    }

    @GetMapping("/")
    public Set<User> getUsers(){
        return usersHolder.getUsers();
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User newUser, @PathVariable("id") Long id){
        User user = new User(id, newUser.getName());
        usersHolder.getUsers().add(user);
        return user;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User newUser, @PathVariable("id") Long id){
        User user = new User(id, newUser.getName());

        if (usersHolder.getUsers().contains(user)) {
            usersHolder.getUsers().remove(user);
            usersHolder.getUsers().add(user);
        } else {
            usersHolder.getUsers().add(user);
        }


        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id){
        usersHolder.getUsers().remove(new User(id, ""));
    }

}
