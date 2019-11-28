package projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestHashFunction {

	public static void main(String[] args) {
		
	int[][] b1=new int[6][86562];
	
	double[] h= new double[6];
		
	HashFunction hk = new HashFunction(6,86562);
		
		// gerar 100 chaves pseudo aleatorias
		
		for(int i=0;i<10000;i++) {
			
			hk.HashCode(geraString());
			
			for(int j=0;j<6;i++) {
				
				b1[j][(int)h[j]]+=1;
			}
				
		}
		
		for(int i=0;i<6;i++) {
			
			writeData("hist"+i+".csv",b1[i]);
			
		}
		
	}
	
public static void writeData(String path,int[] d) {
	
	
	int ll=d.length;
	try {
		FileWriter outputfile = new FileWriter(path);
		PrintWriter p = new PrintWriter(outputfile);
		
		for(int i=0;i<ll;i++) {
			
			p.printf("%d ",i);
			p.println(d[i]);
			p.close();
		}
		
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
		
		tamanho=rand.nextInt(10);
			
		StringBuilder s=new StringBuilder();
		
		for(int i=0;i<tamanho;i++) {
			pos=rand.nextInt(alpha.length);
			
			s.append(alpha[pos]);
   
		
	}
		return s.toString();
	}
	
	
}
	
	
	


