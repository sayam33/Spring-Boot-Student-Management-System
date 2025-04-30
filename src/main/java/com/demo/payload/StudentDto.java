package com.demo.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDto {
	
			private long id;
			@NotNull
			@Size(min = 3, max = 24, message = "Should be atlist 3 characters")
		private String name;
		private String course;
		@Email
		private String email;
		@Size(min = 10, max = 10, message = "Should be 10 digits")
		private String mobile;
		//private String message; 
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		//public String getMessage() {
		//	return message;
		//}
		//public void setMessage(String message) {
		//	this.message = message;
		//}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
	}