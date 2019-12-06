package projeto;


public class HashFunction {
	

	private int n;// tamanho bloom filter/min hash
	private int k; // numero de hash functions
	private long p; // numero primo
	private long[] a;
	private long[] b;
	private long[] c;

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
		this.a=new long[this.k];
		this.b=new long[this.k];
		this.c=new long[this.k];



		for(int i=0;i<this.k;i++) {
			
			a[i]=1+(long)(Math.random()*(this.p-1));// a[i]=[1,(p-1)]
			b[i]=(long)(Math.random()*(this.p));// b[i]=[0,(p-1)]
			c[i]=1+(long)(Math.random()*(this.p-1));// c[i]=[1,(p-1)]
						
			}
		}
	
	// devolve um numero primo grande
	private long getPrime() {
		
		int ff=1000;
		long pp;
		if(n!=0) {
		pp= (long) (ff * (this.n + 1.76));
		}else {
		pp=100001;
		}
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
	public long HashCode(String chave,int hashNumber) {

		long hk;// hash code
		int [] key=stringToInt(chave,chave.length());
		
		
		
	hk=key[0];
	for(int i=1;i<chave.length();i++) {
			hk =( ( c[hashNumber]*hk + key[i]  ) % p) ;
			
	}
	if(n!=0) {
		hk=( (a[hashNumber]*hk+b[hashNumber])%p);
			hk=(hk % n);
	}

		return hk;

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






}
