import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

       int  n=scanner.nextInt();
        recursiveIslem(n);
    }

    static void recursiveIslem(int n) {
        if (n <= 0) {
            System.out.println("Son Değer: " + n);
            return;
        }

        System.out.println("Son Değer: " + n);
        recursiveIslem(n - 5);
        System.out.println("Son Değer: " + n);
    }
}
