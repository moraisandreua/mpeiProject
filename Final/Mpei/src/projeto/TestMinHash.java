package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class TestMinHash {
	static TreeMap<String, ArrayList<String>> tabela = new TreeMap<>();
	public static void main(String[] args) throws IOException {
		readDB("test.txt");
	   
		ArrayList<String>sA = tabela.get("userA");
		ArrayList<String>sB = tabela.get("userB");
		ArrayList<String>sC = tabela.get("userC");
		ArrayList<String>sD = tabela.get("userD");
		ArrayList<String>sE = tabela.get("userE");
		ArrayList<String>sF = tabela.get("userF");
		minHash m=new minHash(1000,tabela);
		m.PrintSignatures();
		System.out.printf("---------------------------------------------------\n");
//
		double simAB=m.Similaridade_Teorico(sA, sB); // similaridade entre o user na posição 0 (UserA) e o user na posição 1 (UserB)
		double simAB2=m.Similaridade_Teorico(sA, sB);
		System.out.printf("A similaridade entre o UserA e o UserB s�o de: %f\n",simAB);
		System.out.printf("A similaridade teórica entre o UserA e o UserB s�o de: %f\n",simAB2);
		System.out.println("Itens do UserA \t" + sA);
		System.out.println("Itens do UserB \t" + sB + "\n");
//
		double simCD=m.Similaridade(2,3);// similaridade entre o user na posição 2 (UserC) e o user na posição 3 (UserD)
		System.out.printf("A similaridade entre o UserC e o UserD é de: %f\n",simCD);
		System.out.println("Itens do UserC \t" + sC);
		System.out.println("Itens do UserD \t" + sD + "\n");
//		
		double simEF=m.Similaridade(4,5); // similaridade entre o user na posição 4 (UserE) e o user na posição 5 (UserF)
		System.out.printf("A similaridade entre o UserE e o UserF é de: %f\n",simEF);
		System.out.println("Itens do UserE \t" + sE);
		System.out.println("Itens do UserF \t" + sF + "\n");
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
