package sk.durovic.springboot.beans;

import sk.durovic.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class UsersHolderImpl implements UsersHolder{

    private Set<User> usersList = new TreeSet<>();

    @Override
    public Set<User> getUsers() {
        return usersList;
    }
}
