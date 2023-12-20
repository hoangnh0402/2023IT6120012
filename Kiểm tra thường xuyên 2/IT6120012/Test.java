
package IT6120012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Car> cars = new ArrayList<>();

		cars.add(new Car("STT1", "I8", 5000000.0, 5, "BMW", (byte) 2, "Black"));
		cars.add(new Car("STT2", "Aventador", 1000000, 2, "Lamborghini", (byte) 1, "Green"));
		cars.add(new Car("STT3", "Lux-A", 3000000, 10, "Vinfast", (byte) 5, "Red"));
		Car c = new Car("STT4", "Camry", 2000000, 5, "Toyota", (byte) 4, "Black");

		CarManager manager = new CarManagerImpl(cars);

		while (true) {
			System.out.println("1. Thêm xe");
			System.out.println("2. Sửa thông tin xe");
			System.out.println("3. Xóa xe");
			System.out.println("4. Tìm kiếm xe");
			System.out.println("5. Sắp xếp xe");
			System.out.println("6. In ra danh sách xe");
			System.out.println("0. Thoát");

			System.out.print("Chọn một chức năng: ");
			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
			case 1:
				manager.addCar(c);
				System.out.println("Xe đã được thêm vào danh sách.");
				break;

			case 2:
				manager.editCar();
				break;

			case 3:
				System.out.print("Nhập tên xe cần xóa: ");
				String nameToDelete = sc.nextLine();
				Car carToDelete = manager.searchCar(nameToDelete).get(0);
				manager.delCar(carToDelete);
				System.out.println("Xe đã được xóa khỏi danh sách.");
				break;

			case 4:
				System.out.print("Nhập tên xe cần tìm kiếm: ");
				String nameToSearch = sc.nextLine();
				List<Car> searchResult = manager.searchCar(nameToSearch);
				if (searchResult.isEmpty()) {
					System.out.println("Không tìm thấy xe có tên " + nameToSearch);
				} else {
					System.out.println("Danh sách xe tìm kiếm:");
					for (Car carFound : searchResult) {
						System.out.println(carFound);
					}
				}
				break;

			case 5:
				System.out.print("Sắp xếp danh sách xe theo giá:\n");
				System.out.print("1. Tăng dần\n2. Giảm dần\nChọn: ");
				boolean isIncrease = (sc.nextInt() == 1);
				List<Car> sortedCars = manager.sortedCar(isIncrease);
				System.out.println("Danh sách xe sau khi sắp xếp:");
				for (Car sortedCar : sortedCars) {
					System.out.println(sortedCar);
				}
				break;
			
			case 6:
			    System.out.println("Danh sách xe có trong kho:");
			    List<Car> allCars = manager.getAllCars();
			    if (allCars.isEmpty()) {
			        System.out.println("Không có xe nào trong kho.");
			    } else {
			        for (Car car : allCars) {
			            System.out.println(car);
			        }
			    }
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
}
