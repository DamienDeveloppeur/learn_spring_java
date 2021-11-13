package fr.mds.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Controller
@RequestMapping
public class GlobalController {

    @Transactional
    @GetMapping("/test")
    String displayList(Model model){
        model.addAttribute("something", "something something");
        return "test";
    }
    @Transactional
    @GetMapping("/")
    String getHome(Model model){
        return "test";
    }
}
