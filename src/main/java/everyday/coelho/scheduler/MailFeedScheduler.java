package everyday.coelho.scheduler;

import everyday.coelho.model.Email;
import everyday.coelho.repository.EmailRepository;
import everyday.coelho.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Component
public class MailFeedScheduler {
    @Autowired
    private transient FeedService feedService;
    @Autowired
    private transient EmailRepository emailRepository;

    @Scheduled(cron = "0 0 0 * * *", zone = "CET")
    public void sendEmails() {
        List<Email> emails = emailRepository.findAll();
        for(Email email : emails) {
            try {
                feedService.send(email);
            } catch (Throwable e) {
                Logger.getGlobal().log(new LogRecord(Level.SEVERE, "Failed to send email to " + email.getEmail()));
            }
        }
    }
}
