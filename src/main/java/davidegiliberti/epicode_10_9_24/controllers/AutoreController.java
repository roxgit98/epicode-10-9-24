package davidegiliberti.epicode_10_9_24.controllers;

import davidegiliberti.epicode_10_9_24.entities.Autore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @GetMapping
    private String getAllAutori() {
        return "ecco tutti gli autori";
    }

    @GetMapping("/autoreId")
    private String getAutoreById(@PathVariable int autoreId) {
        return "ecco l'autore creato";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String createAutore(@RequestBody Autore body) {
        return "autore creato";
    }

    @PutMapping("/autoreId")
    private String findAndUpdate(@PathVariable int autoreId, @RequestBody Autore body) {
        return "hai modificato l'autore";
    }

    @DeleteMapping("/blogId")
    @ResponseStatus(HttpStatus.OK)
    private String deleteAutore(@PathVariable int autoreId) {
        return "hai eliminato l'autore";
    }
}
