package everyday.coelho.service;

import everyday.coelho.mail.MailService;
import everyday.coelho.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class FeedService {
    @Autowired
    private transient MailService mailService;
    @Autowired
    private transient CoelhoQuotesGenerator generator;

    public void send(Email email) throws MessagingException {
        mailService.send(email, generator.generate());
    }
}
