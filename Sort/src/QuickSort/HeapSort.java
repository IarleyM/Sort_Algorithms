package QuickSort;

import java.util.Arrays;

public class HeapSort {
	static int trocas = 0;
	
	public static void main (String [] args) {
		
		Teste1 t = new Teste1();
		Resultado resultado;
		int[] q = t.gerarVetor(10);
		int[] w = t.gerarVetor1(10000);
		int[] o = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println("Array Gerado Aleatoriamente:\n" + Arrays.toString(q) + "\n");
		
		//HeapSort
				System.out.println("HeapSort:");
				long ini2 = System.currentTimeMillis();
				resultado = HeapSort.sort(q.clone());
				long fim2 = System.currentTimeMillis();
				HeapSort.sort(q);
				
				//De -100 a 100
				System.out.println("De -100 a 100:\n" + Arrays.toString(q) );
				System.out.println("Tempo exe: " + (fim2 - ini2) + "ms");
				System.out.println("Trocas realizadas " + resultado.getTrocas());

				//De -10000 a 10000
				System.out.println("\nDe -10000 a 10000:");
				long ini5 = System.currentTimeMillis();
				resultado = HeapSort.sort(w.clone());
				long fim5 = System.currentTimeMillis();
				HeapSort.sort(w);
				System.out.println(Arrays.toString(w));
				System.out.println("Tempo exe: " + (fim5 - ini5) + "ms");
				System.out.println("Trocas realizadas " + resultado.getTrocas());
				
				//Ja ordenado
				System.out.println("\nTeste já ordenado");
				long ini3 = System.currentTimeMillis();
				resultado = QuickSort.quickSort(o.clone(), 0, o.length - 1);
				long fim3 = System.currentTimeMillis();
				QuickSort.quickSort(o, 0, o.length - 1);
				System.out.println(Arrays.toString(o));
				System.out.println("Tempo exe: " + (fim3 - ini3) + "ms");
				System.out.println("Trocas realizadas " + resultado.getTrocas());
	}

	public static Resultado sort(int[] v) {
		int n = v.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			aplicarHeap(v, n, i);
		}
		for (int j = n - 1; j > 0; j--) {
			int aux = v[0];
			v[0] = v[j];
			v[j] = aux;

			aplicarHeap(v, j, 0);
		}
		return new Resultado(v, trocas);
	}

	private static void aplicarHeap(int[] v, int n, int i) {
		int raiz = i;
		int esq = 2 * i + 1;
		int dir = 2 * i + 2;

		if (esq < n && v[esq] > v[raiz]) {
			raiz = esq;
		}
		if (dir < n && v[dir] > v[raiz]) {
			raiz = dir;
		}
		if (raiz != i) {
			int aux = v[i];
			v[i] = v[raiz];
			v[raiz] = aux;
			trocas++;

			aplicarHeap(v, n, raiz);
		}
	}
}
