import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Fibonacci
        int count=0;
        int n1=0,n2=1;
        Scanner scanner=new Scanner(System.in);

        System.out.println("Sayı girin:");
        int sayi=scanner.nextInt();

        while (count<sayi){
            int n3=n1+n2;
            System.out.println(n3);
            n1=n2;
            n2=n3;
            count++;
        }


    }
}