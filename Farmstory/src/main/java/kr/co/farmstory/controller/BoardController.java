package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("board/list")
    public String list(Model model, String group){

        model.addAttribute("group", group);

        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify(Model model, String group){

        model.addAttribute("group", group);
        return "board/modify";
    }

    @GetMapping("board/view")
    public String view(Model model, String group){

        model.addAttribute("group", group);
        return "board/view";
    }

    @GetMapping("board/write")
    public String write(Model model, String group){

        model.addAttribute("group", group);
        return "board/write";
    }
}