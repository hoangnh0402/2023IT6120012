package Quan_Li_Sinh_Vien;

public class Student extends Classroom {
	private String student_id;
	private String student_fullName;
	private String address;
	private String zaloPhone;

	public Student() {

	}

	public Student(String student_id, String student_fullName, String address, String zaloPhone) {
		this.student_id = student_id;
		this.student_fullName = student_fullName;
		this.address = address;
		this.zaloPhone = zaloPhone;
	}

	public Student(String class_id, String course_id, double course_fee, String creationDate, int maxStudent,
				   String student_id, String student_fullName, String address, String zaloPhone) {
		super(class_id, course_id, course_fee, creationDate, maxStudent);
		this.student_id = student_id;
		this.student_fullName = student_fullName;
		this.address = address;
		this.zaloPhone = zaloPhone;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_fullName() {
		return student_fullName;
	}

	public void setStudent_fullName(String student_fullName) {
		this.student_fullName = student_fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZaloPhone() {
		return zaloPhone;
	}

	public void setZaloPhone(String zaloPhone) {
		this.zaloPhone = zaloPhone;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + " -- student_id=" + student_id + ", student_fullName="
				+ student_fullName + ", address=" + address + ", zaloPhone=" + zaloPhone + "]";
	}

}