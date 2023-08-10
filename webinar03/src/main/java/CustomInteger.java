public class CustomInteger extends CustomNumber {

    public int value;

    public CustomInteger(int i) {
        this.value = i;
    }

    public CustomInteger plus(CustomInteger ci) {
        return new CustomInteger(value + ci.value);
    }



    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomInteger{" +
                "value=" + value +
                '}';
    }

    @Override
    public CustomNumber plus(CustomNumber cn) {
        return this.plus((CustomInteger) cn);
    }
}
