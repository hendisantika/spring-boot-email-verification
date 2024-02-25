package id.my.hendisantika.springbootemailverification.controller;

import id.my.hendisantika.springbootemailverification.entity.User;
import id.my.hendisantika.springbootemailverification.service.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-email-verification
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 08:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class AppController {

    private final UserServices userServices;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }
}
