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
					System.out.println("Hasta luego");
					salir = true;
					break;
				case 1: 
					List<Libro> lista = lsql.obtenerTodos();
					lista.stream().forEach(libro -> System.out.println(libro));
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
}
