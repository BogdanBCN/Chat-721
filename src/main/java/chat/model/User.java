package chat.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private boolean isOnline;
    private List<User> friends;

    private List<Message> receivedMessages;
    private List<Message> pendingMessages;

    public User() {
    }

    public User(String username, String password, boolean isOnline) {
        this.username = username;
        this.password = password;
        this.isOnline = isOnline;
        this.friends = new ArrayList<>();
        this.receivedMessages = new ArrayList<>();
        this.pendingMessages = new ArrayList<>();
    }

    public void addFriend(User u) {
        this.getFriends().add(u);
        u.getFriends().add(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isOnline=" + isOnline +
                ", friends=" + friends +
                ", receivedMessages=" + receivedMessages +
                ", pendingMessages=" + pendingMessages +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Message> getPendingMessages() {
        return pendingMessages;
    }

    public void setPendingMessages(List<Message> pendingMessages) {
        this.pendingMessages = pendingMessages;
    }
}
