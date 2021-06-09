/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqplpj;

/**
 *
 * @author Sailesh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.ABORT;

public class UserHome extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1,b4,b6;

	public static void main(String[] args) {
            new UserHome().setVisible(true);
	}
        
        public UserHome() {
	
            setBounds(470, 170, 810, 480);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBackground(new Color(23, 181, 72));
            menuBar.setBounds(0, 0, 1200, 35);
            contentPane.add(menuBar);

            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("TimesNewRoman", Font.BOLD |Font.ITALIC, 16));
            
            
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);
            menuBar.add(mnExit);
            
            
            
            
            JMenu mnedit = new JMenu("Edit");
            mnedit.setFont(new Font("TimesNewRoman", Font.BOLD |Font.ITALIC, 16));
            
            JMenuItem mnted = new JMenuItem("Update Creditials");
            mnted.setBackground(new Color(211, 211, 211));
            mnted.setForeground(new Color(105, 105, 105));
            mnted.addActionListener(this);
            mnedit.add(mnted);
            menuBar.add(mnedit);

            
            JLabel l1 = new JLabel("Dash Board");
            l1.setForeground(new Color(0, 0, 0));
            l1.setFont(new Font("TimesNewRoman", Font.BOLD|Font.ITALIC, 30));
            l1.setBounds(280, 30, 701, 80);
            contentPane.add(l1);
            
                     
            b1 = new JButton("View Company Details");
            b1.addActionListener(this);
            b1.setBackground(new Color(23, 181, 72));
            b1.setFont(new Font("TimesNewRoman", Font.PLAIN | Font.BOLD, 20));
            b1.setForeground(Color.WHITE);
            b1.setBounds(60, 330, 300, 60);
            contentPane.add(b1);

            b4 = new JButton("View Jobs");
            b4.addActionListener(this);
            b4.setBackground(new Color(23, 181, 72));
            b4.setFont(new Font("TimesNewRoman", Font.PLAIN | Font.BOLD, 20));
            b4.setForeground(Color.WHITE);
            b4.setBounds(400, 330, 300, 60);
            contentPane.add(b4);
            
            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/8.png"));
            Image i5 = i4.getImage().getScaledInstance(180, 170,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(110, 155, 180, 110);
            contentPane.add(l3);
            
            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/9.png"));
            Image i8 = i7.getImage().getScaledInstance(150, 160,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(400, 140, 225, 152);
            contentPane.add(l4);
            
            JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/uhom.jpeg"));
        Image im = back.getImage().getScaledInstance(900, 580,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 900, 580);
        contentPane.add(bg);

	}
        
        
        public void actionPerformed(ActionEvent ae){
            String msg = ae.getActionCommand();
            
            if(msg.equals("Logout")){
                setVisible(false);
                new UserLogin().setVisible(true);
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            }else if(msg.equals("Update Creditials")){
                setVisible(false);
                new update_cred().setVisible(true);
            
            }
            
            
            
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new Dashboard().setVisible(true);
            }
            
            
            if(ae.getSource() == b4){
                this.setVisible(false);
                new UCompanyDetails().setVisible(true);
            }
            
                      
            
            
            
            
        }
}