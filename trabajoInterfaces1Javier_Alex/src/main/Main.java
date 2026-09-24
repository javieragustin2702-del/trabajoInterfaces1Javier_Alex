package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import clasesBases.LibroSQL;
import clasesBases.LibroTXT;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		boolean salir = false;
		LibroSQL lsql = new LibroSQL();
		LibroTXT ltxt = new LibroTXT();
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
				0. Para salir
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
					case 8:
						List<Libro> lista = lsql.obtenerTodos();
						System.out.println(lista);
						try (BufferedWriter bw = new BufferedWriter(
								new FileWriter("bases.txt", StandardCharsets.UTF_8))) {
							/*for (String elemento : lista) {
								bw.write(elemento);
								bw.newLine(); // Salto de línea para cada elemento
							}
							System.out.println("¡Datos guardados con éxito en el archivo!");*/
						} catch (IOException e) {
							System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
						}
						break;
					default:
						System.out.println("Lo escrito no esta en el menu");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (salir != true);
		} else if (base.equals("txt")) {
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
						MenuTXT.menu_1(ltxt);
						break;
					case 2:
						MenuTXT.menu_2(sc, ltxt);
						break;
					case 3:
						MenuTXT.menu_3(sc, ltxt);
						break;
					case 4:
						MenuTXT.menu_4(sc, ltxt);
						break;
					case 5:
						MenuTXT.menu_5(sc, ltxt);
						break;
					case 6:
						MenuTXT.menu_6(sc, ltxt);
						break;
					case 7:
						MenuTXT.menu_7(sc, ltxt);
						break;
					case 8:
						MenuTXT.menu_8(lsql, ltxt);
						break;
					default:
						System.out.println("Lo escrito no esta en el menu");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (salir != true);
		} else {
			System.out.println("no se ha escrito ni txt y sql por lo que va a terminar el programa");
		}

	}

}
