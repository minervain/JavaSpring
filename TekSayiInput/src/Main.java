import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sayi=0,toplam=0;
        while(!(sayi%2==1)){

            System.out.println("Sayi gir");
             sayi=scanner.nextInt();
             if(sayi%4==0){
                 toplam+=sayi;
             }
        }

        System.out.println("TOPLAMLARI:"+toplam);
    }
}