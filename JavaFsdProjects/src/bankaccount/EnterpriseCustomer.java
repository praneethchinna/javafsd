package bankaccount;

public class EnterpriseCustomer extends Customer
{
    String BusinessType;
    EnterpriseCustomer(String name, int id, String BusinessType)
    {
        super(name, id);
        this.BusinessType=BusinessType;

    }
    void details()
    {
        System.out.println("Name:"+this.name);
        System.out.println("Id:"+this.id);
        System.out.println("BusinessType:"+this.BusinessType);
    }
}
