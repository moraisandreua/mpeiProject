package projeto;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
public class TestMinHash {


    public static void main(String[] args) {


HashMap<String, ArrayList<String>> dados;
dados= readFile("tags.csv");
ArrayList<String>s =new ArrayList<>();
s.add("60756");
s.add("89774");




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
}
