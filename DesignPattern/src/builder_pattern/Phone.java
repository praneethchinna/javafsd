package builder_pattern;

public class Phone
{
    private String phoneBrand;
    private int price;
    private String Os;
    private int battery;

    public Phone(String phoneBrand, int price, String os, int battery) {
        this.phoneBrand = phoneBrand;
        this.price = price;
        Os = os;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneBrand='" + phoneBrand + '\'' +
                ", price=" + price +
                ", Os='" + Os + '\'' +
                ", battery=" + battery +
                '}';
    }
}
