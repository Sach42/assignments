import java.util.Scanner;

public class q6 {
    public static void main(String []args){
        Scanner sc =new Scanner (System.in);
        int n= sc.nextInt();
        int space =0;
        int temp =n;
        for(int i=0;i<n;i++){ int x =space;
            int y=temp;
            for(int j=0;j<n*2-1;j++){

                while(x>0){
                    System.out.print("\t");
                    x--;
                }
                while(y>0) {
                    System.out.print("*\t");
                    y--;
                }
            }
             space+=2;
            temp--;
            System.out.println();
        }



    }
}
