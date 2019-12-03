package projeto;

import java.util.Random; 

public class HashFunction {
	

	private int n;// tamanho bloom filter/min hash
	private int k; // numero de hash functions
	private double p; // numero primo
	private double[] a;
	private double[] b;
	private double[] c;// vetor de numeros aleatorios
	
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
		this.a=new double[this.k];
		this.b=new double[this.k];
		this.c=new double[this.k];
		
		for(int i=0;i<this.k;i++) {
			
			a[i]=Math.random()*(this.p-2)+1;;// a[i]=[1,(p-1)]
			b[i]=Math.random()*(this.p-1);// b[i]=[0,(p-1)]
			c[i]=Math.random()*(this.p-2)+1;;// c[i]=[1,(p-1)]
						
			}
		}
	
	// devolve um numero primo grande
	private double getPrime() {
		
		int ff=1000;
		double pp=  (ff * (this.n + 1.76));
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
		double[] key=stringToDouble(chave,tamanho);// string convertida em double

		for (int j=0;j<this.k;j++) {

		hk[j]=(int)key[0]; // se so tiver uma entrada

		for (int i=1;i<tamanho;i++) {
			// devolve apenas o hash code
			hk[j] =(int)(( this.c[j] * hk[j] + key[i] )% this.p);


		}
		// se quiser converter o hash code num posição
			hk[j] = (int)  ( ( ( ( ( this.a[j]) * hk[j] + this.b[j] ) % this.p) % this.n) );

		}

		return hk;

	}
	
	public double[] stringToDouble(String s,int tamanho) {

		double[] keys=new double[tamanho];// array com as chaves
		int c;// caracter da string
		
		for(int i=0;i<tamanho;i++) {	
			c= s.charAt(i);
			keys[i]=c-47;
		}
		
		return keys;
	}
	
	
}
