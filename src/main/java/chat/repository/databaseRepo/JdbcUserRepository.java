package chat.repository.databaseRepo;

import chat.model.User;
import chat.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcUserRepository implements UserRepository {

    private JdbcUtils utils;

    public JdbcUserRepository(JdbcUtils utils) {
        this.utils = utils;
    }

    public void populateUsers() {
        Connection connection = utils.getInstance();
        try (PreparedStatement statement = connection.prepareStatement("insert into users(username, password, status) values (?, ?, ?)")) {
            statement.setString(1, "ion");
            statement.setString(2, "1234");
            statement.setString(3, "false");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
