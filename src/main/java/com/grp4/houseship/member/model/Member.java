package com.grp4.houseship.member.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity @Table(name="member")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;  //Bean要可序列化
	//為什麼序列化要有private,static??
	
	@Id @Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="ACCOUNT",unique=true)
	private String account;
	@Column(name="HASHED_PWD")
	private String hashed_pwd;
	@Column(name="LASTNAME")
	private String lastname;
	@Column(name="FIRSTNAME")
	private String firstname;
	@Column(name="BIRTHDAY")
	private String birthday;
	@Column(name="EMAIL")
	private String email;
	@Column(name="M_ADDRESS")
	private String m_address;
	@Column(name="PHONE")
	private String phone;
	@Column(name="MEMPIC")
	private String mempic;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "member_roles",
			joinColumns = @JoinColumn(name = "account" ),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	
	public Member() {  
		
	}
	
	public Member(int id, String account, String hashed_pwd, String salt, String lastname, String firstname,
			String birthday, String email, String m_address, String phone, String mempic) {
	
		this.id=id;
		this.account = account;
		this.hashed_pwd = hashed_pwd;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
		this.email = email;
		this.m_address = m_address;
		this.phone = phone;
		this.mempic = mempic;
	}
	
	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getHashed_pwd() {
		return hashed_pwd;
	}

	
	
	public void setHashed_pwd(String hashed_pwd) {
		this.hashed_pwd = hashed_pwd;
	}




	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getM_address() {
		return m_address;
	}



	public void setM_address(String m_address) {
		this.m_address = m_address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	public String getMempic() {
		return mempic;
	}



	public void setMempic(String mempic) {
		this.mempic = mempic;
	}

}
