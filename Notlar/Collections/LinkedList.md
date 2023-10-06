LinkedList Sınıfı


Çift yönlü bağlı liste algoritmasının Java implementasyonudur. Her eleman önceki ve sonraki elemanını işaret edecek şekilde iki yönlü bir ilişki kurulmuştur. Listenin ben başına hem sonuna eleman eklenip çıkarılabilir, bu işlemler için metotlar mevcuttur. LinkedList’te eleman silme veya araya eleman ekleme durumlarında kaydırma işlemi yapılmaz.



img



Bu listeye gönderilen veriler, arka planda özel bir obje ile sarılır (wrap) edilir. Bu objeler birbirini gösterecek şekilde referanslar objelere konur, böylece birbirlerine bağlanırlar.



Kullanılacak veri grubunu bir listeye koymamız ve bu gruba veri ekleme işlemi sürekli yapılacaksa, LinkedList kullanılması önerilir.



LinkedList sınıfı, ArrayList gibi thread-safe değildir. Bu List türünde de veri bütünlüğünü sorunu vardır.



LinkedList, hem List interface'inden hem Queue (Kuyruk) interface'inden miras alan bir sınıftır.



Sınıf imzası;



public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable  






 
List<String> nameList = new LinkedList<String>();
nameList.add("Hale");
nameList.add("Jale");
nameList.add("Lale");
nameList.add("Ahmet");
nameList.add("Mehmet");
nameList.add("Kemal");
 
// get ile listeden eleman okuması yapılır. Okunan eleman listeden çıkartılmaz.
System.out.println("Element of 2 index: " + nameList.get(2));

// Liste başına eleman ekler
nameList.addFirst("Naz");

// Liste sonuna eleman ekler
nameList.addLast("Ümit");
