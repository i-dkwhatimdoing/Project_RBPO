package BasBks.RBPOproj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "login";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "profile";
    }
}
