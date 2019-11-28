package teste;

public class minHash {
	public int hashFunction(String a, int m) {
		int soma=0;
		for(int i=0; i<a.length(); i++) {
			int value=a.charAt(i);
			soma+=value;
		}
		return (soma*5381)%m;
	}
	
	public int[] minHash(String[] str, int n, int m) {
		//n é o numero de hashfunctions
		int[] minHashArray = new int[n];
		for(int i=0; i<n; i++){
			int min=hashFunction(str[0], 10);
			for(int j=1; j<str.length; j++) {
				int temp=hashFunction(str[j]+i, m);
				if(temp < min){
					min=temp;
				}
			}
			minHashArray[i]=min;
		}
		return minHashArray;
	}
	
	
}
