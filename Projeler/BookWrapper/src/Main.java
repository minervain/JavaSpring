import java.util.*;


public class Main {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();

        // Kitapları isme göre sıralamak için TreeSet kullanıyoruz
        Set<Book> sortedByTitleSet = new TreeSet<>();

        // Kitapları sayfa sayısına göre sıralamak için TreeSet'i yeni bir Comparator ile kullanıyoruz
        Set<Book> sortedByPageCountSet = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));


        // Kitap nesnelerini oluşturup Set'e ekliyoruz
        Book book1 = new Book("Book 1", 300, "Author 1", 2021-01-01);
        Book book2 = new Book("Book 2", 250, "Author 2", 2022-02-02);
        Book book3 = new Book("Book 3", 400, "Author 3", 2023-03-03);
        Book book4 = new Book("Book 4", 200, "Author 4", 2024-04-04);
        Book book5 = new Book("Book 5", 350, "Author 5", 2025-05-05);

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        // Set'i isme göre sıralanmış haliyle dolduruyoruz
        sortedByTitleSet.addAll(bookSet);

        // Set'i sayfa sayısına göre sıralanmış haliyle dolduruyoruz
        sortedByPageCountSet.addAll(bookSet);

        // Kitapları isme göre sıralanmış haliyle yazdırma
        System.out.println("Kitaplar isme göre sıralanmış hali:");
        for (Book book : sortedByTitleSet) {
            System.out.println(book.toString());
        }
        // Kitapları sayfa sayısına göre sıralanmış haliyle yazdırma
        System.out.println("Kitaplar sayfa sayısına göre sıralanmış hali:");
        for (Book book : sortedByPageCountSet) {
            System.out.println(book.toString());
        }

    }
}