package project_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame implements ActionListener {

    Container c;
    JLabel label1, label2, label3, label4, label5, imageLabel, label6, label7, label8, label9;
    JTextField textField1, textField2, textField3, textField4;
    JPanel panel1, panel2, panel3;
    JPasswordField pf1;
    JButton btnSignUp, btnSignIn;
    Font f1, f2;
    ImageIcon icon;

    RegistrationForm() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 800, 550);
        this.setTitle("SinUp Form");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.gray);

        f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 25);
        f2 = new Font("Time new Roman", Font.BOLD, 16);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 400, 550);
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
        panel2.setBounds(400, 0, 400, 550);
        panel2.setBackground(Color.white);
        c.add(panel2);

        label1 = new JLabel("FIRST NAME");
        label1.setBounds(40, 50, 100, 20);
        label1.setFont(f2);
        label1.setForeground(Color.gray);
        panel2.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(40, 80, 130, 40);
        textField1.setFont(f2);
        panel2.add(textField1);

        label2 = new JLabel("LAST NAME");
        label2.setBounds(200, 50, 150, 20);
        label2.setFont(f2);
        label2.setForeground(Color.gray);
        panel2.add(label2);

        textField2 = new JTextField();
        textField2.setBounds(200, 80, 150, 40);
        textField2.setFont(f2);
        panel2.add(textField2);

        label3 = new JLabel("USERNAME");
        label3.setBounds(40, 140, 150, 20);
        label3.setFont(f2);
        label3.setForeground(Color.gray);
        panel2.add(label3);

        textField3 = new JTextField();
        textField3.setBounds(40, 170, 310, 40);
        textField3.setFont(f2);
        panel2.add(textField3);

        label4 = new JLabel("EMAIL ADDRESS");
        label4.setBounds(40, 230, 200, 20);
        label4.setFont(f2);
        label4.setForeground(Color.gray);
        panel2.add(label4);

        textField4 = new JTextField();
        textField4.setBounds(40, 260, 310, 40);
        textField4.setFont(f2);
        panel2.add(textField4);

        label5 = new JLabel("PASSWORD");
        label5.setBounds(40, 320, 200, 20);
        label5.setFont(f2);
        label5.setForeground(Color.gray);
        panel2.add(label5);

        pf1 = new JPasswordField();
        pf1.setEchoChar('*');
        pf1.setBounds(40, 350, 310, 40);
        pf1.setFont(f1);
        pf1.setHorizontalAlignment(JPasswordField.CENTER);
        panel2.add(pf1);

        btnSignUp = new JButton("SIGN UP");
        btnSignUp.setBounds(40, 415, 310, 40);
        btnSignUp.setFont(f2);
        btnSignUp.setBackground(Color.green);
        panel2.add(btnSignUp);

        btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(150, 300, 100, 40);
        btnSignIn.setFont(f2);
        btnSignIn.setBackground(Color.lightGray);
        panel1.add(btnSignIn);
        
       
        btnSignIn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSignIn)
        {
            dispose();
             new ADminUser();
        }

    }

    public static void main(String[] args) {
        new RegistrationForm();
    }

}
