package projeto;

import java.util.ArrayList;

public class jaccard {

	public static double simJaccard(ArrayList<Integer> c1, ArrayList<Integer> c2) {
		double intercecao = 0;
		int tamanho = c1.size();
		ArrayList<Integer> uniao = new ArrayList<>();
		for(int i=0; i<tamanho; i++) {
			if(uniao.contains(c1.get(i))==false) {
				uniao.add(c1.get(i));
			}
			if(uniao.contains(c2.get(i))==false) {
				uniao.add(c2.get(i));
			}
			if(c2.contains(c1.get(i))) {
				intercecao=intercecao+1.0;
			}
		}
		double unionSize = (double) uniao.size();
		double res=intercecao/unionSize;
		return res;
	}

	public static void main(String args[]) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(5);
		l1.add(10);
		l1.add(15);
		
		l2.add(64);
		l2.add(53);
		l2.add(1);
		l2.add(2);
		l2.add(3);
		
		double similaridade = simJaccard(l1, l2);
		double distancia = 1-similaridade;
		System.out.printf("Similaridade: %f\nDiferença: %f\n",similaridade, distancia);
	}

}
