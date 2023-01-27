package kr.co.sboard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<ArticleVO> users = service.selectArticles();
		model.addAttribute("users", users);
		
		return "/list";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("write")
	public String write(ArticleVO vo, HttpServletRequest req) {
		// IP설정
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		// FILE설정
		
		
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
}
