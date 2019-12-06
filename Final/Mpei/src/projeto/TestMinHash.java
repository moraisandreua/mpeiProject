package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class TestMinHash {

//	static HashMap<String, ArrayList<String>> tabela = new HashMap<>();
	
    public static void main(String[] args){
    	
    	HashMap<String, ArrayList<String>> tabela = new HashMap<>();
    	
    	File file = new File("tags.txt");
    	Scanner sc=null;
	    try {
	        String s;
	        String[] dados;
	        sc = new Scanner(file);
	        while (sc.hasNext()) {
	            s=sc.nextLine();
	           dados=s.split(",");
	           if(tabela.containsKey(dados[0])){
	
	               tabela.get(dados[0]).add(dados[1] ) ;
	           }
	           else {
	        	   tabela.put(dados[0], new ArrayList<>());
	        	   tabela.get(dados[0]).add(dados[1]) ;
	           }
	
	        }
	        sc.close();
	    }catch (FileNotFoundException e){
	    	System.out.println("ficheiro inexistente");
	        e.printStackTrace();
	    }			
    	
//		HashMap<String, ArrayList<String>> dados;
//		dados=tabela;
		ArrayList<String>sA = tabela.get("UserA");
		ArrayList<String>sB = tabela.get("UserB");
		ArrayList<String>sC = tabela.get("UserC");
		ArrayList<String>sD = tabela.get("UserD");
		ArrayList<String>sE = tabela.get("UserE");
		ArrayList<String>sF = tabela.get("UserF");
		minHash m=new minHash(10,tabela);
		m.PrintSignatures();
		System.out.printf("---------------------------------------------------\n");
//
		double simAB=m.Similaridade_Teorico(sA, sB); // similaridade entre o user na posição 0 (UserA) e o user na posição 1 (UserB)
		System.out.printf("A similaridade entre o UserA e o UserB s�o de: %f\n",simAB);
		System.out.println("Itens do UserA \t" + sA);
		System.out.println("Itens do UserB \t" + sB + "\n");
//
		double simCD=m.Similaridade(2,3);// similaridade entre o user na posição 2 (UserC) e o user na posição 3 (UserD)
		double simCD2=m.Similaridade_Teorico(sC, sC);
		System.out.printf("A similaridade entre o UserC e o UserD é de: %f\n",simCD);
		System.out.printf("A similaridade teorica entre o UserC e o UserD é de: %f\n",simCD2);
		System.out.println("Itens do UserC \t" + sC);
		System.out.println("Itens do UserD \t" + sD + "\n");
//		
	double simEF=m.Similaridade(4,5); // similaridade entre o user na posição 4 (UserE) e o user na posição 5 (UserF)
		System.out.printf("A similaridade entre o UserE e o UserF é de: %f\n",simEF);
		System.out.println("Itens do UserE \t" + sE);
		System.out.println("Itens do UserF \t" + sF + "\n");
   }


//    public static void readFile(String fileName){
//
//    	File file =new File("qaz.txt");
//    	Scanner sc=null;
//	    try {
//	        String s;
//	        String[] dados;
//	        sc = new Scanner(file);
//	        sc.nextLine();
//	        while (sc.hasNext()) {
//	            s=sc.nextLine();
//	           dados=s.split(",");
//	           if(tabela.containsKey(dados[0])){
//	
//	               tabela.get(dados[0]).add(dados[1] ) ;
//	           }
//	           else {
//	        	   tabela.put(dados[0], new ArrayList<>());
//	        	   tabela.get(dados[0]).add(dados[1]) ;
//	           }
//	           break;
//	
//	        }
//	        sc.close();
//	    }catch (FileNotFoundException e){
//	    	System.out.println("ficheiro inexistente");
//	        e.printStackTrace();
//	    }					
//    }
//	public static void readDB(String filename) throws IOException {
//	    Scanner sc=new Scanner(new File(filename));
//	 
//
//	    while ( sc.hasNextLine() ) {
//	        String[] obj = sc.nextLine().split("->");
//	        
//	        if(tabela.containsKey(obj[0])==false) {
//	        	System.out.println(obj[0]);
//	            tabela.put(obj[0], new ArrayList<>());
//	            tabela.get(obj[0]).add(obj[1]);
//	        }else{
//	            tabela.get(obj[0]).add(obj[1]);
//	        }
//	    }
//	}
}
