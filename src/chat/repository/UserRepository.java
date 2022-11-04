package chat.repository;

import chat.model.User;

import java.util.List;

public interface UserRepository extends ICrudRepository<String, User>{

    List<User> getAllOnlineFriends();
    User findByUsernameAndPassword(String username, String password);

    List<User> getAllUsers();
}
