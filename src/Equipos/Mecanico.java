package Equipos;

public class Mecanico extends Trabajador{

	private String estudios;

	public Mecanico(String nombre, String apellido, int edad, int antiguedad, String estudios) {
		super(nombre, apellido, edad, antiguedad);
		super.salario = salario();
		this.estudios = estudios(estudios);
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	
	public String estudios(String estudios) {
		
		if(estudios.equalsIgnoreCase("Si")) {
			
			return " y tengo estudios superiores de mec�nica.\n";
		}else {
			return " y tengo estudios t�cnicos de mec�nica.\n";
		}
		
	}

	@Override
	public int salario() {
		
		int plusAntiguedad=calculoAntiguedad();
		
		int salarioMecanico=salario+plusAntiguedad;
		
		return salarioMecanico;
		
	}
	

	@Override
	public String toString() {
		return "Soy el Mecanico " +super.toString() + estudios ;
	}

}
