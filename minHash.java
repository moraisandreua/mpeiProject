package projeto;

/*TODO:aplicar lhs*/

import java.lang.reflect.Array;
import java.util.*;

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
	private HashMap<String, ArrayList<String>>  dados;// set com os dados de cada utilizador

	// construtor
	public minHash(int k, HashMap<String, ArrayList<String>> dados) {
		this.k=k;
		this.h = new HashFunction(k);
		this.dados = dados;
		minHash();

	}
	// calcula a minhash
	public void minHash() {

		int ll=dados.keySet().size();
		this.signatures =new int[ll][this.k];
		int[]hk;
		int user=0;


		Iterator<Map.Entry<String, ArrayList<String>>> itr=dados.entrySet().iterator();
		while(itr.hasNext()){

				signatures[user]=h.minHashode(itr.next().getValue());

			user++;
		}


		for (int i=0;i<ll;i++){


//			int min=h.hashCode(dados.get());
			for(int l=1;l<dados.values().size();l++){



			}


		}


	}

	public int[][] getSignatures() {
		return signatures;
	}
}
