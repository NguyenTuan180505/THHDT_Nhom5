import java.util.Scanner;
public class Bai4 {
    public static boolean KTSNT(int n)
    {
        int i,SNT=0;
        if(n==1||n==2)
            return true;
        else
            for(i=2; i <= n; i++)
                if(n%i==0)
                   SNT=SNT+1;
        if(SNT==1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println("So "+n+" co phai so nguyen to khong "+KTSNT(n));
    }
}
