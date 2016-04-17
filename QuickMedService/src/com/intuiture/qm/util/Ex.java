package com.intuiture.qm.util;

public class Ex {
	public static void main(String[] args) {
		User user = new User.UserBuilder("Siva").setAge(28).setIsMale(true).getUserInstance();
		System.out.println(user.getName());
	}

	public void disp() {
	}
}

class User {
	private String name;
	private Integer age;
	private Boolean isMale;

	private User(UserBuilder userBuilder) {
		this.name = userBuilder.name;
		this.age = userBuilder.age;
		this.isMale = userBuilder.isMale;
	}

	public String getName() {
		return name;
	}

	public static class UserBuilder {
		private String name;
		private Integer age;
		private Boolean isMale;

		public UserBuilder(String name) {
			this.name = name;
		}

		public UserBuilder setAge(Integer age) {
			this.age = age;
			return this;
		}

		public UserBuilder setIsMale(Boolean isMale) {
			this.isMale = isMale;
			return this;
		}

		public User getUserInstance() {
			return new User(this);
		}
	}
}
