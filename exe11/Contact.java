public class Contact
{
    public Long primaryPhoneNumber;
    public Long secondaryPhoneNumber;

    public Contact(Long num1)
    {
        primaryPhoneNumber = num1;
        secondaryPhoneNumber = null;
    }

    public Contact(Long num1, Long num2)
    {
        primaryPhoneNumber = num1;
        secondaryPhoneNumber = num2;
    }
}
