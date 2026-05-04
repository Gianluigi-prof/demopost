package it.scuola.demopost;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repo;

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

    // GET: leggo tutti i messaggi dal DB
    @GetMapping
    public List<Message> all() {
        return repo.findAll();
    }

    // POST: scrivo un messaggio nel DB
    @PostMapping
    public Message create(@RequestBody Message msg) {
        return repo.save(msg);
    }

    // FORM HTML classico
    @PostMapping("/form")
    public String createFromForm(@RequestParam String text) {
        Message msg = new Message();
        msg.setText(text);
        repo.save(msg);
        return "redirect:/index.html";
    }
}
