package com.skcet.flightbooking.entity;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="Login_details")
	public class LoginEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String fname;
		private String mname;
		private String lname;
		private String emailid;
		private String password;
		public LoginEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LoginEntity(int id, String fname, String mname, String lname, String emailid, String password) {
			super();
			this.id = id;
			this.fname = fname;
			this.mname = mname;
			this.lname = lname;
			this.emailid = emailid;
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

}
