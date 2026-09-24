package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clasesBases.LibroSQL;
import clasesBases.LibroTXT;
import modelo.Libro;

public class MenuTXT {
	public static void menu_8(LibroSQL lsql, LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> lsql.insertar(libro));
	}
	public static void menu_7(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		List<Libro> coinciden = new ArrayList<Libro>();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo)).forEach(libro -> coinciden.add(libro));
		if (coinciden.size() > 1) {
			coinciden.stream().forEach(libro -> System.out.println(libro));
			System.out.println("hay mas de un libro con el mismo título,escribe el id del que hay que eliminar");
			int id = Integer.parseInt(sc.nextLine());
			coinciden.stream().filter(libro -> libro.getId() == id).forEach(libro -> System.out.println(ltxt.eliminar(id)));
		} else if (coinciden.size() == 0) {
			System.out.println("No hay ningun libro con ese título");
		} else {
			System.out.println(ltxt.eliminar(coinciden.getFirst().getId()));
		}
	}
	
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
		lista.stream().filter(libro -> libro.getPrecio() >= min && libro.getPrecio() <= max)
				.forEach(libro -> System.out.println(libro));
	}

	public static void menu_3(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el autor");
		String autor = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
				.forEach(libro -> System.out.println(libro));
	}

	public static void menu_2(Scanner sc, LibroTXT ltxt) {
		System.out.println("Escribe el titulo del libro buscado");
		String titulo = sc.nextLine();
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
				.forEach(libro -> System.out.println(libro));
	}

	public static void menu_1(LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}

}
