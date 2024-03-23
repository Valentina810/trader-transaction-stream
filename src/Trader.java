public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Trader:" + name + " in " + city;
    }
}