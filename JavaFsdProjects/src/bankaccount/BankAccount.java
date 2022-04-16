package bankaccount;

public class BankAccount
{
    public static void main(String[] args) {
        EnterpriseCustomer e=new EnterpriseCustomer("Praneeth",12,"small Scale");
        EnterpriseCustomer e1=new EnterpriseCustomer("nikhil",42,"Large Scale");

        e.details();
        e1.details();


    }
}
