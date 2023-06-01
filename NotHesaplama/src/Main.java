import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int Mat, Fiz, Kim, tr;

        Scanner input =new Scanner(System.in);
        System.out.println("MAT:");
         Mat =input.nextInt();
        System.out.println("Fiz:");
        Fiz =input.nextInt();
        System.out.println("Kim:");
        Kim =input.nextInt();
        System.out.println("tr:");
        tr =input.nextInt();

        int Ort=(Mat+Fiz+Kim+tr)/4;
         String Gectimi= Ort>50 ? "Geçti" : "kaldı";

        System.out.println(Gectimi);
    }
}