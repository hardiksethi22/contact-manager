package com.hardiksethi.contactmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {

	public Contact() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private int contact_id;
	private String contact_name;
	private String contact_second_name;
	private String contact_work;
	private String contact_phone;
	private String contact_email;
	private String contact_image_url;
	@Column(length = 5000)
	private String contact_description;
	
	@ManyToOne
	private User user;
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_second_name() {
		return contact_second_name;
	}
	public void setContact_second_name(String contact_second_name) {
		this.contact_second_name = contact_second_name;
	}
	public String getContact_work() {
		return contact_work;
	}
	public void setContact_work(String contact_work) {
		this.contact_work = contact_work;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getContact_image_url() {
		return contact_image_url;
	}
	public void setContact_image_url(String contact_image_url) {
		this.contact_image_url = contact_image_url;
	}
	public String getContact_description() {
		return contact_description;
	}
	public void setContact_description(String contact_description) {
		this.contact_description = contact_description;
	}
	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", contact_name=" + contact_name + ", contact_second_name="
				+ contact_second_name + ", contact_work=" + contact_work + ", contact_phone=" + contact_phone
				+ ", contact_email=" + contact_email + ", contact_image_url=" + contact_image_url
				+ ", contact_description=" + contact_description + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Contact(int contact_id, String contact_name, String contact_second_name, String contact_work,
			String contact_phone, String contact_email, String contact_image_url, String contact_description,
			User user) {
		super();
		this.contact_id = contact_id;
		this.contact_name = contact_name;
		this.contact_second_name = contact_second_name;
		this.contact_work = contact_work;
		this.contact_phone = contact_phone;
		this.contact_email = contact_email;
		this.contact_image_url = contact_image_url;
		this.contact_description = contact_description;
		this.user = user;
	}
	
	
}
