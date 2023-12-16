package BasBks.RBPOproj.Controller;

import BasBks.RBPOproj.models.Service;
import BasBks.RBPOproj.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/home")
    public String home(Model model) {
        Iterable<Service> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "/home";
    }
    @GetMapping("/add")
    public String homeAdd(Model model) {
        return "add";
    }
    @PostMapping("/add")
    public String homeServiceAdd(@RequestParam String ServiceName,@RequestParam String ServiceRole, Model model){
        Service service = new Service(ServiceName, ServiceRole);
        serviceRepository.save(service);
        return "/home";
    }

    @GetMapping("service/{serviceName}")
    public String ServiceInfo(@PathVariable(value = "serviceName") String serviceName, Model model) {
        return "service";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("title", "ОБЩЕПИТЪ");
        return "profile";
    }
}
