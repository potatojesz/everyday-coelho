package everyday.coelho.controller;

import everyday.coelho.service.CoelhoQuotesGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Generate quotes")
@RestController
@RequestMapping("/generator")
public class QuoteGeneratorController {
    @Autowired
    private transient CoelhoQuotesGenerator quotesGenerator;

    @CrossOrigin
    @GetMapping("/quote")
    ResponseEntity<String> generateQuote() {
        return ResponseEntity.ok(quotesGenerator.generate());
    }
}
