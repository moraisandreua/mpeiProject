package projeto;

/*TODO:aplicar lhs*/

import java.lang.reflect.Array;
import java.util.*;

public class minHash {
	private int k;// numero de hash functions
	private HashFunction h;// hashfunction
	private int[][] signatures;// assinaturas
	private Map<String, ArrayList<String>> dados;// set com os dados de cada utilizador

	// construtor
	public minHash(int k, TreeMap<String, ArrayList<String>> dados) {
		this.k = k;
		this.h = new HashFunction(k);
		this.dados = dados;
		CalculateminHash();

	}
	
	

	// calcula a minhash
	public void CalculateminHash() {

		int ll = dados.keySet().size();
		this.signatures = new int[ll][this.k];
		int[] hk;
		String[]user=dados.keySet().toArray(new String[ll]);
		
		for(int j=0;j<ll;j++) {
			for (int i = 0; i < this.k; i++) {
				signatures[j][i] = minHashode(dados.get(user[j]),i);

			}
		
		}

	}
	
	

	public void addElements(String user, ArrayList<String> key) {
		if (this.dados.containsKey(user)) {
			this.dados.get(user).addAll(key);
		} else {
			this.dados.put(user, new ArrayList<>());
			this.dados.get(user).addAll(key);
		}
		CalculateminHash();
	}
	
	

	public void PrintSignatures() {

		for (int i = 0; i < this.signatures.length; i++) {
			System.out.printf("user" + i + "\t");
			for (int j = 0; j < this.k; j++) {

				System.out.printf("%5d ", this.signatures[i][j]);
			}
			System.out.println();
		}
	}
	
	

	public double Similaridade(int user1, int user2) {
		double sim;
		double cont = 0;
		for (int i = 0; i < this.k; i++) {
			if (this.signatures[user1][i] == this.signatures[user2][i]) {
				cont++;
			}
		}
		sim = (cont / this.k);
		return sim;
	}

	public int minHashode(ArrayList<String> items,int hashValue) {
		
		int[] hk = new int[items.size()];
		int min = Integer.MAX_VALUE;
		for(int i=0;i< items.size();i++) {
			
		}

			for (int i = 0; i < items.size(); i++) {
				 
				hk[i] = (int) h.HashCode(items.get(i), hashValue);

			}

		for (int j = 0; j < hk.length; j++) {

			if (hk[j] < min) {
				min = hk[j];
			}

		}
		return min;

	}

	public double Similaridade_Teorico(ArrayList<String> user1, ArrayList<String> user2) {

		Set<String> inter = new HashSet<>();
		int union, tamanho;
		double sim;
		tamanho = user1.size() + user2.size();

		for (int i = 0; i < user1.size(); i++) {

			for (int j = 0; j < user2.size(); j++) {

				if (user1.get(i).equals(user2.get(j))) {

					inter.add(user1.get(i));
				}

			}
		}
		union = tamanho - inter.size();
		sim = (inter.size() * 1.0) / union;
		return sim;
	}

	
	
	public int[][] getSignatures() {
		return signatures;
	}
}
