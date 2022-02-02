import java.util.*;

public class Main {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String inp = sc.next();
    sc.close();

    int[] arr = new int[10];
    int len = inp.length();
    int maxIdx = 0;
    int max=0;
    for(int i = 0; i < len; i++){
      int tmp = inp.charAt(i);
      arr[tmp-'0']++;
      if(tmp-'0'==6||tmp-'0'==9){
        continue;
      } else if(arr[tmp-'0']>max){
        max = arr[tmp-'0'];
        maxIdx = tmp-'0';
      }
    }
    int a = Math.max(max,(arr[6]+arr[9]+1)/2);
    System.out.print(a);


  }
}