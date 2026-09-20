package clasesBases;

import java.util.List;

public interface OperacionesBases<T> {
	boolean insertar(T objeto);
	List<T> obtenerTodos();
	T obtenerPorId(int id);
	boolean actualizar(T objeto);
	boolean eliminar(int id);
}
