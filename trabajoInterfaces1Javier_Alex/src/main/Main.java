package main;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import clasesBases.LibroSQL;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		boolean salir = false;
		LibroSQL lsql = new LibroSQL();
		String menu = """
				Escribe el numero:
				1. Para mostrar todos los libros
				2. Para buscar un libro por su titulo
				3. Para buscar un libro por su autor
				4. Para buscar por rango de precios
				5. Para buscar por stock mínimo
				6. Para insertar un libro
				7. Para eliminar un libro
				8. Para copiar todos los datos de un repositorio a otro
				""";
		do {
			try {
				System.out.println(menu);
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case 0:
					salir = menu_0();
					break;
				case 1: 
					menu_1(lsql);
					break;
				case 2:
					menu_2(sc, lsql);
					break;
				case 3:
					menu_3(sc, lsql);
					break;
				case 4:
					menu_4(sc, lsql);
					break;
				case 5:
					menu_5(sc, lsql);
					break;
				case 6:
					menu_6(sc, lsql);
					break;
				default:
					System.out.println("Lo escrito no esta en el menu");
				}
			} catch (Exception e) {
				System.out.println("Error por no escribir un número");
			}
		} while (salir != true);
		sc.close();
	}

	private static void menu_6(Scanner sc, LibroSQL lsql) {
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
		Libro l = new Libro(id,titulo,autor,precio,stock);
		if (lsql.insertar(l) == true) {
			System.out.println("Insertado");
		} else {
			System.out.println("No se ha podido insertar");
		}
	}

	private static void menu_5(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe por el stock que quieres buscar");
		int cantidad = Integer.parseInt(sc.nextLine());
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getStock() >= cantidad).forEach(libro -> System.out.println(libro));
	}

	private static void menu_4(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el precio mínimo");
		double min = Double.parseDouble(sc.nextLine());
		System.out.println("Escribe el precio máximo");
		double max = Double.parseDouble(sc.nextLine());
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getPrecio() >= min && libro.getPrecio() <= max).forEach(libro -> System.out.println(libro));
	}

	private static void menu_3(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el nombre de un autor");
		String titulo = sc.nextLine();
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getAutor().equals(titulo)).forEach(libro -> System.out.println(libro));
	}

	private static void menu_2(Scanner sc, LibroSQL lsql) {
		System.out.println("Escribe el nombre de un libro");
		String titulo = sc.nextLine();
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().filter(libro -> libro.getTitulo().equals(titulo)).forEach(libro -> System.out.println(libro));
	}

	private static void menu_1(LibroSQL lsql) {
		List<Libro> lista = lsql.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}

	private static boolean menu_0() {
		boolean salir;
		System.out.println("Hasta luego");
		salir = true;
		return salir;
	}
}
