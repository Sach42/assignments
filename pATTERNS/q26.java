import java.util.Scanner;

public class q26 {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nsp = n;
        int num = 1;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<nsp;j++)
            {
                System.out.print("\t");
            }
            for(int j = 1;j<=num;j++)
            {
                System.out.print(j+"\t");

            }
            System.out.println();

            nsp--;
            num+=2;
        }
    }
}
