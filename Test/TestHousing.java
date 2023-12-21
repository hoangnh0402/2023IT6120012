package Test;

import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
public class TestHousing {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Housing> a = new ArrayList<>();
		a.add(new Housing("STT1", "Vincom", 200, 3, 4.0, "Đông Nam"));
		a.add(new Housing("STT2", "Vinhouse", 400, 1, 5.0, "Nam"));
		a.add(new Housing("STT3", "telecom", 600, 5, 7.0, "Đông Bắc"));
		a.add(new Housing("STT4", "FPT", 700, 2, 4.0, "Tây Nam"));
		
		Housing b = new Housing("STT5", "Lotteria", 300, 1, 2.0, "Tây Bắc");
		HousingManagerImpl housingManager = new HousingManagerImpl();

		int choice;
		while (true) {
			System.out.println("1. Add Housing");
			System.out.println("2. Delete Housing");
			System.out.println("3. Search Housing by Name");
			System.out.println("4. Search Housing by Price");
			System.out.println("5. Sort Housing by Price");
			System.out.println("6. Display Total Price");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				housingManager.addHousing(b);
				System.out.println("Housing đã được thêm vào danh sách.");
				break;
			case 2:
				System.out.print("Nhập tên xe cần xóa: ");
				String nameToDelete = scanner.nextLine();
				Housing housingToDelete = housingManager.searchHousing(nameToDelete).get(0);
				housingManager.delHousing(housingToDelete);
				System.out.println("Xe đã được xóa khỏi danh sách.");
				break;
			case 3:
				// Search Housing by Name
				System.out.print("Enter name to search: ");
				String name = scanner.next();
				housingManager.searchHousing(name).forEach(System.out::println);
				break;
			case 4:
				// Search Housing by Price
				System.out.print("Enter maximum price to search: ");
				double maxPrice = scanner.nextDouble();
				housingManager.searchHousing(maxPrice).forEach(System.out::println);
				break;
			case 5:
				// Sort Housing by Price
				housingManager.sortedHousing().forEach(System.out::println);
				break;
			case 6:
				// Display Total Price
				System.out.println("Total Price: " + housingManager.getToTal());
				break;
			case 0:
				// Exit
				System.out.println("Exiting program. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}
}
