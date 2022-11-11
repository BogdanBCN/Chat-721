package tests;

import chat.model.Message;
import chat.model.User;
import chat.repository.MessageRepository;
import chat.repository.UserRepository;
import chat.repository.memoryRepo.InMemoryMessageRepository;
import chat.repository.memoryRepo.InMemoryUserRepository;
import chat.service.Server;
import chat.utils.BadCredentialsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    private UserRepository userRepository;
    private MessageRepository messageRepository;
    private Server server;

    @BeforeEach
    void setUP() {
        // instantiate repos
        userRepository = new InMemoryUserRepository();
        messageRepository = new InMemoryMessageRepository(userRepository);
        server = new Server(userRepository, messageRepository);
    }

    @Test
    void testSuccessfulLogin() throws BadCredentialsException {
        assertEquals(server.login("ion", "1234"), "User logged in successfully");
    }

    @Test
    void testUnsuccessfulLogin() {
        Throwable exception = assertThrows(BadCredentialsException.class, () -> server.login("ion", "123456"));
        assertEquals(exception.getMessage(), "Bad credentials");
    }

    void testTransferMessagesOnLogin() throws BadCredentialsException {
        server.login("ion", "1234");
        User sender = userRepository.findById("ion");
        User receiver = userRepository.findById("maria");
        server.sendMessage(new Message(sender, receiver, "Salut!!", 4));
        server.login("maria", "12345");
        assertTrue(receiver.getPendingMessages().isEmpty());
    }

}