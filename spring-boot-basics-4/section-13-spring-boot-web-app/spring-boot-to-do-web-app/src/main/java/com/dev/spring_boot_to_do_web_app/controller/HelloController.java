package com.dev.spring_boot_to_do_web_app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoHelloPage(ModelMap model) {
        model.addAttribute("name", getLoggedInUsername());

        return "welcomePage";
    }

    private String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

//public class LoginController {
//
//    private final AuthenticationService authenticationService;
//
//    @Autowired
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String gotoLoginPage() {
//
//        return "loginPage";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if (authenticationService.authenticate(name, password)) {
//            model.addAttribute("name", name);
//
//            return "welcomePage";
//        }
//
//        model.put("errorMessage", "Invalid Credentials!, Please try again!");
//
//        return "loginPage";
//    }
//}

//public class LoginController {
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @RequestMapping("/login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//
//        logger.debug("---> Request param is {}", name);
//
//        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
//        String safeName = policy.sanitize(name);
//
//        model.addAttribute("name", safeName);
//
//        return "login";
//    }
//}
