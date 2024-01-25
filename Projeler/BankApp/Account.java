package BankApp;

public class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    double paraCekmek(double a){
        return balance-a;
    }
    double paraYatirmak(double a){
        return this.balance+a;
    }
    public  void havale(Account hedefAccount,double miktar,double kesinti){
        balance-=miktar;
        hedefAccount.paraYatirmak(miktar-kesinti);
        System.out.println("Havale Başarılı" + balance);

    }
}
