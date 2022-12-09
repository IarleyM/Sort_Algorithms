package QuickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	static int trocas = 0;

	public static void main(String[] args) {
		Teste1 t = new Teste1();

		Resultado resultado;

		int[] q = t.gerarVetor(10);
		int[] w = t.gerarVetor1(10000);
		int[] o = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("Array de 10 indices Gerado Aleatoriamente:\n" + Arrays.toString(q) + "\n");

		// QuickSort
		System.out.println("QuickSort:");
		long ini = System.currentTimeMillis();
		resultado = QuickSort.quickSort(q.clone(), 0, q.length - 1);
		long fim = System.currentTimeMillis();
		QuickSort.quickSort(q, 0, q.length - 1);

		// De -100 a 100
		System.out.println("De -100 a 100:\n" + Arrays.toString(q));
		System.out.println("Tempo exe: " + (fim - ini) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());

		// De -10000 a 10000
		System.out.println("\nDe -10000 a 10000:");
		long ini4 = System.currentTimeMillis();
		resultado = QuickSort.quickSort(w.clone(), 0, w.length - 1);
		long fim4 = System.currentTimeMillis();
		QuickSort.quickSort(w, 0, w.length - 1);
		System.out.println(Arrays.toString(w));
		System.out.println("Tempo exe: " + (fim4 - ini4) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());

		// Ja ordenado
		System.out.println("\nTeste já ordenado");
		long ini2 = System.currentTimeMillis();
		resultado = QuickSort.quickSort(o.clone(), 0, o.length - 1);
		long fim2 = System.currentTimeMillis();
		QuickSort.quickSort(o, 0, o.length - 1);
		System.out.println(Arrays.toString(o));
		System.out.println("Tempo exe: " + (fim2 - ini2) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());
	}

	public static Resultado quickSort(int[] v, int esq, int dir) {
		if (esq < dir) {
			int j = separar(v, esq, dir);
			quickSort(v, esq, j);
			quickSort(v, j + 1, dir);
		}
		return new Resultado(v, trocas);

	}

	private static int separar(int[] v, int esq, int dir) {
		int meio = (int) (esq + dir) / 2;
		int pivo = v[meio];
		int i = esq - 1;
		int j = dir + 1;
		while (true) {
			do {
				i++;
			} while (v[i] < pivo);
			do {
				j--;
			} while (v[j] > pivo);
			if (i >= j) {
				return j;
			}
			int aux = v[i];
			v[i] = v[j];
			v[j] = aux;
			trocas++;
		}
	}

}
