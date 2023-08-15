
import java.util.Scanner;

public class q14 {
    public static void main(String []args){
        Scanner sc =new Scanner (System.in);
        int n =sc.nextInt();
        for(int i = n-1; i >=0; --i) {
            for(int j = 0; j < n; ++j) {
                if (i>  j) {
                    System.out.print("\t");
                }
                else{
                    System.out.print("*\t");
                }
            }

            System.out.println();
        } for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j)
                    System.out.print("\t");
                else{
                    System.out.print("*"+"\t");
                }
            }

            System.out.println();
        }
    }
}
