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
		this.n=(int)( ( (-m) * Math.log(pfp) ) / (Math.pow(Math.log(2), 2)));
		this.k=(int)( (n * Math.log(2)) / m);// k otimo
		this.bloom=new int[n];
		this.h = new HashFunction(this.k, this.n);
	}

	public BloomFilter(int m,double pfp,int k){
		super();
		this.m=m;
		this.k=k;
		this.n=(int)( ( (-m) * Math.log(pfp) ) / (Math.pow(Math.log(2) ,2 ) ) );
		this.bloom=new int[n];
		this.h = new HashFunction(this.k, this.n);
	}

	public void adicionarElemento(String palavra){
		int[] pos=new int[this.k];
	for(int i=0;i<this.k;i++) {
		
		pos[i] =(int) h.HashCode(palavra,i);
	
		if(!membro(palavra))
			this.bloom[(pos[i])]=1;
		
	}
	}
	
	// testa se o elemento existe no filtro
	public boolean membro(String palavra) {

		int[] pos= new int[k];
		boolean retval=true;

	for(int i=0;i<this.k;i++) {
		pos[i]=(int)h.HashCode(palavra,i);
		if(this.bloom[(int)pos[i]]==0)
			retval=false;
		}
		return retval;
	}

}
