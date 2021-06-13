package sk.durovic.springboot.bootstrap;

import sk.durovic.springboot.beans.UsersHolder;
import sk.durovic.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OnStart implements CommandLineRunner {

    @Autowired
    private UsersHolder usersHolder;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1L, "Marek");
        User user2 = new User(2L, "Jano");
        User user3 = new User(3L, "Viktoria");
        User user4 = new User(4L, "Patricia");
        User user5 = new User(5L, "Patrik");

        usersHolder.getUsers().add(user1);
        usersHolder.getUsers().add(user2);
        usersHolder.getUsers().add(user3);
        usersHolder.getUsers().add(user4);
        usersHolder.getUsers().add(user5);
    }
}
