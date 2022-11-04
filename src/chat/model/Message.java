package chat.model;

public class Message {
    private User sender;
    private User receiver;
    private String text;
    private MessageStatus status;

    private int id;

    public Message(User sender, User receiver, String text, int id) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.status = MessageStatus.PENDING;
        this.id = id;
    }



    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
