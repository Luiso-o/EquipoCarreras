package Equipos;

import java.util.ArrayList;

public class Campeonato {

	public static void main(String[] args) {
		
		ArrayList<Escuderia>equipos=new ArrayList<Escuderia>();
	//-------------------------------------------------------------------//	
		Escuderia equipo1= new Escuderia("Ferrari",1000000,"Italia");
		
			equipo1.getCoches().add(new Bolido(5000,300,"Rojo",250000));
			equipo1.getCoches().add(new Bolido(6000,350,"Verde",255000));	
			
				equipo1.getTrabajadores().add(new Piloto("Juan","Martinez",30,3,170,66));
				equipo1.getTrabajadores().add(new Mecanico("Isabel","Garcia",30,4,"Si"));
				
					equipos.add(equipo1);
			
	//-------------------------------------------------------------------//		
		Escuderia equipo2= new Escuderia("Red Bull",1000000,"Austria");
		
			equipo2.getCoches().add(new Bolido(5000,300,"Amarillo",250000));
			equipo2.getCoches().add(new Bolido(6000,350,"Azul",255000));
			equipo2.getCoches().add(new Bolido(6600,400,"Negro",260000));
			
				equipo2.getTrabajadores().add(new Piloto("Julia","Casares",29,2,160,60));
				equipo2.getTrabajadores().add(new Piloto("Mario","Gonzales",25,1,185,70));
				equipo2.getTrabajadores().add(new Mecanico("Juaquin","Saenz",30,5,"Si"));
				
					equipos.add(equipo2);
					
	//-------------------------------------------------------------------//		
		Escuderia equipo3= new Escuderia("Mercedez",1000000,"Alemania");
		
			equipo3.getCoches().add(new Bolido(5000,300,"Naranja",250000));
			equipo3.getCoches().add(new Bolido(6000,350,"Marron",255000));
			equipo3.getCoches().add(new Bolido(6600,400,"Rosa",260000));
			equipo3.getCoches().add(new Bolido(7000,450,"Amarillo",270000));
			
				equipo3.getTrabajadores().add(new Piloto("Martina","Garcia",28,5,170,67));
				equipo3.getTrabajadores().add(new Piloto("Jose","Sanchez",33,5,176,70));
				equipo3.getTrabajadores().add(new Piloto("Marcos","Perez",25,2,170,68));
				equipo3.getTrabajadores().add(new Mecanico("Cristhian","Pons",40,10,"Si"));
				equipo3.getTrabajadores().add(new Mecanico("Maria","Jimenez",29,2,"No"));		
			
					equipos.add(equipo3);
	//-------------------------------------------------------------------//	
		Escuderia equipo4= new Escuderia("McLaren",1000000,"Gran Breta�a");
		
			equipo4.getCoches().add(new Bolido(5000,300,"Verde Musgo",250000));
			equipo4.getCoches().add(new Bolido(6000,350,"Plateado",255000));
			equipo4.getCoches().add(new Bolido(66000,400,"Dorado",270000));
			
				equipo4.getTrabajadores().add(new Piloto("Ana","Lopez",30,6,166,67));
				equipo4.getTrabajadores().add(new Piloto("Jorge","Fernandez",25,3,180,70));
				equipo4.getTrabajadores().add(new Mecanico("Elizabeth","Blade",35,8,"Si"));
				equipo4.getTrabajadores().add(new Mecanico("Carlos","Matamoros",30,2,"No"));
				
					equipos.add(equipo4);	
							
	//-------------------------------------------------------------------------			
					
		int indice=Metodos.menu();
					
		while(indice>0 && indice<4) {
			
			switch(indice) {
			
				case 1:
					
					Metodos.nuevoTrabajador(equipos,Metodos.pideString("Introduce el nombre"),
							Metodos.pideString("Introduce el apellido"));
					
						indice=Metodos.menu();	
							
							break;
						
							
				case 2:
					
					Metodos.eliminarTrabajador(equipos, Metodos.pideString("Introduce el nombre"),
							Metodos.pideString("Introduce el apellido"));
					
						indice=Metodos.menu();	
					
							break;
						
				case 3:
					
					Metodos.verEquipos(equipos);
					
						indice=Metodos.menu();	
					
							break;
			
			}
			
		}
		
		System.out.println("<<Hasta pronto! :)>>");			
	}
	
	
		
}
