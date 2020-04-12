package everyday.coelho.service;

import everyday.coelho.model.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCoelhoQuotesGenerator implements CoelhoQuotesGenerator {
    @Override
    public String generate() {
        final StringBuilder message = new StringBuilder();
        message.append(generateQuote());
        message.append(generateSignature());
        return message.toString();
    }

    private String generateSignature() {
        return "\n\n\t\t\t\t\t\t\t\t\t\t\t~Paulo Coelho";
    }

    private StringBuilder generateQuote() {
        final StringBuilder quote = new StringBuilder();
        quote.append(getRandomFromList(Constants.START_ARTICLE)).append(" ");
        quote.append(getRandomFromList(Constants.NOUN)).append(" ");
        quote.append(getRandomFromList(Constants.VERB)).append(" ");
        quote.append(getRandomFromList(Constants.ARTICLE)).append(" ");
        quote.append(getRandomFromList(Constants.PREPOSITION)).append(".");
        return quote;
    }

    private String getRandomFromList(List<String> collection) {
        return collection.get(Constants.RANDOMIZER.nextInt(collection.size()));
    }
}
