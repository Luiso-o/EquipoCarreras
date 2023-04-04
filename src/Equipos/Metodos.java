package Equipos;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

	public static int menu() {
		
		int opcion=pideInt("Que desea realizar?\n\n1-Dar de alta Trabajador\n"
				+ "2-Dar de baja Trabajador\n3-Ver escuderia\n\n<<Salir cualquier # fuera de las opciones antes mencionadas.>>");
		
		return opcion;	
	}
	
	public static void nuevoTrabajador(ArrayList<Escuderia>equipos,String nombre,String apellido) {
		
		String nombreEscuderia=pideString("En que equipo trabajar�?");
		int indiceEquipo=encuentraEquipo(equipos,nombreEscuderia);
		boolean indiceTrabajador=verificarTrabajador(equipos,nombre,apellido,indiceEquipo);
		
			if(!indiceTrabajador) {
				
				String opcion=pideString("Cual es su profesion?");
				
					switch(opcion.toUpperCase()) {
					
						case "PILOTO":
							
							equipos.get(indiceEquipo).trabajadores.add(new Piloto(nombre,apellido,pideInt("Introduce la edad"),0,
									pideInt("Introduce la altura"),pideInt("Introduce el peso")));
							
								System.out.println(nombre+" "+apellido + " es el nuevo Piloto del equipo " + nombreEscuderia+" :)\n");
								
									break;
								
						case "MECANICO":
							
							equipos.get(indiceEquipo).trabajadores.add(new Mecanico(nombre,apellido,pideInt("Introduce la edad"),0,
									pideString("tiene estudios superiores de mec�nica?")));
								
								System.out.println(nombre+" "+apellido + " es el nuevo Mec�nico del equipo " + nombreEscuderia+" :)\n");
								
									break;
					
					}
					
				
			}else {
				
				String profesion=pideString("Ya existe un trabajador con este nombre, que profesion desempe�ar�?");
				
					switch(profesion.toUpperCase()) {
					
						case "PILOTO":
							
							if(!verificarPiloto(equipos.get(indiceEquipo).getTrabajadores(),nombre,apellido)) {
								
								equipos.get(indiceEquipo).trabajadores.add(new Piloto(nombre,apellido,pideInt("Introduce la edad"),0,
										pideInt("Introduce la altura"),pideInt("Introduce el peso")));
									
									System.out.println(nombre+" "+apellido + " es el nuevo Piloto del equipo " + nombreEscuderia+" :)\n");
									
							}else {
								
								System.out.println("Ya existe un Piloto llamado " +nombre+" "+apellido+ " en el equipo "+nombreEscuderia+" :/\n");
								
							}
								
									break;
								
						case "MECANICO":
							
							if(!verificarMecanico(equipos.get(indiceEquipo).getTrabajadores(),nombre,apellido)) {
								
								equipos.get(indiceEquipo).trabajadores.add(new Mecanico(nombre,apellido,pideInt("Introduce la edad"),0,
										pideString("tiene estudios superiores de mec�nica?")));
									
									System.out.println(nombre+" "+apellido + " es el nuevo Mecanico del equipo " + nombreEscuderia+" :)\n");
									
							}else {
								
								System.out.println("Ya existe un Mec�nico llamado " +nombre+" "+apellido+ " en el equipo "+nombreEscuderia+" :/\n");
								
							}
								
									break;
			}
		
		}
		
	}
	
	public static void eliminarTrabajador(ArrayList<Escuderia>equipos,String nombre,String apellido) {
		//verifico que el nombre y apellido coincida con la lista de trabajadores
		if(!verificarNombre(equipos,nombre,apellido)) {
			
			while(!verificarNombre(equipos,nombre,apellido)) {
				
				System.out.println("No existe un trabajador llamado/a "+nombre+" "+apellido+" :/");
				
					nombre=Metodos.pideString("Introduce el nombre");
					apellido=Metodos.pideString("Introduce el apellido");
				
						verificarNombre(equipos,nombre,apellido);
						
				}
			}
		
		//verifico si la escuderia existe
		String nombreEscuderia=pideString("En que equipo trabaja?");
		
			int indiceEquipo=encuentraEquipo(equipos,nombreEscuderia);
			
				if(indiceEquipo==-1) {
					System.out.println("Esta escuderia no existe X_X\n");
					
					while(indiceEquipo==-1) {
						
						indiceEquipo=encuentraEquipo(equipos,pideString("Introduce una escuderia valida"));
						
					}
					
				}else {//verifico si la escuderia concuerda con el nombre del trabajador
					
					Boolean verificar=verificarTrabajador(equipos,nombre,apellido,indiceEquipo);
					
						if(!verificar) {
							
							System.out.println(nombre+" "+apellido+ " no trabaja en "+nombreEscuderia+" :/");
								
								while(!verificarTrabajador(equipos,nombre,apellido,indiceEquipo)) {
									
									nombreEscuderia=pideString("Introduce una escuderia valida:");
									
										indiceEquipo=encuentraEquipo(equipos,nombreEscuderia);
										
											verificar=verificarTrabajador(equipos,nombre,apellido,indiceEquipo);
										
								}	
						}
				}
				
			//verifico si existen dos trabajadores con el mismo nombre en la escuderia	
			int trabajadores=trabajadoresConMismoNombre(equipos.get(indiceEquipo).trabajadores,nombre,apellido);
			int indiceTrabajador;
			
			if(trabajadores>1) {
				
				String elige=pideString("Existe un mec�nico y un piloto con el mismo nombre, introduce "
						+ "la profesion del trabajador que quieres eliminar");
				
					switch(elige.toUpperCase()) {
					
						case "PILOTO":
							
							indiceTrabajador=indicePiloto(equipos.get(indiceEquipo).trabajadores,nombre,apellido);
							
								equipos.get(indiceEquipo).trabajadores.remove(indiceTrabajador);
								
									System.out.println("El/La Piloto "+nombre+" "+apellido+ 
											" a sido removido de la escuderia "+ nombreEscuderia+".\n");
								
										break;
										
						case "MECANICO":
							
							indiceTrabajador=indiceMecanico(equipos.get(indiceEquipo).trabajadores,nombre,apellido);
							
								equipos.get(indiceEquipo).trabajadores.remove(indiceTrabajador);
							
									System.out.println("El/La Mecanico "+nombre+" "+apellido+ 
										" a sido removido de la escuderia "+ nombreEscuderia+".\n");
							
										break;
					
						}//switch
					
					
				}else {
						
					indiceTrabajador=indiceTrabajador(equipos.get(indiceEquipo).getTrabajadores(),nombre,apellido);
						
						equipos.get(indiceEquipo).trabajadores.remove(indiceTrabajador);
						
							if(equipos.get(indiceEquipo).trabajadores.get(indiceTrabajador) instanceof Piloto) {
								
								System.out.println("El Piloto "+nombre+" "+apellido+ 
										" a sido removido de la escuderia "+ nombreEscuderia+".\n");
								
							}else {
								
								System.out.println("El Mecanico "+nombre+" "+apellido+ 
										" a sido removido de la escuderia "+ nombreEscuderia+".\n");
				
							}
							
					}
			
			}
		
	public static void verEquipos(ArrayList<Escuderia>equipos) {
		
		verEscuderias(equipos);
		
		String nombreEscuderia=pideString("Deseas ver una escuderia en especifico? dime su nombre:");
		int indiceEquipo=encuentraEquipo(equipos,nombreEscuderia);
		
		String opcion=pideString("Que deseas ver? Trabajadores o Bolidos?");
		
			switch(opcion.toUpperCase()) {
			
				case "TRABAJADORES":
				
					verTrabajadores(equipos.get(indiceEquipo).getTrabajadores());
					
						break;
						
				case "BOLIDOS":
					
					verBolidos(equipos.get(indiceEquipo).getCoches());
						
						break;
			}
		
	}
	
	public static boolean verificarNombre(ArrayList<Escuderia>equipos,String nombre,String apellido) {
		
		boolean existe=false;
		int indice=0;
		
		while(indice<equipos.size() && existe==false){
			equipos.get(indice);
			
			for(int i=0; i<equipos.get(indice).getTrabajadores().size(); i++) {
				if(equipos.get(indice).getTrabajadores().get(i).getNombre().equalsIgnoreCase(nombre) &&
					equipos.get(indice).getTrabajadores().get(i).getApellido().equalsIgnoreCase(apellido)){
		
						existe=true;
		
					}
				}
			indice++;
			}

				return existe;

	}	
	
	public static boolean verificarPiloto(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		Trabajador trabajador = null;
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i<lista.size()) {
			
			trabajador=lista.get(i);
			
				if(trabajador instanceof Piloto && trabajador.getNombre().equalsIgnoreCase(nombre) &&
						trabajador.getApellido().equalsIgnoreCase(apellido)){
					
					trabajador = lista.get(i);
					encontrado = true;
					
				}
			i++;
		}
		
		return encontrado;
	}
	
	public static boolean verificarMecanico(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		Trabajador trabajador = null;
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i<lista.size()) {
			
			trabajador=lista.get(i);
			
				if(trabajador instanceof Mecanico && trabajador.getNombre().equalsIgnoreCase(nombre) &&
						trabajador.getApellido().equalsIgnoreCase(apellido)){
					
					trabajador = lista.get(i);
					encontrado = true;
					
				}
			i++;
		}
		
		return encontrado;
	}
	
	public static boolean verificarTrabajador(ArrayList<Escuderia>equipos,String nombre,String apellido,int referencia) {
		
		boolean indice=false;
		int contador=0;

		while(contador<equipos.get(referencia).trabajadores.size() && indice==false){

		if(equipos.get(referencia).getTrabajadores().get(contador).getNombre().equalsIgnoreCase(nombre) &&
			equipos.get(referencia).getTrabajadores().get(contador).getApellido().equalsIgnoreCase(apellido)){

				indice=true;

		}

				contador++;

			}

				return indice;

	}	
	
	public static int encuentraEquipo(ArrayList<Escuderia>equipos,String nombre) {
		
		int indice=-1;
		int contador=0;

		while(contador<equipos.size() && indice==-1){

			if(equipos.get(contador).getNombre().equalsIgnoreCase(nombre)){
	
					indice=contador;
	
			}
	
					contador++;
	
				}
		
				return indice;

	}	
	
	public static int trabajadoresConMismoNombre(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		int numeroTrabajadores=0; 
		
		for(int i=0; i<lista.size(); i++) {
			
			if(lista.get(i).getNombre().equalsIgnoreCase(nombre) && lista.get(i).getApellido().equalsIgnoreCase(apellido)) {
				numeroTrabajadores++;
			}
		}
		
		return numeroTrabajadores;
	
		
	}
	
	public static int indicePiloto(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		int indice=-1;
		int contador=0;

		while(contador<lista.size() && indice==-1){

		if(lista.get(contador) instanceof Piloto && lista.get(contador).getNombre().equalsIgnoreCase(nombre) &&
			lista.get(contador).getApellido().equalsIgnoreCase(apellido)){

				indice=contador;

		}

				contador++;

			}

				return indice;

		}	
	
	public static int indiceMecanico(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		int indice=-1;
		int contador=0;

		while(contador<lista.size() && indice==-1){

		if(lista.get(contador) instanceof Mecanico && lista.get(contador).getNombre().equalsIgnoreCase(nombre) &&
			lista.get(contador).getApellido().equalsIgnoreCase(apellido)){

				indice=contador;

		}

				contador++;

			}

				return indice;

		}	
	
	public static int indiceTrabajador(ArrayList<Trabajador>lista,String nombre,String apellido) {
		
		int indice=-1;
		int contador=0;

		while(contador<lista.size() && indice==-1){

		if(lista.get(contador).getNombre().equalsIgnoreCase(nombre) &&
			lista.get(contador).getApellido().equalsIgnoreCase(apellido)){

				indice=contador;

		}

				contador++;

			}

				return indice;

		}	
	
	
	public static void verEscuderias(ArrayList<Escuderia>equipos) {
		int numero=1;
		for(Escuderia lista :equipos) {
		      System.out.println((numero++) + "-" +lista.toString());
		    }

	}
	
	public static void verTrabajadores(ArrayList<Trabajador>trabajadores) {
		int numero=1;	
		for(Trabajador lista :trabajadores) {
		      System.out.println((numero++) + "-" +lista.toString());
		    }

	}
	
	public static void verBolidos(ArrayList<Bolido>coches) {
		
		int numero=1;
		for(Bolido lista :coches) {
		      System.out.println("Nuestro coche numero " +(numero++)+ lista.toString());
		    }

	}
	
	static int pideInt(String mensaje) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			System.out.println(mensaje);
				return input.nextInt();
}
	
	static String pideString(String mensaje) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
			System.out.println(mensaje);
				return input.nextLine();
}
	
}
