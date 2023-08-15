//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class q4 {
    public q4() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

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
        }

    }
}
