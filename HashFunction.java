package projeto;

import java.util.Random; 

public class HashFunction {
	
	
	private int n;// tamanho bloom filter
	private int k; // numero de hash functions
	private int p; // numero primo
	private int[] a;
	private int[] b;
	private int[] c;// vetor de numeros aleatorios
	
	// criar os numeros aleatorios
	public HashFunction(int k,int n) {
		super();
		this.k = k;
		this.n=n;
		this.p=getPrime();
		randomHash();

	}
	
	private void randomHash(){
		
		
		Random r=new Random();
		// gerar vetores aleatorios
		this.a=new int[this.k];
		this.b=new int[this.k];
		this.c=new int[this.k];
		
		for(int i=0;i<this.k;i++) {
			
			a[i]=r.nextInt(p-2)+1+1;// a[i]=[1,(p-1)]
			b[i]=r.nextInt(p-1)+1;// b[i]=[0,(p-1)]
			c[i]=r.nextInt(p-2)+1+1;// c[i]=[1,(p-1)]
						
			}
		}
	
	// devolve um numero primo grande
	private int getPrime() {
		
		int prime=10001;
		// tornar o numero impar
		if(prime%2==0) {
			prime++;
		}
		while(IsPrime(prime)==false) {
			prime+=2;
		}
		return prime;
	}
	
	// verifica se M é um numero primo
	private boolean IsPrime(int M) {
		
		
		
		for(int i=2;i<Math.sqrt(M);i++) {
			
			if(M%i==0) 
				return true;
		}
		return false;
	}
	
	// devolve o hash code da key
	public double[] HashCode(String chave) {
		
		double[] hk=new double[this.k];// hash code
		int tamanho=chave.length();// tamanho string
		double[] key=stringToDouble(chave,tamanho);// string convertida em double
		
		for (int j=0;j<this.k;j++) {
			
		hk[j]=key[1]; // se so tiver uma entrada
		
		for (int i=2;i<tamanho;i++) {
			hk[j] = (((this.c[j]) * hk[j] +key[i] )%this.p);
		}
		
		hk[j]=(((this.a[j])*hk[j]+this.b[j])%(this.p))%(this.n);
		
		}
		
		return hk;
		
	}
	
	public double[] stringToDouble(String s,int tamanho) {
		
		double[] keys=new double[tamanho];// array com as chaves
		double c;// caracter da string 
		
		for(int i=0;i<tamanho;i++) {	
			c=(double) s.charAt(i);
			keys[i]=c;	
		}
		
		return keys;
	}
	
	
}
