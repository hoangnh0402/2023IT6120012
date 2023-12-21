package Test;

import java.util.List;

public interface HousingManager {
//	void generateList(int n);
	
	void addHousing(Housing h);

	void delHousing(Housing h);

	List<Housing> searchHousing(String name);
	
	List<Housing> searchHousing(double price);
	
	List<Housing> sortedHousing();
	
	double getToTal();
};