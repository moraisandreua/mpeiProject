package projeto;

/*TODO:aplicar lhs*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class minHash {
//	public int hashFunction(String a, int m) {
//		int soma=0;
//		for(int i=0; i<a.length(); i++) {
//			int value=a.charAt(i);
//			soma+=value;
//		}
//		return (soma*
	private int k;// numero de hash functions
	private HashFunction h;// hashfunction
	private int[][] signatures;// assinaturas
	private HashMap<String, ArrayList<Integer>>  dados;// set com os dados de cada utilizador

	// construtor
	public minHash(int k, HashMap<String, ArrayList<Integer>> dados) {
		this.k=k;
		this.h = new HashFunction(k);
		this.dados = dados;
		minHash();

	}
// calcula a minhash
	public void minHash() {

		int ll=dados.keySet().size(); // numero de users
		this.signatures =new int[this.k][ll];
		int[]hk;

		for (int i=0;i<ll;i++){
			
				int min=-1;

				for(int l=0;l<dados.values().size();l++){



				}


		}



	}
	
	
}
