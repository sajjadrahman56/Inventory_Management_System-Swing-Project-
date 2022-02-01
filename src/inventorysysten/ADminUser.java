package inventorysysten;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ADminUser extends JFrame implements ActionListener {

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    JButton Admin, user;
    Font f1, f2;
    JButton ADMIN, USER ,Exit;

    ADminUser() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 50, 880, 560);
        this.setTitle("AdminUser");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        f1 = new Font("Arial", Font.BOLD + Font.ITALIC, 25);
        f2 = new Font("Time new Roman", Font.BOLD + Font.ITALIC, 18);

        icon = new ImageIcon(getClass().getResource("adminUser.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(imageLabel);

        ADMIN = new JButton("A D M I N");
        ADMIN.setBounds(253, 430, 130, 40);
        ADMIN.setFont(f2);

        ADMIN.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        ADMIN.setBackground(Color.decode("#55D3AD"));
        ADMIN.setFocusable(false);

        imageLabel.add(ADMIN);

        USER = new JButton("U S E R");
        USER.setBounds(511, 430, 130, 40);
        USER.setFont(f2);

        USER.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        USER.setBackground(Color.decode("#1FCCF8"));
        USER.setFocusable(false);

        imageLabel.add(USER);

        Exit = new JButton("Exit");
        Exit.setBounds(15, 470, 80, 40);
        Exit.setFont(f2);
        Exit.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        Exit.setFocusable(false);
        Exit.setBackground(Color.decode("#F6C5F7"));
        imageLabel.add(Exit);
        
        USER.addActionListener(this);
        ADMIN.addActionListener(this);
        Exit.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ADMIN) {
            dispose();
            new LoginFormAdmin();
        } else if (e.getSource() == USER) {
            dispose();
            new LoginFormUser();
        }else if (e.getSource() == Exit) {
            dispose();
            new  FrontPage();
        }
        
    }

    public static void main(String[] args) {
        new ADminUser();
    }

}
