package weare4saken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerNew {
    @GetMapping("/")
    public String showPublicInfo() {
        return "publicInfo";
    }

    @GetMapping("/it")
    public String showitInfo() {
        return "itInfo";
    }

    @GetMapping("/stuff")
    public String showStuffInfo() {
        return "stuffInfo";
    }

    @GetMapping("/director")
    public String showDirectorInfo() {
        return "directorInfo";
    }

}
