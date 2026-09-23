package clasesBases;

import java.util.List;
import java.util.Scanner;

import modelo.Libro;

public class MenuTXT {

	public static void menu_1(LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}
	

	public static void menu_2(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro buscado");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo)).forEach(libro -> System.out.println(libro));
	}
}
