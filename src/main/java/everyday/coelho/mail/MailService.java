package everyday.coelho.mail;

import everyday.coelho.model.Email;

import javax.mail.MessagingException;

public interface MailService {
    void send(Email email, String text) throws MessagingException;
}
