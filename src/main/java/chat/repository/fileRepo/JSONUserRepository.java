package chat.repository.fileRepo;

import chat.model.User;
import chat.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONUserRepository implements UserRepository {
    // implementation of user repository which stores the data in a JSON file (as opposed to in memory)

    private String filepath; // path to JSON file

    public JSONUserRepository(String filepath) {
        this.filepath = filepath;
        populateUsers();
    }

    private void populateUsers() {
        User user1 = new User("ion", "1234", false);
        User user2 = new User("maria", "12345", true);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            // variante 1
            mapper.writeValue(new File(this.filepath), users);

            // variante 2
            //mapper.writeValue(Paths.get(filepath).toFile(), user1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
    public User findById(String username) {
        // read all the objects saved in JSON file
        ObjectMapper mapper = new ObjectMapper();
        try {
            User[] users = mapper.readValue(Paths.get(filepath).toFile(), User[].class);
            for (User u : users) {
                if (u.getUsername().equals(username)) {
                    return u;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
