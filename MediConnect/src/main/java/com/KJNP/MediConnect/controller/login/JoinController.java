package com.KJNP.MediConnect.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.KJNP.MediConnect.biz.member.MemberDTO;
import com.KJNP.MediConnect.biz.member.MemberService;

@Controller
public class JoinController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/join")	// 회원가입 페이지 이동
	public String JoinPage() {
		
		return "login/join";
	}
	
	@PostMapping("/join")
	public String Join(MemberDTO memberDTO) {
		System.out.println(memberDTO);
		memberService.insert(memberDTO);
		return "redirect:/";
	}
}
