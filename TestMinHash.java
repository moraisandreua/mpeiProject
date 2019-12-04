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

	static Map<String, ArrayList<String>> tabela = new Hashtable<>();
	
    public static void main(String[] args) throws IOException {
    	
    	readDB("bd.txt");
    	
		HashMap<String, ArrayList<String>> dados;
		dados= readFile("tags.csv");
		ArrayList<String>s = tabela.get("UserA");
		minHash m=new minHash(10,dados);
		m.PrintSignatures();
		System.out.printf("-----------------------------------------------\n");
		m.addElements("7",s);
		m.PrintSignatures();
		double sim=m.Similaridade(0,1);
		System.out.printf("A similaridade é de: %f\n",sim);
    }


    public static  HashMap<String, ArrayList<String>> readFile(String fileName){
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
    }
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
