package projeto;

import java.util.ArrayList;
import java.util.Random;

public class HashFunction {
	

	private int n;// tamanho bloom filter/min hash
	private int k; // numero de hash functions
	private int p; // numero primo
	private int[] a;
	private int[] b;
//	private int[] c;// vetor de numeros aleatorios
	
	// construtores


	// bloom filter
	public HashFunction(int k,int n) {
		super();
		this.k = k;
		this.n=n;
		this.p=getPrime();
		randomHash();

	}

	// min hash
	public HashFunction(int k) {
		this.k = k;
		this.p=getPrime();
		randomHash();
	}

	private void randomHash(){
		
		

		// gerar vetores aleatorios
		this.a=new int[this.k];
		this.b=new int[this.k];
//		this.c=new int[this.k];


		Random r= new Random();
		for(int i=0;i<this.k;i++) {
			
			a[i]=r.nextInt(this.p-1);;// a[i]=[1,(p-1)]
			b[i]=r.nextInt(this.p-1);// b[i]=[0,(p-1)]
//			c[i]=r.nextInt(this.p-2)+1;;// c[i]=[1,(p-1)]
						
			}
		}
	
	// devolve um numero primo grande
	private int getPrime() {
		
//		int ff=1000;
//		double pp=  (ff * (this.n + 1.76));
		int pp=1000001;
		// tornar o numero impar
		if(pp%2==0) {
			pp++;
		}
		while(IsPrime(pp)==false) {
			pp+=2;
		}
		return pp;
	}
	
	// verifica se M é um numero primo
	private boolean IsPrime(double M) {
		
		
		
		for(int i=2;i<Math.sqrt(M);i++) {
			
			if(M%i==0) 
				return false;
		}
		return true;
	}
	
	// devolve o hash code da key
	public int[] HashCode(String chave) {

		int[] hk=new int[this.k];// hash code
		int tamanho=chave.length();// tamanho string
		int[] key=stringToInt(chave,tamanho);// string convertida em double

		for (int j=0;j<this.k;j++) {

		 // se so tiver uma entrada

		for (int i=0;i<tamanho;i++) {
			// devolve apenas o hash code
			hk[j] =hk[j]+(( this.a[j] * key[i] + this.b[j])% this.p);


		}

		// se quiser converter o hash code num posição
			if(n!=0)
				hk[j] = ( hk[j] % this.n );

		}

		return hk;

	}

	public int[] minHashode(ArrayList<String> items){

		int[] hk;
		int[] min= HashCode(items.get(0));

		for(int i=1;i<items.size();i++){

			hk=HashCode(items.get(i));

			for(int j=0;j<hk.length;j++){

				if(hk[j]<min[j])
					min[j]=hk[j];

			}

		}
		return min;
	}


	public int[] stringToInt(String s,int tamanho) {

		int[] keys=new int[tamanho];// array com as chaves
		int c;// caracter da string
		
		for(int i=0;i<tamanho;i++) {	
			c= s.charAt(i);
			keys[i]=c-47;
		}
		
		return keys;
	}

	public int[] getA() {
		return a;
	}



	public int[] getB() {
		return b;
	}
}
