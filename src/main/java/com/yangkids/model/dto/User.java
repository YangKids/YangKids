package com.yangkids.model.dto;

public class User {
	private int numId;
	private String id;
	private String name;
	private String phoneNumber;
	private String email;
	private int generation;
	private String password;
	private int age = 0;
	private String teacher;
	private String passwordHint;
	private String passwordAnswer;
	private String img = null; // 기본 프로필 이미지 정해지면 그 이미지의 url로 넣어야 할 듯!
	private String gender;
	private int isEmployed;
	private String address = null;
	private String detailAddress = null;
	private String campus;
	private String birth;
	private int isAdmin = 0;
	private String studentId;

	public User() {

	}

	public User(int numId, String name, String phoneNumber, String email, int generation, String id, String password,
			int age, String teacher, String passwordHint, String passwordAnswer, String img, String gender,
			int isEmployed, String address, String detailAddress, String campus, String birth, int isAdmin,
			String studentId) {
		super();
		this.numId = numId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.generation = generation;
		this.id = id;
		this.password = password;
		this.age = age;
		this.teacher = teacher;
		this.passwordHint = passwordHint;
		this.passwordAnswer = passwordAnswer;
		this.img = img;
		this.gender = gender;
		this.isEmployed = isEmployed;
		this.address = address;
		this.detailAddress = detailAddress;
		this.campus = campus;
		this.birth = birth;
		this.isAdmin = isAdmin;
		this.studentId = studentId;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIsEmployed() {
		return isEmployed;
	}

	public void setIsEmployed(int isEmployed) {
		this.isEmployed = isEmployed;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "User [numId=" + numId + ", id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", generation=" + generation + ", password=" + password + ", age=" + age + ", teacher="
				+ teacher + ", passwordHint=" + passwordHint + ", passwordAnswer=" + passwordAnswer + ", img=" + img
				+ ", gender=" + gender + ", isEmployed=" + isEmployed + ", address=" + address + ", detailAddress="
				+ detailAddress + ", campus=" + campus + ", birth=" + birth + ", isAdmin=" + isAdmin + ", studentId="
				+ studentId + "]";
	}

}
