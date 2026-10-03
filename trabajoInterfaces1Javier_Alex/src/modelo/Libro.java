// Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package modelo;

public class Libro {
	/**
	 * Identificador único del libro si todavía no tiene ninguno asignado sale {@code 0}.
	 */
	int id;
	/**
	 * Título del libro.
	 */
	String titulo;
	/**
	 * Nombre del autor del libro.
	 */
	String autor;
	/**
	 * Precio del libro.
	 */
	double precio;
	/**
	 * Número de unidades disponibles en stock.
	 */
	int Stock;

	/**
	 * Crea un libro vacío, sin datos.
	 *
	 * El identificador, el precio y el stock valen {@code 0}, y el título y el autor son
	 * {@code null}. Se usa junto con los métodos set para rellenar el libro campo a campo,
	 * por ejemplo al leerlo de la base de datos.
	 *
	 */
	public Libro() {
		super();
	}

	/**
	 * Crea un libro nuevo, todavía sin identificador.
	 * 
	 * El identificador se inicializa a {@code 0}. Es el constructor adecuado para los
	 * libros que se van a insertar en la base de datos, que se encarga de
	 * asignarles su identificador.
	 * 
	 *
	 * @param titulo título del libro
	 * @param autor  autor del libro
	 * @param precio precio del libro; no debe ser {@code null}
	 * @param stock  unidades disponibles en stock
	 * @throws NullPointerException si precio es {@code null}
	 */
	public Libro(String titulo, String autor, Double precio, int stock) {
		this(0, titulo, autor, precio, stock);
	}

	/**
	 * Crea un libro con todos sus atributos.
	 *
	 * @param id     identificador único del libro
	 * @param titulo título del libro
	 * @param autor  autor del libro
	 * @param precio precio del libro; no debe ser {@code null}
	 * @param stock  unidades disponibles en stock
	 * @throws NullPointerException si precio es {@code null}
	 */
	public Libro(int id, String titulo, String autor, Double precio, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		Stock = stock;
	}

	/**
	 * Devuelve el identificador único del libro.
	 *
	 * @return el id del libro
	 */
	public int getId() {
		return id;
	}
	/**
	 * Establece el identificador único del libro.
	 *
	 * @param id nuevo identificador del libro
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Devuelve el título del libro.
	 *
	 * @return el título del libro
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Establece el título del libro.
	 * 
	 * @param titulo nuevo título del libro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Devuelve el autor del libro.
	 *
	 * @return el autor del libro
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * Establece el autor del libro.
	 *
	 * @param autor nuevo autor del libro
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * Devuelve el precio del libro.
	 *
	 * @return el precio del libro
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * Establece el precio del libro.
	 *
	 * @param precio nuevo precio del libro; no debe ser {@code null}
	 * @throws NullPointerException si {@code precio} es {@code null}
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/**
	 * Devuelve las unidades disponibles en stock.
	 *
	 * @return el stock del libro
	 */
	public int getStock() {
		return Stock;
	}
	/**
	 * Establece las unidades disponibles en stock.
	 *
	 * @param stock nuevo número de unidades en stock
	 */
	public void setStock(int stock) {
		Stock = stock;
	}
	/**
	 * Devuelve una representación en texto del libro.
	 * <p>
	 * El formato es {@code Libro [id=..., titulo=..., autor=..., precio=..., Stock=...]}.
	 * </p>
	 *
	 * @return cadena con todos los atributos del libro
	 */
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", Stock=" + Stock
				+ "]";
	}

}
