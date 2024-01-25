package BankApp;

public class AccountClient {
    public static void main(String[] args) {
        // Örnek hesap oluşturuluyor
        Account account1 = new Account(1000);

        // Para yatırma
        account1.paraYatirmak(500);

        // Para çekme
        account1.paraCekmek(200);

        // Başka bir hesaba havale yapma
        Account account2 = new Account(500);
        double transferAmount = 300;
        double transferFee = 5;
        account1.havale(account2, transferAmount, transferFee);

        // Hesap bakiyelerini kontrol etme
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}