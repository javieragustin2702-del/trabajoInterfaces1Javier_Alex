//Tarea 1 del trabajo 1 Javier Agustin Garcia Bolea y Alex Daniel Musca
package clasesBases;

import java.util.List;


/**
 * Interfaz de la cual heredarán LibroSQL y LibroTXT sus métodos.
 * 
 * @param <T> que es el Elemento esperado a ser convertido en Libro para su uso en LibroSQL y LibroTXT
 * @author Javier Agustin Garcia Bolea
 * @author Usuario Alex Daniel Musca
 * @version 1.0
 */
public interface OperacionesBases<T> {
	/**
	 * Método que heredarán LibroSQL y LibroTXT que devuelve true o
	 * false indicando si se ha podido insertar el libro o no
	 * 
	 * @param objeto que será un elemento convertido en Libro
	 * @return True o False si se ha podido insertar el libro o no
	 */
	boolean insertar(T objeto);
	/**
	 * Método que heredarán LibroSQL y LibroTXT que devuelve
	 * una lista de todos los libros de las respectivas bases de datos
	 * 
	 * @return lista con todos los libros de la base de datos
	 */
	List<T> obtenerTodos();
	/**
	 * Método que heredarán LibroSQL y LibroTXT que devuelve
	 * un libro de las respectivas bases de datos que ha sido obtenido
	 * mediante una búsqueda por su id
	 * 
	 * @param id que es el id por el que se quiere buscar un libro
	 * @return
	 */
	T obtenerPorId(int id);
	/**
	 * Método que heredarán LibroSQL y LibroTXT que devuelve
	 * true o false según se haya podido actualizar el libro o no
	 * 
	 * 
	 * @param objeto que será un libro con id,tituto,autor,precio y stock 
	 * @return True o False según se haya podido actualizar el libro o no
	 */
	boolean actualizar(T objeto);
	/**
	 * Método que heredarán LibroSQL y LibroTXT que devuelve
	 * true o false según se haya eliminido un libro o no.
	 * 
	 * Para ello el libro a eliminar se busca por su id
	 * @param id que es el libro a eliminar
	 * @return True o False según se elimine el libro o no
	 */
	boolean eliminar(int id);
}
