package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class TestMinHash {

	static HashMap<String, ArrayList<String>> tabela = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
    	
    	readDB("bd.txt");
    	
		HashMap<String, ArrayList<String>> dados;
		dados=tabela;
		ArrayList<String>sA = tabela.get("UserA");
		ArrayList<String>sB = tabela.get("UserB");
		ArrayList<String>sC = tabela.get("UserC");
		ArrayList<String>sD = tabela.get("UserD");
		ArrayList<String>sE = tabela.get("UserE");
		ArrayList<String>sF = tabela.get("UserF");
		minHash m=new minHash(10000,dados);
		m.PrintSignatures();
		System.out.printf("---------------------------------------------------\n");
		m.PrintSignatures();
		double simAB=m.Similaridade(0,1); // similaridade entre o user na posição 0 (UserA) e o user na posição 1 (UserB)
		System.out.printf("A similaridade entre o UserA e o UserB é de: %f\n",simAB);
		System.out.println("Itens do UserA \t" + sA);
		System.out.println("Itens do UserB \t" + sB + "\n");

		double simCD=m.Similaridade(2,3); // similaridade entre o user na posição 2 (UserC) e o user na posição 3 (UserD)
		System.out.printf("A similaridade entre o UserC e o UserD é de: %f\n",simCD);
		System.out.println("Itens do UserC \t" + sC);
		System.out.println("Itens do UserD \t" + sD + "\n");
		
		double simEF=m.Similaridade(4,5); // similaridade entre o user na posição 4 (UserE) e o user na posição 5 (UserF)
		System.out.printf("A similaridade entre o UserE e o UserF é de: %f\n",simEF);
		System.out.println("Itens do UserE \t" + sE);
		System.out.println("Itens do UserF \t" + sF + "\n");
    }


    /*public static  HashMap<String, ArrayList<String>> readFile(String fileName){
    	HashMap<String, ArrayList<String>> d =new HashMap<>();
	    try {
	        String s;
	        String[] dados;
	        Scanner sc = new Scanner(new File(fileName));
	        sc.nextLine();
	        while (sc.hasNext()) {
	            s=sc.nextLine();
	           dados=s.split(",");
	           if(d.containsKey(dados[0])){
	
	               d.get(dados[0]).add(dados[1] ) ;
	           }
	           else {
	               d.put(dados[0], new ArrayList<>());
	               d.get(dados[0]).add(dados[1]) ;
	           }
	           break;
	
	        }
	        sc.close();
	    }catch (FileNotFoundException e){
	        e.printStackTrace();
	    }
	    return d;						
    }*/
	public static void readDB(String filename) throws IOException {
	    Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+"/src/"+filename);
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    String st;
	    while ((st = br.readLine()) != null) {
	        String[] obj = st.split("->");
	        if(tabela.containsKey(obj[0])==false) {
	            tabela.put(obj[0], new ArrayList<>());
	            tabela.get(obj[0]).add(obj[1]);
	        }else{
	            tabela.get(obj[0]).add(obj[1]);
	        }
	    }
	}
}
