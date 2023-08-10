public class CustomLong extends CustomNumber {

    public long value;

    public CustomLong(long value) {
        this.value = value;
    }

    public CustomLong plus(CustomLong ci) {
        return new CustomLong(value + ci.value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomLong{" +
                "value=" + value +
                '}';
    }

    @Override
    public CustomNumber plus(CustomNumber cn) {
        return this.plus((CustomLong) cn);
    }
}
