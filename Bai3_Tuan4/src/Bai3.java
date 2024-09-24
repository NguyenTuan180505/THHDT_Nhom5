import java.util.Scanner;
public class Bai3 {
    public static int GiaiThua(int n)
    {
        int i,GT=1;
        for(i=1 ; i <= n; i++)
            GT = GT *i;
        return GT;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println("Giai Thua cua "+n+" la "+GiaiThua(n));
    }
}
