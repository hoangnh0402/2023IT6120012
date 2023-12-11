package Quan_Li_Sinh_Vien;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ABCTrainningServiceImpl implements ABCTrainningService {
    private List<Classroom> classrooms ;

    public List<Classroom> getClassrooms() {
        return classrooms;
    }


    // Constructor
    public ABCTrainningServiceImpl(List<Classroom> classrooms) {
        this.classrooms = classrooms ;
    }

    @Override
    public double totalFee() {
        double ans = 0.0 ;
        for(Classroom x : classrooms){
            ans = ans + x.course_fee ;
        }
        return ans ;
    }

    @Override
    public void addStudent(Student student , int index) {

        if (classrooms.get(index).getStudents().size() < classrooms.get(index).getMaxStudent()) {
            classrooms.get(index).getStudents().add(student) ;
        }

    }

    @Override
    public void generateRandomStudents(int numStudents , int indexClass) {
        String[] studentFullNames = { "Nguyễn Huy Hoàng", "Trần Tuấn Anh", "Lương Thái Sơn", "Đào Duy Chiến",
                "Nguyễn Thành Đạt", "Nguyễn Diệu Linh" };
        String[] addresses = { "Phú Thọ", "Nghệ An", "Hải Phòng", "Thanh Hóa", "Hải Dương", "Phú Thọ" };
        String[] zaloPhones = { "0123", "0456", "07897", "023545", "0402", "2004", "080604", "13456", "9766354" };

        for (int i = 0; i < numStudents; i++) {
            Student student = new Student(classrooms.get(indexClass).getClass_id(), classrooms.get(indexClass).getCourse_id(), classrooms.get(indexClass).getCourse_fee(),
                    classrooms.get(indexClass).getCreationDate(), classrooms.get(indexClass).getMaxStudent(), "sv" + i + 1, studentFullNames[i % studentFullNames.length],
                    addresses[i % addresses.length], zaloPhones[i % zaloPhones.length]);
            addStudent(student , indexClass);
        }
    }

    @Override
    public void printStudent(int indexClass) {
        if (indexClass < classrooms.size()) {
            for (Student student : classrooms.get(indexClass).getStudents()) {
                System.out.println(student);
            }
        } else {
            System.out.println("Danh sách sinh viên là null.");
        }
    }

    @Override
    public List<Student> getStudents(int indexClass) {
        return classrooms.get(indexClass).getStudents();
    }

    @Override
    public void printClassStatistics() {
        System.out.println("Số lượng thống kê trong từng lớp học:");
        for(Classroom x : classrooms){
            System.out.println(x.toString() + ":" + x.getStudents().size());
        }
    }

    @Override
    public void sortClassListByName(int indexClass) {
        Collections.sort(classrooms.get(indexClass).getStudents(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudent_fullName().compareTo(o2.getStudent_fullName() );
            }
        });
    }

    @Override
    public void searchStudentByName(String searchName) {
        int f = 0 ;
        for(Classroom x : classrooms){
            for(Student y : x.getStudents()){
                if(y.getStudent_fullName().equals(searchName)){
                    System.out.println(y.toString());
                    f=1  ;
                }
            }
        }
        if(f == 0 )
         System.out.println("Student with name '" + searchName + "' not found.");
    }
}