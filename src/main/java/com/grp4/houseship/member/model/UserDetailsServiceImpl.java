package com.grp4.houseship.member.model;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//建這個類塞進WebSecurityConfig,系統就能幫忙比對user輸入的帳密(系統順便加密)和存在系統資料庫的帳密
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private MemberService memberService;
	
	//參數username就是系統從登入頁面獲得的username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//獲取存在資料庫的資料
		Member member = memberService.findByAccount(username);
		System.out.println(member.getAccount()+member.getHashed_pwd());
		//把資料return給系統,系統會去UserDetailsImpl找需要的資訊
		return new UserDetailsImpl(member);
		//return new User(member.getAccount(),member.getHashed_pwd(), Collections.emptyList());
		
	}
	
	

}
