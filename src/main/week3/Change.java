
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
      int count = 0,rem=0;
      if(m>=10) {
          count = m / 10;
          rem = m % 10;
              count=count+rem/5;
              rem=rem%5;
              count=count+rem;
      }
     else  if(m>=5){
          count= count+m/5;
          rem=m%5;
          count=count+rem;
      }
     else{
         count=m;
      }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

