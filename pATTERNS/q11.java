import java.util.Scanner;

public class q11 {
    public static void main(String []args){
        Scanner sc =new Scanner (System.in);
        int n= sc.nextInt();
        int space =(n*n/2-1)/2-1;
        int temp =1;

        for(int i=0;i<n;i++){ int x =space;
            int y=temp;


                while(x>0){
                    System.out.print("\t");
                    x--;
                }
                while(y>0) {
                    if(y%2==0){System.out.print("\t");}
                    else
                    {System.out.print("*\t");}
                    y--;

            }
            space--;
            temp+=2;
            System.out.println();
        }

    }
}
