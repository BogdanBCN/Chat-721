package chat.repository.databaseRepo;

import chat.model.User;
import chat.repository.UserRepository;

import java.util.List;

public class JdbcUserRepository implements UserRepository {
    @Override
    public void add(User user) {

    }

    @Override
    public void delete(String s) {

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

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
