import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);


        System.out.println("Dizinin Boyutu");
        int boyut= scanner.nextInt();
        int[] arr = new int[boyut];
        for(int i=0; i<boyut; i++){
            int a= scanner.nextInt();

            arr[i]=a;

        }

        for (int i=0;arr.length>i;i++){
            System.out.println((i+1)+".ELEMAN:  "+arr[i]);
        }
        Arrays.sort(arr);
        System.out.println("Sıralanmış Dizi Elemanları:");
        for (int i = 0; i < boyut; i++) {
            System.out.println(i + ". ELEMAN: " + arr[i]);
        }
    }
}