package main;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import clasesBases.LibroSQL;
import clasesBases.LibroTXT;
import clasesBases.MenuTXT;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		boolean salir = false;
		LibroSQL lsql = new LibroSQL();
		LibroTXT ltxt =new LibroTXT();
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
		
		System.out.println("Escribe txt para usar la base de datos txt o sql para usar la base de datos de mysql");
		String base = sc.nextLine();
		if (base.equalsIgnoreCase("sql")) {
			do {
				try {
					System.out.println(menu);
					int num = Integer.parseInt(sc.nextLine());
					switch (num) {
					case 0:
						salir = true;
						System.out.println("hasta luego");
						break;
					case 1:
						MenuSQL.menu_1(lsql);
						break;
					case 2:
						MenuSQL.menu_2(sc, lsql);
						break;
					case 3:
						MenuSQL.menu_3(sc, lsql);
						break;
					case 4:
						MenuSQL.menu_4(sc, lsql);
						break;
					case 5:
						MenuSQL.menu_5(sc, lsql);
						break;
					case 6:
						MenuSQL.menu_6(sc, lsql);
						break;
					case 7:
						MenuSQL.menu_7(sc, lsql);
						break;
					default:
						System.out.println("Lo escrito no esta en el menu");
					}
				} catch (Exception e) {
					System.out.println("Error por no escribir un número de los indicados");
				}
			} while (salir != true);
		} else if (base.equals("txt")) {
			do {
				try {
					System.out.println(menu);
					int num = Integer.parseInt(sc.nextLine());
					switch (num) {
					case 1:
						MenuTXT.menu_1(ltxt);
						break;
					case 2:
						MenuTXT.menu_2(sc, ltxt);
						break;
					case 3:
						menu_3(sc, ltxt);
						break;
					case 4:
						menu_4(sc, ltxt);
						break;
					case 5:
						System.out.println("Escribe el stock mínimo");
						int stock = Integer.parseInt(sc.nextLine());
						List<Libro> lista = ltxt.obtenerTodos();
						lista.stream().filter(libro -> libro.getStock() >= stock).forEach(libro -> System.out.println(libro));
						break;
					default:
						System.out.println("Lo escrito no esta en el menu");
					}
				} catch (Exception e) {
					System.out.println("Error por no escribir un número");
				}
			} while (salir != true);
		}

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





}
