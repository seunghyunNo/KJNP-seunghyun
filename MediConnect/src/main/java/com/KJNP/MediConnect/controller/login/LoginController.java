package com.KJNP.MediConnect.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.KJNP.MediConnect.biz.member.MemberDTO;
import com.KJNP.MediConnect.biz.member.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")	// 로그인 페이지 이동
	public String LoginPage() {
		
		return "login/login";
	}
	
	@PostMapping("/login")	//로그인 기능
	public String Login(MemberDTO memberDTO, Model model, HttpSession session) {
		
		
		memberDTO=memberService.selectOne(memberDTO);
		if(memberDTO==null) {
			model.addAttribute("msg", "로그인 실패");
			return "common/goback";
		}
		session.setAttribute("member", memberDTO);
		System.out.println("로그인 성공");
		return "redirect:/";
	}
	
	@PostMapping("/logout")	// 로그아웃
	public String Logout(HttpSession session) {
		
		session.removeAttribute("member");
		return "redirect:/";
	}
}
