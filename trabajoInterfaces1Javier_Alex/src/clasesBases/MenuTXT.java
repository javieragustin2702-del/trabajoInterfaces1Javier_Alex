package clasesBases;

import java.util.List;

import modelo.Libro;

public class MenuTXT {

	public static void menu_1(LibroTXT ltxt) {
		List<Libro> lista = ltxt.obtenerTodos();
		lista.stream().forEach(libro -> System.out.println(libro));
	}
}
