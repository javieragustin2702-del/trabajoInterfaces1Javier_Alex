//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package clasesBases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Libro;
/**
 * Clase que realiza todas las operaciones referentes a la gestión
 * de la base de datos de TXT. No cuenta con parámetros solo cuenta
 * con métodos y la base de datos del txt viene por defecto como "bases.txt"
 * 
 * @author Javier Agustin Garcia Bolea
 * @author Usuario Alex Daniel Musca
 * @version 1.0
 */
public class LibroTXT implements OperacionesBases<Libro> {
	/**
	 * Método que inserta un libro con todos sus datos. Para
	 * ello realiza una inserción a "bases.txt" comprobando antes
	 * si la base de datos esta escrita o no
	 * 
	 * @return True o false según se haya podido insertar el libro o no
	 */
	@Override
	public boolean insertar(Libro objeto) {
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			PrintWriter escribir = new PrintWriter(new FileWriter("bases.txt",true));
			if (sc.hasNext() == false) {
				escribir.print(objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
			} else {
				escribir.print("\n" + objeto.getId() + "," + objeto.getTitulo() + "," + objeto.getAutor() + "," + objeto.getPrecio() + "," + objeto.getStock());
			}
			escribir.close();
			sc.close();
			leer.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	/**
	 * Método que devuelve una lista de libros leyendo línea a línea
	 * todo el txt y separadano cada línea con un .split separando por ","
	 * y cogiendo cada parte del .split como cada atributo del Libro a crear
	 * siendo el 0 el id, el 1 el título, el 2 el autor, el 3 el precio y el 4 el stock
	 * 
	 * @return Lista de libros si no falla o devuelve null si falla
	 */
	@Override
	public List<Libro> obtenerTodos() {
		List<Libro> lista = new ArrayList<Libro>();
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			while (sc.hasNext()) {
				String[] cadena = sc.nextLine().split(",");
				int id = Integer.parseInt(cadena[0]);
				String titulo = cadena[1];
				String autor = cadena[2];
				double precio = Double.parseDouble(cadena[3]);
				int stock = Integer.parseInt(cadena[4]);
				lista.add(new Libro(id, titulo, autor, precio, stock));
			}
			sc.close();
			leer.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/**
	 * Método vacío que solo devuelve null debido a que 
	 * actualmente no se usa
	 * 
	 * @return null;
	 */
	@Override
	public Libro obtenerPorId(int id) {
		return null;
	}
	/**
	 * Método vacío que solo devuelve null debido a que 
	 * actualmente no se usa
	 * 
	 * @return null;
	 */
	@Override
	public boolean actualizar(Libro objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Método que guarda todos los datos menos el libro a borrar
	 * por id en un {@code ArrayList} y elimina la base para
	 * luego reescribirla con todos los datos menos el libro
	 * que se quería borrar
	 * 
	 * @return true si realiza todo o false si falla
¡	 */
	@Override
	public boolean eliminar(int id) {
		List<String> lista = new ArrayList<String>();
		try {
			FileReader leer = new FileReader("bases.txt");
			Scanner sc = new Scanner(leer);
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String[] cadena = linea.split(",");
				if (Integer.parseInt(cadena[0]) != id) {
					lista.add(linea);
				}
			}
			sc.close();
			leer.close();
			PrintWriter escribir = new PrintWriter(new FileWriter("bases.txt"));
			lista.stream().forEach(linea -> escribir.println(linea));
			escribir.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
