package modelo;

public class Libro {

	String id;
	String titulo;
	String autor;
	Double precio;
	int Stock;

	public Libro() {
		super();
	}

	public Libro(String id, String titulo, String autor, Double precio, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		Stock = stock;
	}

}
