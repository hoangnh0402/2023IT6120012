package Quan_Li_Sinh_Vien;

import java.util.List;

public interface ABCTrainningService {
	double totalFee();

	void addStudent(Student student, int index);

	void generateRandomStudents(int numStudents, int indexClass);

	void printStudent(int indexClass);

	List<Student> getStudents(int indexClass);

	void printClassStatistics();

	void sortClassListByName(int indexClass);

	void searchStudentByName(String searchName);
}