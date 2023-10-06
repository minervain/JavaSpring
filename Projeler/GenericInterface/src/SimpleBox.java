// Generic arayüzü uygulayan sınıf
class SimpleBox<T> implements Box<T> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}