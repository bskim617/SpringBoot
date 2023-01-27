package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("user/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("user/terms")
    public String terms(Model model){
        TermsVO vo = service.selectTerms();
        model.addAttribute("vo", vo);
        return "user/terms";
    }

    @GetMapping("user/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("user/register")
    public String register(UserVO vo, HttpServletRequest req){
        //Ip 설정
        String regip = req.getRemoteAddr();
        vo.setRegip(regip);

        int result = service.insertUser(vo);

        return "redirect:/user/login?success"+result;
    }

    //ID중복체크
    @ResponseBody
    @GetMapping("/user/checkUid")
    public Map<String, Integer> checkUid(String uid){
        int result = service.countUser(uid);

        Map<String, Integer> map = new HashMap<>();
        map.put("result", result);

        return map;
    }

    @ResponseBody
    @GetMapping("/user/checkNick")
    public Map<String, Integer> checkNick(String nick){
        int result = service.countNick(nick);

        Map<String, Integer> map = new HashMap<>();
        map.put("result", result);

        return map;
    }
}
