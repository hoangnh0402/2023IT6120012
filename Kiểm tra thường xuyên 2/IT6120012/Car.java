package IT6120012;

import java.util.ArrayList;
import java.util.List;

public class Car extends Product {
	private String brand;
	private byte numberOfSteats;
	private String color;

	public Car() {

	}

	public Car(String product_id, String product_name, double product_price, int product_total, String brand,
			byte numberOfSteats, String color) {
		super(product_id, product_name, product_price, product_total);
		this.brand = brand;
		this.numberOfSteats = numberOfSteats;
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public byte getNumberOfSteats() {
		return numberOfSteats;
	}

	public void setNumberOfSteats(byte numberOfSteats) {
		if (numberOfSteats > 0) {
			this.numberOfSteats = numberOfSteats;
		} else {
			System.out.println("Số ghế ngồi trên xe không thể âm.");
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car{" + super.toString() + ", brand ='" + this.brand + ", color =" + this.color
				+ ", numberOfSteats = " + this.numberOfSteats + '}';
	}
}
