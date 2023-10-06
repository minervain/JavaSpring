import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // Eğer girilen tutar 0 ve 1000 TL arasında ise KDV oranı %18 , tutar 1000 TL'den büyük ise KDV oranını %8 olarak KDV tutarı hesaplayan programı yazınız.

        int tutar;
        Scanner input=new Scanner(System.in);
        System.out.println("TutarG Girin:");

        tutar=input.nextInt();

        int HesapSonucu= tutar<1000 && tutar>0 ? tutar*18/100:tutar*8/100;

        System.out.println("Hesabın kdvsi:"+HesapSonucu);

    }
}