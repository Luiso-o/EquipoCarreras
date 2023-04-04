package Equipos;

import java.util.ArrayList;

public class Escuderia {

	private String nombre;
	private int presupuesto;
	private String origen;
	ArrayList<Bolido>coches;
	ArrayList<Trabajador>trabajadores;
	
	public Escuderia(String nombre, int presupuesto, String origen) {
		
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.origen = origen;
		this.coches = new ArrayList<>();
		this.trabajadores = new ArrayList<>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public String getOrigen() {
		return origen;
	}

	public ArrayList<Bolido> getCoches() {
		return coches;
	}

	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}
	
	@Override
	public String toString() {
		return "La Escuderia " + nombre + " Cuenta con un presupuesto de " + presupuesto +
				" y son originarios de " + origen+".\n";
	}
	
}
