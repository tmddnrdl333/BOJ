import java.util.*;

class M {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	String a = sc.next();
	sc.close();

	int[] arr = new int[a.length()];

	for(int i =0;i<a.length();i++){
		arr[i]=a.charAt(i)-'0';
	}

	Arrays.sort(arr);

	for(int i =a.length();i>0;i--)
	System.out.print(arr[i-1]);



  }
}

