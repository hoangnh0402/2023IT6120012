package Quan_Li_Sinh_Vien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunningMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tạo danh sách lớp học
        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(new Classroom("IT101", "Java Programming", 1000.0, "2023-01-01", 20));
        classrooms.add(new Classroom("IT102", "Web Development", 1200.0, "2023-02-01", 15));
        classrooms.add(new Classroom("IT103", "Data Science", 1500.0, "2023-03-01", 25));

        // Tạo danh sách sinh viên và dịch vụ quản lý
        ABCTrainningService trainingService = new ABCTrainningServiceImpl(classrooms);
        while (true) {
            System.out.println("1. Sinh sinh viên ngẫu nhiên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Tính tổng phí");
            System.out.println("4. Sắp xếp sinh viên theo tên");
            System.out.println("5. Tìm sinh viên theo tên");
            System.out.println("6. Hiển thị thông tin lớp");
            System.out.println("7. Hiển thị số lượng sinh viên");
            System.out.println("8. Hiển thị tất cả sinh viên");
            System.out.println("9. Hiển thị thống kê số lượng sinh viên trong từng lớp");
            System.out.println("0. Thoát");

            System.out.print("Chọn một chức năng thứ: ");
            int luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 2:
                    System.out.print("Nhập tên sinh viên: ");
                    String ten = sc.nextLine();
                    System.out.print("Nhập địa chỉ sinh viên: ");
                    String diaChi = sc.nextLine();
                    System.out.print("Nhập số điện thoại Zalo: ");
                    String zaloPhone = sc.nextLine();

                    // Chọn lớp để thêm sinh viên
                    int lopChon = chonLop(classrooms);
                    if (lopChon >= 0 && lopChon < classrooms.size()) {
                        Student student = new Student(
                                classrooms.get(lopChon).getClass_id(),
                                classrooms.get(lopChon).getCourse_id(),
                                classrooms.get(lopChon).getCourse_fee(),
                                classrooms.get(lopChon).getCreationDate(),
                                classrooms.get(lopChon).getMaxStudent(),
                                "sv" + (trainingService.getStudents(lopChon).size() + 1),
                                ten,
                                diaChi,
                                zaloPhone
                        );
                        System.out.println(student.toString());
                        trainingService.addStudent(student , lopChon);
                        System.out.println("Sinh viên đã được thêm vào lớp " + classrooms.get(lopChon).getClass_id());
                    } else {
                        System.out.println("Lựa chọn lớp không hợp lệ.");
                    }
                    break;

                case 3:
                    double tongPhi = trainingService.totalFee();
                    System.out.println("Tổng phí cho tất cả các lớp: " + tongPhi);
                    break;

                case 1:
                    int lopSinhNgauNhien = chonLop(classrooms);
                    if (lopSinhNgauNhien >= 0 && lopSinhNgauNhien < classrooms.size()) {
                        System.out.print("Nhập số lượng sinh viên cần sinh ngẫu nhiên: ");
                        int soLuongSinhVien = sc.nextInt();
                        sc.nextLine();
                        trainingService.generateRandomStudents(soLuongSinhVien , lopSinhNgauNhien);
                        System.out.println("Sinh viên ngẫu nhiên đã được thêm vào lớp " + classrooms.get(lopSinhNgauNhien).getClass_id());
                    } else {
                        System.out.println("Lựa chọn lớp không hợp lệ.");
                    }
                    break;

                case 4:
                    int lopSapXep = chonLop(classrooms);
                    if (lopSapXep >= 0 && lopSapXep < classrooms.size()) {
                        trainingService.sortClassListByName(lopSapXep);
                        System.out.println("Sinh viên trong lớp " + classrooms.get(lopSapXep).getClass_id() + " đã được sắp xếp theo tên.");
                    } else {
                        System.out.println("Lựa chọn lớp không hợp lệ.");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String tenSinhVienTimKiem = sc.nextLine();
                    trainingService.searchStudentByName(tenSinhVienTimKiem);
                    break;

                case 6:
                    int lopHienThiThongTin = chonLop(classrooms);
                    if (lopHienThiThongTin >= 0 && lopHienThiThongTin < classrooms.size()) {
                        System.out.println("Thông tin lớp học:");
                        System.out.println(classrooms.get(lopHienThiThongTin));
                    } else {
                        System.out.println("Lựa chọn lớp không hợp lệ.");
                    }
                    break;

                case 7:
                    trainingService.printClassStatistics();
                    break;

                case 8:
                    int lopHienThiSinhVien = chonLop(classrooms);
                    if (lopHienThiSinhVien >= 0 && lopHienThiSinhVien < classrooms.size()) {
                        System.out.println("Danh sách sinh viên trong lớp " + classrooms.get(lopHienThiSinhVien).getClass_id() + ":");
                        trainingService.printStudent(lopHienThiSinhVien);
                    } else {
                        System.out.println("Lựa chọn lớp không hợp lệ.");
                    }
                    break;

                case 9:
                    trainingService.printClassStatistics();
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức để chọn lớp từ danh sách và trả về chỉ số của lớp
    private static int chonLop(List<Classroom> classrooms) {
        System.out.println("Danh sách các lớp học:");
        for (int i = 0; i < classrooms.size(); i++) {
            System.out.println((i + 1) + ". " + classrooms.get(i).getClass_id());
        }

        System.out.print("Chọn một lớp: ");
        Scanner sc = new Scanner(System.in);
        int lopChon = sc.nextInt();
        sc.nextLine();

        // Chuyển về chỉ số của lớp trong danh sách (chỉ số bắt đầu từ 0)
        return lopChon - 1;
    }
}
