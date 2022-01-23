package project_swing;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ADminUser extends JFrame implements ActionListener{

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    JButton Admin, user;
    Font f1, f2;
    JButton ADMIN, USER;

    
    ADminUser(){
       initComponent();
    }
    
    public void initComponent(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 50, 880, 560);
        this.setTitle("AdminUser");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        
        f1 = new Font("Arial", Font.BOLD+Font.ITALIC, 25);
        f2 = new Font("Time new Roman", Font.BOLD+Font.ITALIC, 16);
        
        icon = new ImageIcon(getClass().getResource("adminUser.png"));
        
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(imageLabel);
        
        ADMIN = new JButton("ADMIN");
        ADMIN.setBounds(258, 430, 100, 40);
        ADMIN.setFont(f2);
        imageLabel.add(ADMIN);
        
        USER = new JButton("USER");
        USER.setBounds(511, 430, 100, 40);
        USER.setFont(f2);
        imageLabel.add(USER);
        
        USER.addActionListener(this);
        ADMIN.addActionListener(this);
        
        setVisible(true);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ADMIN)
        {
            dispose();
            new LoginForm();
        }
        else  if(e.getSource() == USER)
        {
            dispose();
            new LoginForm();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        new ADminUser();
    }

    
}
