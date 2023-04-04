package Equipos;

public abstract class Trabajador {

	protected String nombre;
	protected String apellido;
	protected int edad;
	protected int antiguedad;
	protected int salario;
	
	public Trabajador(String nombre, String apellido, int edad, int antiguedad) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.antiguedad = antiguedad;
		this.salario = 50000;
	
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public int getSalario() {
		return salario;
	}

	public int calculoAntiguedad() {
		
		int plusPorAntiguedad=10000;
		
		if (antiguedad>0){
			plusPorAntiguedad=plusPorAntiguedad*antiguedad;
			
		}else{
			plusPorAntiguedad=0;
		}
		
		return plusPorAntiguedad;
		
	}
	
	@Override
	public String toString() {	
		
		return  nombre +" "+ apellido + ", tengo " + edad + " a�os, de los cuales "
				+ antiguedad + " he sido parte de este equipo,\npor esa razon gano " 
				+ salario + " euros anuales, ";
		
	}

	abstract public int salario();	
}
