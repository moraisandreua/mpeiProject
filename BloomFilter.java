package projeto;


import java.lang.Math;

public class BloomFilter {
	
	private int n; // numero de bits/tamanho do filtro
	private int m; // numero de elementos do conjunto
	private int	k; // numero de hash functions
	private int[] bloom;// filtro
	private HashFunction h;
	private double pfp;// probabilidade de falsos positivos
	

	// construtor 
	public BloomFilter(int m,double pfp) {
		super();
		this.m=m;
		this.n=(int)(m*Math.log(pfp)/Math.log(1/Math.pow(2, Math.log(2))));
		this.k=(int)((n*Math.log(2))/m);// k otimo
		inicializar(n);

	}
	
	// incializar filtro com zeros
	public void inicializar(int n) {
		HashFunction h=new HashFunction(this.k);
		// vector e como se fosse um array dinamico
		this.bloom=new int[n];
		
		
	}
	
	// T-tipo generico
	// desta forma posso passar qualquer tipo de argumento(objeto) à função
	public void adicionarElemento(String palavra,int k ){
		
		int[] pos;;
		pos=h.HashCode(palavra);
		
		for(int i=0;i<this.k;i++) {
			if(!membro(palavra))
			this.bloom[pos[i]]=1;
		}
		
	}
	
	// testa se o elemento existe no filtro
	public boolean membro(String palavra) {
		
		boolean retval=true;
		int[] pos;;
		pos=h.HashCode(palavra);
	for(int i=0;i<this.k;i++) {
			
		if(this.bloom[pos[i]]==0) 
			retval=false;
		}
		return retval;
	}

}
