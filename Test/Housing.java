package Test;

public class Housing extends Product {
	private double housing_square;
	private String housing_oriented;
	
	public Housing() {
	}

	public Housing(String product_id, String product_name, double product_price, int product_total,
			double housing_square, String housing_oriented) {
		super(product_id, product_name, product_price, product_total);
		this.housing_square = housing_square;
		this.housing_oriented = housing_oriented;
	}

	public double getHousing_square() {
		return housing_square;
	}

	public void setHousing_square(double housing_square) {
		this.housing_square = housing_square;
	}

	public String getHousing_oriented() {
		return housing_oriented;
	}

	public void setHousing_oriented(String housing_oriented) {
		this.housing_oriented = housing_oriented;
	}

	@Override
    public double getTotalPrice() {
        double basePrice = getProduct_price() * getProduct_total() * housing_square;

        // Nếu nhà có hướng Nam hoặc Đông Nam, tăng giá 10%
        if ("Nam".equalsIgnoreCase(housing_oriented) || "Đông Nam".equalsIgnoreCase(housing_oriented)) {
            return basePrice * 1.1;
        } else {
            return basePrice;
        }
    }
	
	@Override
    public String toString() {
        return "Housing [" + super.toString() + ", housing_square=" + housing_square + ", housing_oriented=" + housing_oriented + "]";
    }

	
}
