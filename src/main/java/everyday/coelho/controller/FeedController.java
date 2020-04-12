package everyday.coelho.controller;

import everyday.coelho.model.Email;
import everyday.coelho.model.exception.ResourceNotFoundException;
import everyday.coelho.model.payload.EmailPayload;
import everyday.coelho.repository.EmailRepository;
import everyday.coelho.service.FeedService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Optional;

@Api(value = "Feed to email")
@RestController
@RequestMapping("/")
public class FeedController {
    @Autowired
    private transient EmailRepository emailRepository;
    @Autowired
    private transient FeedService service;

    @CrossOrigin
    @PostMapping("/feed")
    ResponseEntity<String> feed(@RequestBody EmailPayload payload) {
        return ResponseEntity.ok(saveEmail(payload.getEmail()).toString());
    }

    @GetMapping("/feed")
    ResponseEntity<String> feedGet(@RequestParam String emailString) {
        return ResponseEntity.ok(saveEmail(emailString).toString());
    }

    private Email saveEmail(@RequestParam String emailString) {
        Optional<Email> email = emailRepository.findByEmail(emailString);
        Email entity = null;
        if (!email.isPresent()) {
            entity = new Email(emailString);
            emailRepository.save(entity);
        } else {
            entity = email.get();
        }
        return entity;
    }

    @CrossOrigin
    @GetMapping("/trigger/send/email")
    ResponseEntity<String> sendFeedByEmailAddress(@RequestParam String emailAddress) throws MessagingException {
        Optional<Email> email = emailRepository.findByEmail(emailAddress);
        if(email.isPresent()) {
            service.send(email.get());
            return ResponseEntity.ok("Sended RSS Feed to: " + emailAddress);
        } else {
            throw new ResourceNotFoundException("Email " + emailAddress + " not found. Unable to send feed.");
        }
    }

    @CrossOrigin
    @GetMapping("/trigger/send/id")
    ResponseEntity<String> sendFeedById(@RequestParam Long emailId) throws MessagingException {
        Optional<Email> email = emailRepository.findById(emailId);
        if(email.isPresent()) {
            Email emailVal = email.get();
            service.send(emailVal);
            return ResponseEntity.ok("Sended RSS Feed to: " + emailVal.getEmail());
        } else {
            throw new ResourceNotFoundException("Email with ID " + emailId + " not found. Unable to send feed.");
        }
    }
}
