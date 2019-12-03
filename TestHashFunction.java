package projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

public class TestHashFunction {

public static void main(String[] args) {
//	String[] TempItens= new String[5];
//	TempItens=readItens();
//
//	String[] TempUsers= new String[5];
//	TempUsers=readUsers();

	HashMap<Double,Integer>h=new HashMap<>();
	int[][] b1=new int[100000][6];

//	double[] h= new double[6];
		
HashFunction hk = new HashFunction(6,100000);

	String[] key=new String[100000];
	int ll=key.length;

	for(int i=0;i<ll;i++) {
		// gerar 100000 chaves pseudo aleatorias

		key[i] = geraString();
		b1[i]=hk.HashCode(key[i]);

	}


	for(int col=0;col<6;col++){

		for (int line=0;line<ll;line++) {

			writeData("hist" + col + ".csv",  (b1[line][col]));

		}

	}

//	for(int i=0;i<6;i++) {
//
//		writeData("hist"+i+".csv",b1[i]);
//
//	}
	
}
	
public static void writeData(String path,int key) {
	
	

	try {

		FileWriter outputfile = new FileWriter(path,true);
		PrintWriter p = new PrintWriter(outputfile);
		

			p.printf("%d\n",key);

		p.close();
		
	}catch(IOException e) {
		
		System.out.printf("Erro ao ler ficheiro\n");
	}

	
}
	
public static String geraString() {
		
        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
		Random rand = new Random();
		int tamanho;
		int pos;
		
		tamanho=rand.nextInt(10)+1;
			
		StringBuilder s=new StringBuilder();
		
		for(int i=0;i<tamanho;i++) {
			pos=rand.nextInt(alpha.length);
			
			s.append(alpha[pos]);
   
		
	}
		return s.toString();
	}
	
	public static String[] resizeArray(String[] a, int n) {
		String[] temp = new String[n+a.length];
		for(int i=0; i<a.length; i++) {
			temp[i]=a[i];
		}
		
		return temp;
	}
//
//	public static String[] readItens() throws IOException {
//		String[] itens= new String[5];
//		Path currentRelativePath = Paths.get("");
//		String s = currentRelativePath.toAbsolutePath().toString();
//		File file = new File(s+"/src/teste/itens.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String st;
//		int c=0;
//		while ((st = br.readLine()) != null) {
//			if(itens.length <= c) {
//				itens=resizeArray(itens, 2);
//			}
//			itens[c]=st;
//			c++;
//		}
//		return itens;
//	}
//
//	public static String[] readUsers() throws IOException {
//		String[] users= new String[5];
//		Path currentRelativePath = Paths.get("");
//		String s = currentRelativePath.toAbsolutePath().toString();
//		File file = new File(s+"/src/teste/users.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String st;
//		int c=0;
//		while ((st = br.readLine()) != null) {
//			if(users.length <= c) {
//				users=resizeArray(users, 2);
//			}
//			users[c]=st;
//			c++;
//		}
//		return users;
//	}
//
}
	
	
	


