package pojos;

public class HealthProfile {
	private double weight; // in kg
	private double height; // in m
	
	public HealthProfile(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}

	public HealthProfile() {
		this.weight = 85.5;
		this.height = 1.72;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getBmi() {
		return weight / (Math.pow(height,2));
	}

	public String toString() {
		return "Height="+height+", Weight="+weight;
	}
}
