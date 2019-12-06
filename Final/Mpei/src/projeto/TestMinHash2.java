package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class TestMinHash2 {
	static TreeMap<String, ArrayList<String>> tabela = new TreeMap<>();
	public static void main(String[] args) throws IOException {
		readDB("test.txt");
		
    	
		
	    
	    minHash m=new minHash(10000,tabela);
	    

	    
	   double exp= m.Similaridade(4, 5);
	   double t=m.Similaridade_Teorico(tabela.get("userE"), tabela.get("userF"));
	   
	   System.out.printf("exp:%f\n", exp);
	   System.out.printf("teorico:%f\n", t);
	}
	public static void readDB(String filename) throws IOException {
	    Scanner sc=new Scanner(new File(filename));
	 

	    while ( sc.hasNextLine() ) {
	        String[] obj = sc.nextLine().split(",");
	        
	        if(tabela.containsKey(obj[0])==false) {
	        	System.out.println(obj[0]);
	            tabela.put(obj[0], new ArrayList<>());
	            tabela.get(obj[0]).add(obj[1]);
	        }else{
	            tabela.get(obj[0]).add(obj[1]);
	        }
	    }
}
}
