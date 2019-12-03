package projeto;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*TODO: testar para conjuntos maiores*/
public class TestBloomFilter {

    public static void main(String[] args) {


    List<String> c1=new ArrayList<>(List.of("Portugal", "França", "Espanha", "Alemanha" ));

    List<String> c2=new ArrayList<>(List.of("Brasil", "Panamá", "Bélgica", "Inglaterra", "Finlândia","Alemanha","Portugal"));
    int n=4;// numero de elementos do conjuntos
    double pfp=0.01;// probabilidade de falsos positivos

    BloomFilter b=new BloomFilter(n,pfp);
// adcionar elementos
    for(int i=0;i < n ;i++){
        b.adicionarElemento(c1.get(i));
    }

    // calculo de falsos positivos
    int fp=0;// numero de falsos positivos
    for(int j=0;j<c2.size();j++){

        if(b.membro(c2.get(j)) && !c1.contains(c2.get(j)))
            fp++;
    }
    System.out.printf("Numero de falsos positivos:%d\n", fp);
    System.out.printf("Numero de falsos positivos(teoŕico):%d \n",(int)(pfp*c2.size()));

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

}
