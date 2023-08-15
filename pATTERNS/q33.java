import java.util.Scanner;

public class q33 {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nst = 1;
        int nsp = n;
        int zeroPos = 1;
        int num = n;
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<nsp;j++)
            {
                System.out.print("\t");
            }
            int numPrint = num;
            for(int j = 1;j<=nst;j++)
            {
                if(j==zeroPos)
                {
                    System.out.print("0\t");
                }
                else {
                    System.out.print(numPrint+"\t");
                }
                if(j<=nst/2)
                {
                    numPrint++;
                }
                else
                {
                    numPrint--;
                }
            }
            System.out.println();
            nst+=2;
            nsp--;
            zeroPos++;
            num--;
        }
    }
}
