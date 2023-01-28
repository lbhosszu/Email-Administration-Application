import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private static JFrame frame = new JFrame();
    private static JPanel panel = new JPanel();
    private static JLabel firstName = new JLabel("First Name*");
    private static JTextField fNameText = new JTextField(20);
    private static JLabel lastName = new JLabel("Last Name*");
    private static JTextField lNameText = new JTextField(20);
    private static JLabel compName = new JLabel("Company*");
    private static JTextField compNameText = new JTextField(20);
    private static JLabel depName = new JLabel("Department");
    private static JTextField depNameText = new JTextField(20);
    private static JLabel password = new JLabel("Password*");
    private static JLabel passwordReq = new JLabel("Your password must contain a Capital letter, a number and a special character!");
    private static JPasswordField passwordText = new JPasswordField(20);
    private static JButton create = new JButton("Create Email");
    private static JLabel success = new JLabel("");
    private static JLabel unsuccessful = new JLabel("");
    private static JLabel email = new JLabel("");
    private static JLabel emailPassword = new JLabel("");
    public static void main(String[] args)
    {
        frame.setSize(575,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        firstName.setBounds(50,50,80,25);
        panel.add(firstName);
        fNameText.setBounds(47,70,150,25);
        panel.add(fNameText);

        lastName.setBounds(250,50,80,25);
        panel.add(lastName);
        lNameText.setBounds(247,70,150,25);
        panel.add(lNameText);

        compName.setBounds(50,100,80,25);
        panel.add(compName);
        compNameText.setBounds(47,120,150,25);
        panel.add(compNameText);

        depName.setBounds(250,100,80,25);
        panel.add(depName);
        depNameText.setBounds(247,120,150,25);
        panel.add(depNameText);

        password.setBounds(50,150,80,25);
        panel.add(password);
        passwordReq.setBounds(50,195,500,25);
        panel.add(passwordReq);
        passwordText.setBounds(47,170,150,25);
        panel.add(passwordText);

        create.setBounds(42, 225, 150, 25);
        create.addActionListener(new Main());
        panel.add(create);

        success.setBounds(45,50,500,25);
        panel.add(success);
        email.setBounds(45,70,500,25);
        panel.add(email);
        emailPassword.setBounds(45,90,500,25);
        panel.add(emailPassword);
        unsuccessful.setBounds(45,250,500,25);
        panel.add(unsuccessful);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fName = fNameText.getText();
        String lName = lNameText.getText();
        String company = compNameText.getText();
        String dep = depNameText.getText();
        String pass = passwordText.getText();

        Email em1 = new Email(fName,lName,company,dep);

        boolean valid = em1.validPassword(pass);

        if(!valid)
        {
            unsuccessful.setText("Invalid password. Try again!");
        }
        else if(fName.length() > 0 && lName.length() > 0 && company.length() > 0 )
        {
            firstName.setVisible(false);
            fNameText.setVisible(false);
            lastName.setVisible(false);
            lNameText.setVisible(false);
            compName.setVisible(false);
            compNameText.setVisible(false);
            depName.setVisible(false);
            depNameText.setVisible(false);
            password.setVisible(false);
            passwordReq.setVisible(false);
            passwordText.setVisible(false);
            create.setVisible(false);
            unsuccessful.setVisible(false);

            success.setText("You have successfully created your email!");
            email.setText("Your email is: " + em1.genEmail());
            emailPassword.setText("Your password is: " + pass);
        }
        else
        {
            unsuccessful.setText("Invalid inputs. Try again!");
        }
    }
}