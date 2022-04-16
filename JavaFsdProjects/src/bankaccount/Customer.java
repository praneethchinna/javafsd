package bankaccount;

public abstract class Customer
{
    String name;
    int id;

    Customer (String name, int id) {
        this.name = name;
        this.id = id;
    }
    abstract  void details();
}
