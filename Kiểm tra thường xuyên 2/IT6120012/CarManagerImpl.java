package IT6120012;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class CarManagerImpl implements CarManager {
	private List<Car> carList;

	public CarManagerImpl() {
		carList = new ArrayList<>();
	}

	public CarManagerImpl(List<Car> carList) {
		this.carList = carList;
	}

	@Override
	public void addCar(Car c) {
		carList.add(c);
	}

	@Override
	public void delCar(Car c) {
		for (int i = 0; i < carList.size(); i++) {
			if (c.getProduct_id().equals(carList.get(i).getProduct_id())) {
			    carList.remove(i);
			}
		}
	}

	@Override
	public List<Car> searchCar(String name) {
		List<Car> res = new ArrayList<>();
		for (Car c : carList) {
			if (c.getProduct_name().contains(name)) {
				res.add(c);
			}
		}
		return res;
	}
	
	@Override
	public void editCar() {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Nhập tên xe cần sửa thông tin: ");
	    String nameToEdit = sc.nextLine();
	    List<Car> carsToEdit = searchCar(nameToEdit);

	    if (carsToEdit.isEmpty()) {
	        System.out.println("Không tìm thấy xe có tên " + nameToEdit);
	    } else {
	        System.out.println("Danh sách xe cần sửa thông tin:");
	        for (int i = 0; i < carsToEdit.size(); i++) {
	            System.out.println((i + 1) + ". " + carsToEdit.get(i));
	        }

	        System.out.print("Chọn xe cần sửa (Nhập số thứ tự): ");
	        int carIndexToEdit = sc.nextInt();
	        sc.nextLine(); // Đọc dòng mới sau khi đọc số nguyên

	        if (carIndexToEdit >= 1 && carIndexToEdit <= carsToEdit.size()) {
	            Car carToEdit = carsToEdit.get(carIndexToEdit - 1);
	            System.out.print("Nhập thông tin cập nhật:\n");
	            System.out.print("Nhập tên xe: ");
	            carToEdit.setProduct_name(sc.nextLine());
	            System.out.print("Nhập giá xe: ");
	            carToEdit.setProduct_price(sc.nextDouble());
	            sc.nextLine();
	            System.out.print("Nhập số lượng xe còn lại trong kho: ");
	            carToEdit.setProduct_total(sc.nextInt());
	            sc.nextLine();
	            System.out.print("Nhập hãng xe: ");
	            carToEdit.setBrand(sc.nextLine());
	            System.out.print("Nhập số chỗ ngồi: ");
	            carToEdit.setNumberOfSteats(sc.nextByte());
	            sc.nextLine();
	            System.out.print("Nhập màu xe: ");
	            carToEdit.setColor(sc.nextLine());
	            System.out.println("Thông tin xe đã được cập nhật.");
	        } else {
	            System.out.println("Lựa chọn không hợp lệ.");
	        }
	    }
	}


	// Phương thức hiển thị danh sách xe
	private void displayCarList(List<Car> cars) {
	    for (int i = 0; i < cars.size(); i++) {
	        System.out.println((i + 1) + ". " + cars.get(i));
	    }
	}


	@Override
	public List<Car> sortedCar(boolean isIncrease) {
		List<Car> res = carList;

		Collections.sort(res, new Compare(isIncrease));
		return res;
	}
	
	@Override
    public List<Car> getAllCars() {
        return carList;
    }

	class Compare implements Comparator<Car> {
		private int isIncrease;

		public Compare(boolean isIncrease) {
			this.isIncrease = isIncrease ? 1 : -1;
		}

		@Override
		public int compare(Car o1, Car o2) {
			return isIncrease * Double.compare(o1.getProduct_price(), o2.getProduct_price());
		}

	}
}
