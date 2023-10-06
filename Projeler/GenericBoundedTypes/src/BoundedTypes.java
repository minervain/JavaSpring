// Bounded type ile bir generic sınıf örneği
class BoundedTypeExample<T extends Number> {
    private T value;

    public BoundedTypeExample(T value) {
        this.value = value;
    }

    public double square() {
        return value.doubleValue() * value.doubleValue();
    }
}