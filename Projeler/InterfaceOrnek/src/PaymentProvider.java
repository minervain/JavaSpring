public interface PaymentProvider {
    // interface içinde yer alan fonksiyonların hepsi soyuttur. // Bu soyut fonksiyonlar interface'den kalıtım alan alt sınıflarda doldurulur. public boolean cancelCharge(int chargeId);
    public int charge(double totalPrice);
    public String loadInvoice(int chargeId);
}