package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HousingManagerImpl implements HousingManager {
	private ArrayList<Housing> list;

	@Override
	public void addHousing(Housing h) {
		list.add(h);
	}

	@Override
	public void delHousing(Housing h) {
		for (int i = 0; i < list.size(); i++) {
			if (h.getProduct_id().equals(list.get(i).getProduct_id())) {
			    list.remove(i);
			}
		}
	}

	@Override
	public List<Housing> searchHousing(String name) {
		List<Housing> housing = new ArrayList<>();
		for (Housing c : list) {
			if (c.getProduct_name().contains(name)) {
				housing.add(c);
			}
		}
		return housing;
	}

	@Override
	public List<Housing> searchHousing(double price) {
	        List<Housing> result = new ArrayList<>();
	        for (Housing housing : list) {
	            // Logic tìm kiếm dựa trên giá
	            if (housing.getTotalPrice() <= price) {
	                result.add(housing);
	            }
	        }
	        return result;
	    }
	
	@Override
    public List<Housing> sortedHousing() {
        // Sắp xếp danh sách theo giá tăng dần bằng lambda
        list.sort((housing1, housing2) -> Double.compare(housing1.getTotalPrice(), housing2.getTotalPrice()));

        return list;
    }
	

	@Override
	public double getToTal() {
		double total = 0.0;
	    for (Housing housing : list) {
	        total += housing.getTotalPrice();
	    }
	    return total;
	}

}
