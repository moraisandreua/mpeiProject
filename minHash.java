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
	private Map<String, ArrayList<String>>  dados;// set com os dados de cada utilizador

	// construtor
	public minHash(int k, HashMap<String, ArrayList<String>> dados) {
		this.k=k;
		this.h = new HashFunction(k);
		this.dados = dados;
		minHash();

	}
	
	public minHash(int k, Hashtable<String, ArrayList<String>> dados) {
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

		}


	public void addElements(String user,ArrayList<String> key){
		if(this.dados.containsKey(user)) {
			this.dados.get(user).addAll(key);
		}
		else {
			this.dados.put(user, new ArrayList<>());
			this.dados.get(user).addAll(key);
		}
		minHash();
	}


	public  void PrintSignatures(){

		for(int i=0;i<this.signatures.length;i++){
			System.out.printf("user%d\t",i);
			for (int j=0;j<10;j++){

				System.out.printf("%5d ",this.signatures[i][j]);
			}
			System.out.println();
		}
	}


	public double Similaridade(int user1,int user2){

		double sim;
		double cont=0;

		for(int i=0;i<this.k;i++){

			if(this.signatures[user1][i]==this.signatures[user2][i]){
				cont++;

			}
		}
		sim=cont/this.k;
		return sim;
	}

	public int[][] getSignatures() {
		return signatures;
	}
}
