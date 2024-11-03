package comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {

	public static void main(String[] args) {
		// Interfaces con un sólo método abstracto: interfaces funcionales.

		// FORMA 1
		Comparator<Cliente> comp = new ComparaNombres();
		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		Collections.sort(lista, comp);

		// Collections.sort(lista, new ComparaNombres());

		// =====================================================
		// FORMA 2
		// Si sólo vamos a usar el comparador una vez no merece la pena crear una clase
		// para comparar
		// Creamos el objeto con una clase anónima:
		Comparator<Cliente> comp2 = new Comparator<>() {
			public int compare(Cliente c1, Cliente c2) {
				return c1.getNombre().compareTo(c2.getNombre());
			}
		};

		Collections.sort(lista, comp2);

		// =====================================================
		// FORMA 3
		// Lo creamos directamente en el método sort:
		Collections.sort(lista, new Comparator<>() {
			public int compare(Cliente c1, Cliente c2) {
				return c1.getNombre().compareTo(c2.getNombre());
			}
		});

		// =====================================================
		// FORMA 4
		// Expresiones lambda
		// en las formas anteriores en todo momento hemos tenido que especificar el
		// nombre del método: compare ¿se podría obviar al ser éste el único método que
		// tiene la interfaz Comparator? Esta es la idea que está detrás de las
		// expresiones lambda
		// Para ello, se pone primero la lista de parámetros que va a recibir la
		// función, a continuación una fleca (->), y por último el cuerpo de la función
		// entre llaves. Si el cuerpo de la función está formado por una única
		// instrucción y no devuelve ningún valor se pueden omitir las llaves.
		// Si es una única sentencia y devuelve un valor, la orden return se puede
		// omitir, ya que Java devuelve automáticamente el resultado de la sentencia
		// En nuestro caso queda así:

		Comparator<Cliente> comp4 = (c1, c2) -> {
			return c1.getNombre().compareTo(c2.getNombre());
		};

		// Se pueden omitir los tipos de los parámetros de entrada porque al poner
		// <Cliente> al lado de Comparator ya sabe que van a ser de ese tipo.

		// Dentro de las llaves que están a la derecha de la flecha (->) podemos poner
		// todas las instrucciones que necesitemos

		// También directamente dentro del método de sort. Esto funciona porque Java
		// sabe que el segundo parámetro del método sort es de tipo Comaparator
		
		// Si el cuerpo de la función está formado por una única
		// instrucción y no devuelve ningún valor se pueden omitir las llaves.
		// Si es una única sentencia y devuelve un valor, la orden return se puede
		// omitir, ya que Java devuelve automáticamente el resultado de la sentencia
		
		Collections.sort(lista, (c1, c2) -> c1.getNombre().compareTo(c2.getNombre()));

		// Dentro de las
	}

}
