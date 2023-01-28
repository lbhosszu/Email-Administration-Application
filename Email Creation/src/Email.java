
import java.util.Scanner;

public class Email
{
    private String firstname;
    private String lastname;
    private String department;

    private String company;

    Scanner scan = new Scanner(System.in);
    public Email(String firstname, String lastname,String company, String department)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.department = department;
    }

    public String genEmail()
    {
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase() + ".com";
    }
    public boolean validPassword(String newPassword) {
        if (newPassword.length() < 9) {
            return false;
        }

        boolean UpperChar = false;
        boolean num = false;
        boolean specialChar = false;

        for (int i = 0; i < newPassword.length(); i++)
        {
            if(Character.toString(newPassword.charAt(i) ).matches("[A-Z]"))
            {
                UpperChar = true;
            }
            if(Character.toString(newPassword.charAt(i) ).matches("[0123456789]"))
            {
                num = true;
            }
            if(Character.toString(newPassword.charAt(i) ).matches("[!@£$%^&*_-]"))
            {
                specialChar = true;
            }
        }

        if(UpperChar && num && specialChar)
        {
            return true;
        }

        return false;
    }
}

