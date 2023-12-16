package BasBks.RBPOproj.Controller;

import BasBks.RBPOproj.Interface.UserDto;
import BasBks.RBPOproj.Interface.UserService;
import BasBks.RBPOproj.models.User;
import BasBks.RBPOproj.models.UserInfo;
import BasBks.RBPOproj.repo.UserInfoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    @Autowired
    private UserInfoRepository userInfoRepository;
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        UserInfo userinfo = new UserInfo(userDto.getEmail());
        userInfoRepository.save(userinfo);
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
}
