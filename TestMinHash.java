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

minHash m=new minHash(4,dados);



int [][] sig=m.getSignatures();

for(int i=0;i<sig.length;i++){
    System.out.printf("user%d\t",i);
    for (int j=0;j<4;j++){

        System.out.printf("%5d ",sig[i][j]);
    }
System.out.println();
}

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

        }
        sc.close();


    }catch (FileNotFoundException e){
        e.printStackTrace();
    }

    return d;
}
}
