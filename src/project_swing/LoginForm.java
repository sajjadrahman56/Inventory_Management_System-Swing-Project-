package project_swing;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    JTextField textField1 , userField, passwordField;
    JPasswordField pf1;
    JButton btnSignUp, btnSignIn;
    Font f1, f2;

    LoginForm() {
        initComponent();
    }

    public void initComponent() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 735, 483);
       // this.setBounds(200, 100, 800, 550);
        this.setTitle("SinIn Form");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        f1 = new Font("Time new Roman", Font.BOLD, 16);
        f2 = new Font("Arial", Font.BOLD+Font.ITALIC, 25);
        
        icon = new ImageIcon(getClass().getResource("login.png"));
        
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(imageLabel);
               
//        textField1  = new JTextField();
//        textField1.setBounds(420, 220,200,40);
//        textField1.setFont(f1);
//        c.add(textField1);      
//  imageLabel.add(textField1);
        userField  = new JTextField();
        userField.setBounds(420, 220,200,40);
        userField.setFont(f1);
     //   c.add(textField1);
        imageLabel.add(userField);
               
        
        
        pf1  = new JPasswordField();
        pf1.setEchoChar('*');
        pf1.setBounds(420, 290,200,40);
        pf1.setHorizontalAlignment(JPasswordField.RIGHT);
        pf1.setFont(f2);
       // c.add(pf1);
        imageLabel.add(pf1);
        
        
        
        
        
        btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(390, 360, 300, 55);
        btnSignIn.setFont(f1);
        btnSignIn.setBackground(Color.white);
        imageLabel.add(btnSignIn);
                
        setVisible(true);
    }

    public static void main(String[] args) {
            new LoginForm();
    }
}
