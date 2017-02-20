package ru.ekabardinsky.iit.jsp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ekabardinsky on 2/20/17.
 */

@RestController
public class Parser {

    @RequestMapping("/api/parser")
    public String parser() {
        return "Hello from rest controller";
    }
}
