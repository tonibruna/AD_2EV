package NeoDatis_Jugadores;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Jugadores_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creo los jugadores
		
		ODB odb = ODBFactory.open("neodatis.test");

		
		//Creo jugadores
		Jugadores j1= new Jugadores ("María", "voleibol", "Madrid", 14, new Paises (1, "Espanya"));
		Jugadores j2= new Jugadores ("Miguel", "tenis", "Madrid", 15, new Paises (2, "Bulgaria"));
		Jugadores j3= new Jugadores ("Mario", "baloncesto", "Guadalajara", 15, new Paises (3, "Estonia"));
		Jugadores j4= new Jugadores ("Alicia", "tenis", "Madrid", 14, new Paises (4, "Chipre"));
		
		// Inserto los objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);

		//----------MOSTRAR DATOS--------------------
		
		// Genero un conjunto de objetos y los traigo del ODB conectado
		Objects<Jugadores> objects=odb.getObjects(Jugadores.class);

		// Imprimo cuantos objetos me he traido de la BD
		System.out.println(objects.size() + " jugadores:");

		int i = 1; // Meramente estético. Así muestra listados los objetos

		// Mientras haya objetos, los capturo y muestro
		while(objects.hasNext()){

		      // Creo un objeto Jugadores y almaceno ahí el objeto
		      Jugadores jug= objects.next();
		     
		      // Imprimo las propiedades que me interes de ese objeto
		      System.out.println((i++) + "\t: " + jug.getNombre() + "*" + jug.getDeporte() 
		      + "*" + jug.getCiudad() + "*" + jug.getEdad());
		} // Fin del While
	
		
		//CONSULTAS 
		System.out.println("--------------------------------");
		System.out.println("Jugadores cuyo deporte es tenis:");
		/* Genero la consulta. Llamo a la clase Jugadores
		 * La condición será que la propiedad deporte sea igual a tenis
		 */
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
		
		// Y ya, por capricho persona, ordeno el resultado por nombre y edad
		query.orderByDesc("nombre,edad");
		
		//Cargo los objetos pasando como parametro del ODB nuestra consulta
		Objects<Jugadores> objects2 = odb.getObjects(query);
		mostrarDatos(objects2);
		
		odb.close();

	}
	
public static void mostrarDatos(Objects<Jugadores> object) {
		
	System.out.println(object.size() + " jugadores:");

	int i = 1;

	while(object.hasNext()){		      
		Jugadores jug= object.next();		
			
		   System.out.println((i++) + "\t: " + jug.getNombre() + "*" 
		      + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
	}
}

