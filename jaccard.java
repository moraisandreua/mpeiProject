package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class jaccard {
	static ArrayList<String> users;
	static ArrayList<String> itens;
	static Map<String, ArrayList<String>> tabela = new Hashtable<>();
	
	public static double simJaccard(ArrayList<Integer> c1, ArrayList<Integer> c2) {
		double intercecao = 0;
		int tamanho = c1.size();
		ArrayList<Integer> uniao = new ArrayList<>();
		for(int i=0; i<tamanho; i++) {
			if(uniao.contains(c1.get(i))==false) {
				uniao.add(c1.get(i));
			}
			if(uniao.contains(c2.get(i))==false) {
				uniao.add(c2.get(i));
			}
			if(c2.contains(c1.get(i))) {
				intercecao=intercecao+1.0;
			}
		}
		double unionSize = (double) uniao.size();
		double res=intercecao/unionSize;
		return res;
	}

	public static void main(String args[]) throws IOException {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(5);
		l1.add(10);
		l1.add(15);
		
		l2.add(64);
		l2.add(53);
		l2.add(1);
		l2.add(2);
		l2.add(3);
		
		double similaridade = simJaccard(l1, l2);
		double distancia = 1-similaridade;
		System.out.printf("Similaridade: %f\nDiferença: %f\n",similaridade, distancia);
		ArrayList<String> bd = new ArrayList<>();
		readDB("bd.txt");
		
		
		//System.out.println(tabela.get("UserA"));
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
