
public class Bai1 {
    public static int TongS(int n)
    {
        int i, S=0;
        for(i=1; i <= n; i++)
            S = S+  i;
        return S ;
    }
    public static void main(String[] args) {
        System.out.println("Tong S= "+TongS(6)); 
    }
}
