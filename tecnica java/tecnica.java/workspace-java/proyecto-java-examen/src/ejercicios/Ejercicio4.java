package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido,
	static Integer[] valoresLista1 = { 1, 2, 5, 8, 10, 30, 20, 8, 9, 10 };
	static Integer[] valoresLista2 = { 1, 2, 4, 20, 5, 10, 7, 8, 10, 9 };

	/**
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase "Run
	 * As --> Java Application"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("**** inicializando datos ****");

		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);

		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());

		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());

		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);

		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);

	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		// TODO: explicar salidas de los system out y sugerir alguna mejora a la
		// implementacion

		int pares = 0;
		for (Integer n : lista1) {
			if (n % 2 == 0) {
				pares = pares + 1;
			}
		}

		System.out.println("cantidad de numeros pares de lista1: " + pares);

		List<Integer> impares = new ArrayList<Integer>();
		for (Integer n : lista1) {
			if (n % 2 != 0) {
				impares.add(n);
			}
		}

		System.out.println("nuevo arreglo de numeros impares a partir de lista1: " + impares.toString());

		int p = lista1.size() / 2;

		System.out
				.println("posicion en la que se encuentra el numero 5 dentro del arreglo lista1: " + lista1.indexOf(p));

		int c = 0;
		for (Integer n : lista1) {
			if (n > numero) {
				c = c + 1;
			}
		}
		if (c > lista1.size() / 2) {
			System.out.println("Cantidad de numeros de lista1 mayores a 10 cuando el resultado es mayor a 5");
		} else if (c > 0) {
			System.out.println(
					"Cantidad de numeros de lista1 mayores a 10 cuando el resultado es mayor a 0 y menor igual a 5");
		} else {
			System.out.println("Cantidad de numeros de lista1 mayores a 10 cuando el resultado es menor o igual a 0");
		}
	}
	/*
	 * Sugerencias: cambiaria el nombre de las variables, pondria nombres mas
	 * representativos en las variables p,c,n
	 */

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               retornar una lista que contenga los elementos de ambas listas,
	 *               sin elementos repetidos
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO: corregir el metodo para que funcione correctamente

		List<Integer> union = new ArrayList<Integer>();

		for (Integer i : lista1) {
			if (!union.contains(i)) {
				union.add(i);
			}
		}
		for (Integer m : lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}

		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               retornar una lista que contenga los elementos que estan
	 *               presentes en ambas listas, sin elementos repetidos
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		// TODO:
		List<Integer> interseccion = new ArrayList<Integer>();
		for (Integer m : lista1) {
			if (lista2.contains(m)) {
				if (!interseccion.contains(m)) {
					interseccion.add(m);
				}
			}
		}
		return interseccion;
	}

	/***
	 * @param lista1
	 * 
	 *               retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		Collections.sort(lista1);
		return lista1;
	}

	/***
	 * @param lista2
	 * 
	 *               retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		Collections.sort(lista2, Collections.reverseOrder());
		return lista2;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 *               devuelve true si contienen los mismos elementos NO se considera
	 *               valido que esten en diferente orden NO se considera valido que
	 *               la cantidad de repeticiones de los elementos sea diferente
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		boolean tieneMismoContenido = false;
		if (lista1.size() == lista2.size()) {
			for (int i = 0; i < lista1.size(); i++) {
				if (lista2.get(i) == lista1.get(i)) {
					tieneMismoContenido = true;
				} else {
					return false;
				}
			}
		}
		return tieneMismoContenido;
	}

}
