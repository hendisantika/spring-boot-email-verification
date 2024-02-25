package id.my.hendisantika.springbootemailverification.controller;

import id.my.hendisantika.springbootemailverification.entity.User;
import id.my.hendisantika.springbootemailverification.service.UserServices;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

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

    @PostMapping("/process_register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        userServices.register(user, getSiteURL(request));
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userServices.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
