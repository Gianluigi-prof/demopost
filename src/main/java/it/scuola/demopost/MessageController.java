package it.scuola.demopost;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repo;

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Message> all() {
        return repo.findAll();
    }

    // POST JSON: fetch, curl, Postman
    @PostMapping
    public Message create(@RequestBody Message msg) {
        return repo.save(msg);
    }

    @PostMapping("/form")
    public ResponseEntity<Void> createFromForm(@RequestParam String text) {
        Message msg = new Message();
        msg.setText(text);
        repo.save(msg);

        // return new RedirectView("index.html");

        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .header(HttpHeaders.LOCATION, "/index.html")
                .build();
    }
}