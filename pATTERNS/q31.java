import java.util.Scanner;

public class q31 {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++)
        {
            for(int j = n;j>=1;j--)
            {
                if(i==j)
                {
                    System.out.print("*\t");
                }
                else {
                    System.out.print(j + "\t");
                }
            }
            System.out.println();
        }
    }
}
