package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 long id;
	@Column
 int rollno;
	@Column
 String fees;
	public Register(long id, int rollno, String fees) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.fees = fees;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", rollno=" + rollno + ", fees=" + fees + "]";
	}
	
}
