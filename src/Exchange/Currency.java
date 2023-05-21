package Exchange;

public class Currency {
    private float value;
    private String name;

    public Currency(String name, float value){
        this.name = name;
        this.value = value;


    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
