package id.my.hendisantika.springbootemailverification.service;

import id.my.hendisantika.springbootemailverification.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-email-verification
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 08:07
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository repo;

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender mailSender;
}
