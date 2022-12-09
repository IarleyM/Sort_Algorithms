package QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Teste1 {

	public int[] gerarVetor(int tam) {
		int[] random_int = new int[tam];
		int min = -100;
		int max = 100;

		for (int i = 0; i < random_int.length; i++) {
			random_int[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
		return random_int;
	}

	public int[] gerarVetor1(int tam) {
		int[] random_int = new int[tam];
		int min = -10000;
		int max = 10000;

		for (int i = 0; i < random_int.length; i++) {
			random_int[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
		}
		return random_int;
	}
}
