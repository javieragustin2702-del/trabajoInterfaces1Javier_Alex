//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clasesBases.LibroSQL;
import clasesBases.LibroTXT;
import modelo.Libro;
/**
 * Opciones del menú para trabajar con el fichero de texto.
 *
 * @author Javier Agustin Garcia Bolea
 * @author Alex Daniel Musca
 * @version 1.0
 */
public class MenuTXT {
	/**
	 * Opción 8: copia todos los libros del fichero de texto a la base de datos.
	 *
	 * @param lsql repositorio de la base de datos (destino)
	 * @param ltxt repositorio del fichero de texto (origen)
	 */
	public static void menu_8(LibroSQL lsql, LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> lsql.insertar(libro));
	}
	/**
	 * Opción 7: elimina un libro por su título.
	 * Si hay varios con el mismo título, pide el id del que se quiere eliminar.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_7(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		List<Libro> coinciden = new ArrayList<Libro>();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
				.forEach(libro -> coinciden.add(libro));
		if (coinciden.size() > 1) {
			coinciden.stream().forEach(libro -> System.out.println(libro));
			System.out.println("hay mas de un libro con el mismo título,escribe el id del que hay que eliminar");
			int id = Integer.parseInt(sc.nextLine());
			coinciden.stream().filter(libro -> libro.getId() == id)
					.forEach(libro -> System.out.println(ltxt.eliminar(id)));
		} else if (coinciden.size() == 0) {
			System.out.println("No hay ningun libro con ese título");
		} else {
			System.out.println(ltxt.eliminar(coinciden.getFirst().getId()));
		}
	}
	/**
	 * Opción 6: pide los datos de un libro (incluido el id) y lo guarda en el fichero.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_6(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el id del libro");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe el título");
		String titulo = sc.nextLine();
		System.out.println("Escribe el autor");
		String autor = sc.nextLine();
		System.out.println("Escribe el precio");
		double precio = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el stock que tiene");
		int stock = Integer.parseInt(sc.nextLine());
		System.out.println(ltxt.insertar(new Libro(id, titulo, autor, precio, stock)));
	}
	/**
	 * Opción 5: muestra los libros con un stock igual o superior al indicado.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_5(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el stock mínimo");
		int stock = Integer.parseInt(sc.nextLine());
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getStock() >= stock).forEach(libro -> System.out.println(libro));
	}
	/**
	 * Opción 4: muestra los libros con un precio entre un mínimo y un máximo.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_4(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el precio mínimo");
		double min = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el precio máximo");
		double max = Double.parseDouble(sc.nextLine());
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getPrecio() >= min && libro.getPrecio() <= max)
				.forEach(libro -> System.out.println(libro));
	}
	/**
	 * Opción 3: muestra los libros del autor indicado.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_3(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el autor");
		String autor = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
				.forEach(libro -> System.out.println(libro));
	}
	/**
	 * Opción 2: muestra los libros con el título indicado.
	 *
	 * @param sc escáner para leer los datos por teclado
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_2(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro buscado");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
				.forEach(libro -> System.out.println(libro));
	}
	/**
	 * Opción 1: muestra todos los libros.
	 *
	 * @param ltxt repositorio del fichero de texto
	 */
	public static void menu_1(LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}

}
