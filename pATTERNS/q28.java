import java.util.Scanner;

public class q28 {
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
            int number = numPrint;
            for(int j = 1;j<=num;j++)
            {
                System.out.print( number+ "\t");
                if(j<=num/2)
                    number++;
                else
                    number--;
            }
            System.out.println();
            num+=2;
            nsp--;
            numPrint++;

        }

    }
}
