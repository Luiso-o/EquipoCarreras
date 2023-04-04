package Equipos;

public class Piloto extends Trabajador{

	private int altura;
	private int peso;
	
	public Piloto(String nombre, String apellido, int edad, int antiguedad, int altura, int peso) {
		
		super(nombre, apellido, edad, antiguedad);
		super.salario = salario();
		this.altura = altura;
		this.peso = peso;
			
	}

	public int getAltura() {
		return altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int salario() {
		
		int plusAntiguedad=calculoAntiguedad();
		int plusPeligrosidad=50000;
		
		int salarioPiloto=salario+plusPeligrosidad+plusAntiguedad;
		
		return salarioPiloto;
		
	}
	

	@Override
	public String toString() {
		return "Soy la/el Piloto " + super.toString() + "mi altura es de "
				+ altura + " centimetros y peso " + peso + " kilogramos.\n";
	}
	
	
	
}
