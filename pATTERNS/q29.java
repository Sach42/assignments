import java.util.Scanner;

public class q29 {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nsp = n;
        int num = 1;
        int numPrint = 1;
        for(int i = 1;i<=n;i++)
        {

            for(int j = 1;j<nsp;j++)
            {
                System.out.print("\t");
            }

            for(int j = 1;j<=num;j++)
            {
                if(j==1||j==num) {
                    System.out.print(numPrint + "\t");
                }
                else
                {
                    System.out.print("0\t");
                }
            }
            System.out.println();
            num+=2;
            nsp--;
            numPrint++;

        }
    }
}
