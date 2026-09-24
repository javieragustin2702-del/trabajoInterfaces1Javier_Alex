package main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import clasesBases.LibroSQL;
import modelo.Libro;

public class MenuSQL {

	public static void menu_7(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el titulo del libro");
		String titulo = sc.nextLine();
		List<Libro> lista = lsql.obtenerTodos();
		List<Libro> iguales = lista.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
				.collect(Collectors.toList());
		if (iguales.size() > 1) {
			System.out.println("Hay varios libros con el mismo título.Escribe un id para elegir cual eliminar");
			iguales.stream().forEach(libro -> System.out.println(libro));
			int id = Integer.parseInt(sc.nextLine());
			if (lsql.eliminar(id) == true) {
				System.out.println("Eliminado");
			} else {
				System.out.println("No se ha podido eliminar");
			}
		} else {
			if (lsql.eliminar(iguales.getFirst().getId()) == true) {
				System.out.println("Eliminado");
			} else {
				System.out.println("No se ha podido eliminar");
			}
		}
	}

	public static void menu_6(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el id del libro");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("su título");
		String titulo = sc.nextLine();
		System.out.println("su autor");
		String autor = sc.nextLine();
		System.out.println("su precio");
		double precio = Double.parseDouble(sc.nextLine());
		System.out.println("su stock");
		int stock = Integer.parseInt(sc.nextLine());
		Libro l = new Libro(id, titulo, autor, precio, stock);
		if (lsql.insertar(l) == true) {
			System.out.println("Insertado");
		} else {
			System.out.println("No se ha podido insertar");
		}
	}

	public static void menu_5(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe por el stock que quieres buscar");
		int cantidad = Integer.parseInt(sc.nextLine());
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getStock() >= cantidad).forEach(libro -> System.out.println(libro));
	}

	public static void menu_4(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el precio mínimo");
		double min = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el precio máximo");
		double max = Double.parseDouble(sc.nextLine());
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getPrecio() >= min && libro.getPrecio() <= max)
				.forEach(libro -> System.out.println(libro));
	}

	public static void menu_3(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el nombre de un autor");
		String titulo = sc.nextLine();
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getAutor().equals(titulo)).forEach(libro -> System.out.println(libro));
	}

	public static void menu_2(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el nombre de un libro");
		String titulo = sc.nextLine();
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equals(titulo)).forEach(libro -> System.out.println(libro));
	}

	public static void menu_1(LibroSQL lsql) {
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}

}
