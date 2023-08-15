
import java.util.Scanner;

public class q13 {
    public static void main(String []args){
        Scanner sc =new Scanner (System.in);
        int n =sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j)
                    System.out.print("*"+"\t");
            }
            System.out.println();
        }
        for(int i=1;i<n;i++){

            for(int j=0;j<n;j++){

                if(i<=j)
                    System.out.print("*"+"\t");
            }
            System.out.println();
        }
    }
}
