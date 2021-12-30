package com.hardiksethi.contactmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "USER")
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	@NotBlank(message = "User Name can't be null")
	@Size(min = 2, max= 20 , message="min 2 and max 20 characters are allowed")
	private String user_name;
	@Column(unique = true)
	@Email
	private String user_email;
	private String user_role;
	private String user_password;
	private boolean user_enabled;
	private String user_image_url;
	@Column(length = 500)
	private String user_about;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonBackReference
	private List<Contact> contact_list = new ArrayList<Contact>();
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public boolean isUser_enabled() {
		return user_enabled;
	}
	public void setUser_enabled(boolean user_enabled) {
		this.user_enabled = user_enabled;
	}
	public String getUser_image_url() {
		return user_image_url;
	}
	public void setUser_image_url(String user_image_url) {
		this.user_image_url = user_image_url;
	}
	public String getUser_about() {
		return user_about;
	}
	public void setUser_about(String user_about) {
		this.user_about = user_about;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_role="
				+ user_role + ", user_password=" + user_password + ", user_enabled=" + user_enabled
				+ ", user_image_url=" + user_image_url + ", user_about=" + user_about + ", contact_list=" + contact_list
				+ "]";
	}
	public List<Contact> getContact_list() {
		return contact_list;
	}
	public void setContact_list(List<Contact> contact_list) {
		this.contact_list = contact_list;
	}
	public User(int user_id, String user_name, String user_email, String user_role, String user_password,
			boolean user_enabled, String user_image_url, String user_about, List<Contact> contact_list) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_role = user_role;
		this.user_password = user_password;
		this.user_enabled = user_enabled;
		this.user_image_url = user_image_url;
		this.user_about = user_about;
		this.contact_list = contact_list;
	}
	
	
}
