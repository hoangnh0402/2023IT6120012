package Quan_Li_Sinh_Vien;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

	protected String class_id;
	protected String course_id;
	protected double course_fee;
	protected String creationDate;
	protected int maxStudent;
	protected List<Student> students = new ArrayList<>();


	// Constructor không tham số
	public Classroom() {

	}

	// Constructor có tham số
	public Classroom(String class_id, String course_id, double course_fee, String creationDate, int maxStudent) {

		this.class_id = class_id;
		this.course_id = course_id;
		this.course_fee = course_fee;
		this.creationDate = creationDate;
		this.maxStudent = maxStudent;
	}

	// Getter and setter
	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public double getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(double course_fee) {
		this.course_fee = course_fee;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}
	
	public List<Student> getStudents() {
		return students ;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	// Other methods
	public String toString() {
		return "Classroom [class_id=" + class_id + ", course_id=" + course_id + ", course_fee=" + course_fee
				+ ", creationDate=" + creationDate + ", maxStudent=" + maxStudent + "]";
	}
}