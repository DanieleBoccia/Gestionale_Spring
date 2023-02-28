package crt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    
    @GetMapping("/com.service")
    public String showHomePage() {
        return "Home"; // nome della vista da visualizzare
    }
}
