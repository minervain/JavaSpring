public class Main {
    public static void main(String[] args) {
        Kitap book = new Kitap("Harry Potter", 500, "JK Rowling");

        //Encapsülation olayı anlamsızlığı ortadan gidermek olduğunu unutma
        

        book.setSayfaSayisi(120);
        System.out.println(book.getSayfaSayisi());
    }
}