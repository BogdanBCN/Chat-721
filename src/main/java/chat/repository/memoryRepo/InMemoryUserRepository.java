package chat.repository.memoryRepo;

import chat.model.User;
import chat.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

    private List<User> allUsers;

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

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

        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);


    }

    @Override
    public void add(User user) {
        for (User u : this.allUsers) {
            if (u.getUsername().equals(user.getUsername())) {
                System.out.println("Username already exists");
                return;
            }
        }
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
    public User findById(String username) {
        for (User u : allUsers) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllOnlineFriends() {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = findById(username);
        if (user == null) {
            return null;
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
