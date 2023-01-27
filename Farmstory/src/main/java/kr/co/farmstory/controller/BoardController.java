package kr.co.farmstory.controller;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("board/list")
    public String list(Model model, String group, String cate){
        List<BoardVO> users = service.selectBoards();

        model.addAttribute("users", users);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify(Model model, String group, String cate){

        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/modify";
    }

    @GetMapping("board/view")
    public String view(Model model, String group, String cate){

        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/view";
    }

    @GetMapping("board/write")
    public String write(Model model, String group, String cate){

        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        return "board/write";
    }
}
