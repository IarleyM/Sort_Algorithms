package QuickSort;

import java.util.Arrays;

public class MergeSort {
	static int trocas = 0;
	
	public static void main (String[]args) {
		Teste1 t = new Teste1();
		
		Resultado resultado;
		int[] q = t.gerarVetor(10);
		int[] w = t.gerarVetor1(10000);
		int[] o = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Array Gerado Aleatoriamente:\n" + Arrays.toString(q) + "\n");
		
		System.out.println("\nMergeSort:");
		long ini3 = System.currentTimeMillis();
		resultado = MergeSort.mergeSort(q.clone(), 0, q.length - 1);
		long fim3 = System.currentTimeMillis();
		MergeSort.mergeSort(q, 0, q.length - 1);
		
		//De -100 a 100
		System.out.println("De -100 a 100:\n" + Arrays.toString(q));
		System.out.println("Tempo exe: " + (fim3 - ini3) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());
		
		//De -10000 a 10000
		long ini6 = System.currentTimeMillis();
		resultado = MergeSort.mergeSort(w.clone(), 0, w.length - 1);
		long fim6 = System.currentTimeMillis();
		MergeSort.mergeSort(w, 0, w.length - 1);
		System.out.println("\nDe -10000 a 10000:\n" + Arrays.toString(w));
		System.out.println("Tempo exe: " + (fim6 - ini6) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());
		
		//Ja ordenado
		System.out.println("\nTeste já ordenado");
		long ini2 = System.currentTimeMillis();
		resultado = QuickSort.quickSort(o.clone(), 0, o.length - 1);
		long fim2 = System.currentTimeMillis();
		QuickSort.quickSort(o, 0, o.length - 1);
		System.out.println(Arrays.toString(o));
		System.out.println("Tempo exe: " + (fim2 - ini2) + "ms");
		System.out.println("Trocas realizadas " + resultado.getTrocas());
	}

	public static Resultado mergeSort(int[] v, int ini, int fim) {
		int[] w = new int[v.length];
		if (ini < fim) {
			int meio = (ini + fim) / 2;
			mergeSort(v, ini, meio);
			mergeSort(v, meio + 1, fim);
			intercalar(v, w, ini, meio, fim);
		}
		return new Resultado(v, trocas);
	}

	private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
		for (int i = ini; i <= fim; i++) {
			w[i] = v[i];
		}
		int k = ini;
		int y = meio + 1;

		for (int i = ini; i <= fim; i++) {
			if (k > meio) {
				v[i] = w[y++];
			} else if (y > fim) {
				v[i] = w[k++];
			} else if (w[k] < w[y]) {
				v[i] = w[k++];
			} else {
				v[i] = w[y++];
			}
			trocas++;
		}
	}
}
