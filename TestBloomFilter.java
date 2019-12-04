package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*TODO: testar para conjuntos maiores*/
public class TestBloomFilter {
	static Map<String, ArrayList<String>> tabela = new Hashtable<>();
    public static void main(String[] args) throws IOException {
    	readDB("bd.txt");

	    List<String> c1=tabela.get("UserA");
	    List<String> c2=tabela.get("UserB");
	    int n=c1.size();// numero de elementos do conjuntos
	    double pfp=0.6;// probabilidade de falsos positivos
	    
	    BloomFilter b=new BloomFilter(n,pfp);
	// adcionar elementos
	    for(int i=0;i < n ;i++){
	        b.adicionarElemento(c1.get(i));
	    }
	
	    // calculo de falsos positivos
	    int counter =0;
	    int fp=0;// numero de falsos positivos
	    for(int j=0;j<c2.size();j++){
	    	if(b.membro(c2.get(j)))
	    		counter++;
	        if(b.membro(c2.get(j)) && !c1.contains(c2.get(j)))
	            fp++;
	    }
	    System.out.printf("Numero de falsos positivos:%d\n", fp);
	    System.out.printf("Numero de falsos positivos(teoŕico):%d \n",(int)(pfp*c2.size()));
	    System.out.printf("Numero de pertenças:%d \n",counter);
	    System.out.printf("---------------------------\n");
	//    TestHashFunction.writeData("khash.csv",);
	/*
	    for(int k=1;k<=20;k++){
	        int x=kinBloom(c1,c2,k);
	
	        System.out.println(x);
	
	        }
	*/

    }
    // testa o efeiro de k nos falsos positivos
    static int kinBloom(List<String> c,List<String> teste,int k){

        int m=c.size();
        int fp=0;

        BloomFilter b= new BloomFilter(m,0.01,k);
        for (int i=0;i<m;i++){
            b.adicionarElemento(c.get(i));
        }
        for(int j=0;j< teste.size();j++){

            if( b.membro( teste.get(j) ) && !c.contains(  teste.get(j) ) )
                fp++;

        }
        return fp;


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
