package com.KJNP.MediConnect.biz.member;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String role;
	private String gender;
	private String phoneNumber;
	private String email;
	private String address;
}
