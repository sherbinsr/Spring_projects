package spring.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    @GetMapping("/")
    public String great(HttpServletRequest request)
    {
        return "Welcome to spring security"+request.getSession().getId();
    }

}
