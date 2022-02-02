package inventorysysten;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame implements ActionListener {

    Container c;
    JLabel  imageLabel, label6, label7, label8, label9;
    JLabel firstName, lastName, userName, email, mobile, password, conPassword;
    JTextField textField1, textField2, textField3, textField4, firstNameTf, lastNameTf, userNameTf, emailTf, mobileTf;
    JPanel panel1, panel2, panel3;
    JPasswordField pf1, pass, conPass;
    JButton btnSignUp, btnSignIn;
    Font f1, f2;
    ImageIcon icon;

    RegistrationForm() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
       // this.setBounds(200, 100, 800, 650);
        this.setSize(800, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("SinUp Form");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.gray);

        f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 25);
        f2 = new Font("Time new Roman", Font.BOLD, 16);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 650);
        c.add(panel1);

        icon = new ImageIcon(getClass().getResource("pic2.jpg"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        panel1.add(imageLabel);

        label6 = new JLabel("Sign Up");
        label6.setBounds(150, 100, 100, 40);
        label6.setForeground(Color.white);
        label6.setFont(f1);
        imageLabel.add(label6);

        label7 = new JLabel("Please enter your detalis to sign up and be");
        label7.setBounds(50, 150, 400, 40);
        label7.setForeground(Color.white);
        label7.setFont(f2);
        imageLabel.add(label7);

        label8 = new JLabel("part of our great community.");
        label8.setBounds(100, 170, 300, 40);
        label8.setForeground(Color.white);
        label8.setFont(f2);
        imageLabel.add(label8);

        label9 = new JLabel("Already have an account?");
        label9.setBounds(105, 230, 200, 40);
        label9.setForeground(Color.gray);
        label9.setFont(f2);
        imageLabel.add(label9);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(400, 0, 400, 650);
        panel2.setBackground(Color.white);
        c.add(panel2);

        firstName = new JLabel("FIRST NAME");
        firstName.setBounds(40, 50, 100, 20);
        firstName.setFont(f2);
        firstName.setForeground(Color.gray);
        panel2.add(firstName);

        firstNameTf = new JTextField();
        firstNameTf.setBounds(40, 80, 130, 40);
        firstNameTf.setFont(f2);
        panel2.add(firstNameTf);

        lastName = new JLabel("LAST NAME");
        lastName.setBounds(200, 50, 150, 20);
        lastName.setFont(f2);
        lastName.setForeground(Color.gray);
        panel2.add(lastName);

        lastNameTf = new JTextField();
        lastNameTf.setBounds(200, 80, 150, 40);
        lastNameTf.setFont(f2);
        panel2.add(lastNameTf);

        userName = new JLabel("USERNAME");
        userName.setBounds(40, 140, 150, 20);
        userName.setFont(f2);
        userName.setForeground(Color.gray);
        panel2.add(userName);

        userNameTf = new JTextField();
        userNameTf.setBounds(40, 170, 310, 40);
        userNameTf.setFont(f2);
        panel2.add(userNameTf);

        email = new JLabel("EMAIL ADDRESS");
        email.setBounds(40, 230, 200, 20);
        email.setFont(f2);
        email.setForeground(Color.gray);
        panel2.add(email);

        emailTf = new JTextField();
        emailTf.setBounds(40, 260, 310, 40);
        emailTf.setFont(f2);
        panel2.add(emailTf);

        password = new JLabel("PASSWORD");
        password.setBounds(40, 320, 200, 20);
        password.setFont(f2);
        password.setForeground(Color.gray);
        panel2.add(password);

        pass = new JPasswordField();
        pass.setEchoChar('*');
        pass.setBounds(40, 350, 310, 40);
        pass.setFont(f1);
        pass.setHorizontalAlignment(JPasswordField.CENTER);
        panel2.add(pass);

        conPassword = new JLabel("CONFIRM PASSWORD");
        conPassword.setBounds(40, 410, 200, 20);
        conPassword.setFont(f2);
        conPassword.setForeground(Color.gray);
        panel2.add(conPassword);

        conPass = new JPasswordField();
        conPass.setEchoChar('*');
        conPass.setBounds(40, 440, 310, 40);
        conPass.setFont(f1);
        conPass.setHorizontalAlignment(JPasswordField.CENTER);
        panel2.add(conPass);

        btnSignUp = new JButton("SIGN UP");
        btnSignUp.setBounds(40, 500, 310, 40);
        btnSignUp.setFont(f2);
        btnSignUp.setBackground(Color.green);
        panel2.add(btnSignUp);

        btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(150, 300, 100, 40);
        btnSignIn.setFont(f2);
        btnSignIn.setBackground(Color.lightGray);
         btnSignIn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
       btnSignIn.setFocusable(false);
      // btnSignIn.setBackground(Color.decode("#34C3E7"));
        
        panel1.add(btnSignIn);

        btnSignIn.addActionListener(this);
        btnSignUp.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn) {
            dispose();
            new ADminUser();
        } else if (e.getSource() == btnSignUp) {

            String FirstName = firstNameTf.getText();
            String LastName = lastNameTf.getText();
            String UserName = userNameTf.getText();
            String email = emailTf.getText();

       
            String password = new String(pass.getPassword());
            
            //  String confirmPasswod = conPass.getText();
            String confirmPasswod = new String(conPass.getPassword());

            String FirstNameRegex = "^[a-zA-Z ]+$";
            String LastNameRegex = "^[a-zA-Z ]+$";
            String userNameRegex = "^[a-zA-Z0-9 ]+$";
          
            String emailRegex = "^[a-z0-9]+@[a-z]+.((com)|(yahoo)|(net))+$";
            String passRegex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&*()]).{6,20}";

            if (!Pattern.matches(FirstNameRegex, FirstName)) {
                JOptionPane.showMessageDialog(null, " First Name Only char is allowed!!");
            } else if (!Pattern.matches(LastNameRegex, LastName)) {
                JOptionPane.showMessageDialog(null, " Last Name Only char is allowed!!");
            } else if (!Pattern.matches(userNameRegex, UserName)) {
                JOptionPane.showMessageDialog(null, " User Name Only char is allowed!!");
            } else if (!Pattern.matches(emailRegex, email)) {
                JOptionPane.showMessageDialog(null, "In-valid Email!!");
            } else if (!Pattern.matches(passRegex, password)) {
                JOptionPane.showMessageDialog(null, "1 digit, 1 lower, 1 upper, 1 special char and length 6-20");
            } else if (!confirmPasswod.equals(password)) {
                JOptionPane.showMessageDialog(null, "Password and confirm password is not matching!!");
            } else {

                String insertQuery = "INSERT INTO `userinformation`(`firstName`, `lastName`, `userName`, `email`, `password`)"
                        + " VALUES ('" + FirstName + "','" + LastName + "','" + UserName + "','" + email + "', '" + password + "')";

                DatabaseConnect db = new DatabaseConnect();
                
                if (db.InsertRegister(insertQuery) == true) {
                    firstNameTf.setText("");
                    lastNameTf.setText("");
                    userNameTf.setText("");
                    emailTf.setText("");
                    pass.setText("");
                    conPass.setText("");
                    
                    dispose();
                    new ADminUser();
                };

            }
        }

    }

    public static void main(String[] args) {
        new RegistrationForm();
    }

}
