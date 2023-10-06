import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//Bir sayının kendisi hariç pozitif tam sayı çarpanları
// (kalansız bölen sayıların) toplamı kendisine eşit olan sayıya mükemmel sayı denir.

        Scanner scanner =new Scanner(System.in);
        System.out.println("Sayı giriniz");
        int sayi= scanner.nextInt();
        int result=0;
        for(int i=1;i<sayi;i++){

            if(sayi%i==0){
                result+=i;

            }

        }
       if(result==sayi){
           System.out.println("MÜKEMMEL SAYI>>>>"+sayi);
       }
       else System.out.println("MÜKEMMEL DEĞİL >>>"+sayi);

    }
}