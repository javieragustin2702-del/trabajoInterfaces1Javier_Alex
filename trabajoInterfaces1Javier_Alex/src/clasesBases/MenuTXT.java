package clasesBases;

import java.util.List;
import java.util.Scanner;

import modelo.Libro;

public class MenuTXT {
	
	public static void menu_5(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el stock mínimo");
		int stock = Integer.parseInt(sc.nextLine());
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getStock() >= stock).forEach(libro -> System.out.println(libro));
	}

	public static void menu_4(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el precio mínimo");
		double min = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el precio máximo");
		double max = Double.parseDouble(sc.nextLine());
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getPrecio() >= min && libro.getPrecio() <= max).forEach(libro -> System.out.println(libro));
	}

	public static void menu_3(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el autor");
		String autor = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor)).forEach(libro -> System.out.println(libro));
	}
	
	public static void menu_2(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro buscado");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo)).forEach(libro -> System.out.println(libro));
	}

	public static void menu_1(LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}
	


}
