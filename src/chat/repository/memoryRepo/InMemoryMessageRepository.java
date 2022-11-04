package chat.repository.memoryRepo;

import chat.model.Message;
import chat.model.User;
import chat.repository.MessageRepository;
import chat.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMessageRepository implements MessageRepository {

    private List<Message> allMessages;
    private UserRepository userRepository;

    public InMemoryMessageRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.allMessages = new ArrayList<>();
        populateMessages();
    }

    private void populateMessages() {
        List<User> users = userRepository.getAllUsers();
        // list of 3 users created in user repo
        User user1 = users.get(0);
        User user2 = users.get(1);
        User user3 = users.get(2);
        Message message1 = new Message(user1, user2, "Sal.Cf?", 0);
        Message message2 = new Message(user2, user1, "Bn.Tu?", 1);
//        this.allMessages.add(message1);
//        this.allMessages.add(message2);
        this.add(message1);
        this.add(message2);


    }

    @Override
    public void add(Message message) {
        for (Message m : this.allMessages) {
            if (m.getId() == message.getId()) {
                System.out.println("ID already exists");
                return;
            }
        }
        allMessages.add(message);
    }

    @Override
    public void delete(Integer integer) {
        Message message = this.findById(integer);
        allMessages.remove(message);
    }

    @Override
    public void update(Integer id, Message message) {
        Message m = findById(id);
        int position = this.allMessages.indexOf(m);
        allMessages.set(position, message); // update element by position

    }

    @Override
    public Message findById(Integer id) {
        for (Message m : allMessages) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
