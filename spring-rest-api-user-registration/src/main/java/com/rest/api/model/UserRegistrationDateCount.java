package com.rest.api.model;





import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegistrationDateCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private int count;
	public UserRegistrationDateCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegistrationDateCount(Date date, int count) {
		super();
		this.date = date;
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "UserRegistrationDateCount [date=" + date + ", count=" + count + "]";
	}
	
	
}
