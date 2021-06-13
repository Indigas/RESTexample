package sk.durovic.springboot.model;


public class User implements Comparable<User> {

    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User user) {
        // vkladanie noveho user bez id
        if(user.getId()==0)
            return 1;

        if(this.id == user.getId()){
            return 0;
        }

        if(this.id > user.getId())
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;

        User user = (User) obj;

        return this.id == user.getId();
    }
}
