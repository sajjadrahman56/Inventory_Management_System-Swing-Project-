package inventorysysten;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormAdmin extends JFrame {

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    JTextField textField1 , userField, passwordField;
    JPasswordField pf1 , pass;
    JButton btnSignUp, btnSignIn;
    Font f1, f2;

    LoginFormAdmin() {
        initComponent();
    }

    public void initComponent() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setBounds(200, 100, 735, 483);
       this.setSize(735, 483);;
        this.setLocationRelativeTo(null);
        this.setTitle("Admin SinIn Form");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        f1 = new Font("Time new Roman", Font.BOLD, 16);
        f2 = new Font("Arial", Font.BOLD+Font.ITALIC, 25);
        
        icon = new ImageIcon(getClass().getResource("login.png"));
        
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(imageLabel);
               
 
        userField  = new JTextField();
        userField.setBounds(420, 220,200,40);
        userField.setFont(f1);
     //   c.add(textField1);
        imageLabel.add(userField);
               
        
        
         pass  = new JPasswordField();
        pass.setEchoChar('*');
       pass.setBounds(420, 290,200,40);
        pass.setHorizontalAlignment(JPasswordField.RIGHT);
       pass.setFont(f2);
       // c.add(pf1);
        imageLabel.add(pass);
        
        
        
        
        
        btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(390, 360, 300, 55);
        btnSignIn.setFont(f1);
        btnSignIn.setBackground(Color.white);
        imageLabel.add(btnSignIn);
              
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String  userName = userField.getText();
               // String  password =  pass.getText();  new String(pass.getPassword());
                String  password =     new String(pass.getPassword());
                
                 DatabaseConnect db = new DatabaseConnect();
                
               String queryLogin = "SELECT * FROM `admininformation` ";
               // db.LoginDataForAdmin(queryLogin,userName,password);
                
                if(db.LoginDataForAdmin(queryLogin,userName,password) == true )
                {
                    dispose();
                    new AdminTableForm();
                    
                }
                        
            }
        });
        
        setVisible(true);
    }

    public static void main(String[] args) {
            new LoginFormAdmin();
    }
}
