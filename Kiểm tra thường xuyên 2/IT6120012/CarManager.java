package IT6120012;

import java.util.List;

public interface CarManager {
	
	void addCar(Car c);

	void editCar();

	void delCar(Car c);

	List<Car> searchCar(String name);

	List<Car> sortedCar(boolean isIncrease);
	
	List<Car> getAllCars();
	
}
