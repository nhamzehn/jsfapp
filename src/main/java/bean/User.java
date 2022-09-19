package bean;

import java.util.Date;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private double expectedSalary;
	private String sex;
	private String mobile;
	private Date birthDate;
	private String country;
	private String email;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", sex=" + sex + ", birthDate=" + birthDate + ", country="
				+ country + ", email=" + email + ", password=" + password + "]";
	}

	public double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
