package Equipos;

public class Bolido {

	private int potencia;
	private int velocidad;
	private String color;
	private int precio;
	
	public Bolido(int potencia, int velocidad, String color, int precio) {
		this.potencia = potencia;
		this.velocidad = velocidad;
		this.color = color;
		this.precio = precio;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getColor() {
		return color;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		
		return " Tiene una potencia de " + potencia + " Caballos de fuerza,\nuna velocidad de "
				+ velocidad + " kilometros por hora, es de color " + color + ",\ny su precio ronda los " + precio
				+ " euros.\n";
	}
	
	
}
