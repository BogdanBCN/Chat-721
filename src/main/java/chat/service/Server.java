package chat.service;

import chat.model.Message;
import chat.model.MessageStatus;
import chat.model.User;
import chat.repository.MessageRepository;
import chat.repository.UserRepository;

import java.util.ArrayList;

public class Server {
    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public Server(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public String login(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            user.setOnline(true);
            // nach erfolgreichen login, werden alle pending messages zu sent hinzugefugt
            // variante 1
            user.getReceivedMessages().addAll(user.getPendingMessages());
            user.getPendingMessages().clear();
            for (Message m : user.getReceivedMessages()) {
                m.setStatus(MessageStatus.SENT);
                messageRepository.update(m.getId(), m);
            }

            // variante 2
//            while (!user.getPendingMessages().isEmpty()) {
//                Message m = user.getPendingMessages().remove(0);
//                user.getReceivedMessages().add(m);
//            }
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
        // nachdem wir sicher sind, dass die Nachricht valid ist, fuge ins Repo hinzu
        messageRepository.add(message);
        if (receiver.isOnline()) {
            message.setStatus(MessageStatus.SENT);
            // update auch in repo
            messageRepository.update(message.getId(), message);
            receiver.getReceivedMessages().add(message);
        } else {
            receiver.getPendingMessages().add(message);
        }
        return "Message sent successfully";
    }
}
