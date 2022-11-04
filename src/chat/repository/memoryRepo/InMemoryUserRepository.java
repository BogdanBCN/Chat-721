package chat.repository.memoryRepo;

import chat.model.User;
import chat.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> allUsers;

    public InMemoryUserRepository() {
        this.allUsers = new ArrayList<>();
        this.populateUsers();
    }

    private void populateUsers() {
        User user1 = new User("ion", "1234", false);
        User user2 = new User("maria", "12345", true);
        User user3 = new User("popescu", "1234", false);

        user1.addFriend(user2);
        user2.addFriend(user3);


    }

    @Override
    public void add(User user) {
        // uberpruefe, dass der username unique bleibt
        allUsers.add(user);
    }

    @Override
    public void delete(String username) {
        User user = this.findById(username);
        allUsers.remove(user);
    }

    @Override
    public void update(String s, User user) {
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public List<User> getAllOnlineFriends() {
        return null;
    }
}
