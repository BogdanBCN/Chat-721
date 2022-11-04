package chat.service;

import chat.model.Message;
import chat.model.MessageStatus;
import chat.model.User;
import chat.repository.UserRepository;

import java.util.ArrayList;

public class Server {
    private UserRepository userRepository;

    public String login(String username, String password) {
        User user = userRepository.findById(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setOnline(true);
            // nach erfolgreichen login, werden alle pending messages zu sent hinzugefugt
            // variante 1
            //user.getReceivedMessages().addAll(getPendingMessages());
            //user.getPendingMessages().clear();

            // variante 2
            while (!user.getPendingMessages().isEmpty()) {
                Message m = user.getPendingMessages().remove(0);
                user.getReceivedMessages().add(m);
            }
            return "User logged in successfully";
        }
        return "Incorrect credentials";
    }

    public String sendMessage(Message message) {
        User sender = message.getSender();
        User receiver = message.getReceiver();
        boolean found = false;
        for (User u : sender.getFriends()) {
            if (u.getUsername().equals(receiver.getUsername())) {
                found = true;
                break;
            }
        }
        if (!found) {
            return "YOU ARE NOT FRIENDS WITH THAT USER";
        }
        if (receiver.isOnline()) {
            message.setStatus(MessageStatus.SENT);
            receiver.getReceivedMessages().add(message);
        } else {
            receiver.getPendingMessages().add(message);
        }
        return "Message sent successfully";
    }
}
