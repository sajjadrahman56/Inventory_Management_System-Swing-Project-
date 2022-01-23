
package project_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.AncestorListener;

public class FrontPage extends JFrame implements ActionListener{
    
    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    JButton Exit, Start;
    Font f1, f2;
    
    FrontPage(){
       initComponent(); 
    }
    
    public void initComponent(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 50, 965, 586);
        this.setTitle("Front Page");
        this.setResizable(false);
        
        c = this.getContentPane();
        c.setLayout(null);
        
        
        f1 = new Font("Arial", Font.BOLD+Font.ITALIC, 25);
        f2 = new Font("Time new Roman", Font.BOLD, 18);
        
        icon = new ImageIcon(getClass().getResource("Frontpage.png"));
        
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        c.add(imageLabel);
        
        
        Exit = new JButton("Exit");
        Exit.setBounds(15, 505, 80, 40);
        Exit.setFont(f2);
        imageLabel.add(Exit);
        
        Start = new JButton("Start");
        Start.setBounds(865, 505, 80, 40);
        Start.setFont(f2);
        imageLabel.add(Start);
        
        
        //Start.addAncestorListener((AncestorListener) this);
        //start to go registration from 
        Start.addActionListener(this);
        
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == Start)
        {
            dispose();
            new RegistrationForm();
        }
    }
    
    public static void main(String[] args) {
        new FrontPage();
    }
}
