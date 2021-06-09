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

public class Home extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1,b4,b6;

	public static void main(String[] args) {
            new Home().setVisible(true);
	}
        
        public Home() {
	
            setBounds(450, 170, 910, 580);
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

            
            JLabel l1 = new JLabel("Job Availibility");
            l1.setForeground(new Color(0, 0, 0));
            l1.setFont(new Font("TimesNewRoman", Font.BOLD|Font.ITALIC, 30));
            l1.setBounds(350, 30, 701, 80);
            contentPane.add(l1);
            
            JLabel l2 = new JLabel("");
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/3.jpg"));
            Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l2 = new JLabel(i3);
            l2.setBounds(60, 135, 159, 152);
            contentPane.add(l2);
            
             JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/4.png"));
            Image i5 = i4.getImage().getScaledInstance(160, 150,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(350, 155, 180, 110);
            contentPane.add(l3);
            
            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/5.png"));
            Image i8 = i7.getImage().getScaledInstance(120, 120,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(650, 140, 225, 152);
            contentPane.add(l4);

          
            b1 = new JButton("Register company");
            b1.addActionListener(this);
            b1.setBackground(new Color(23, 181, 72));
            b1.setFont(new Font("TimesNewRoman", Font.PLAIN | Font.BOLD, 14));
            b1.setForeground(Color.WHITE);
            b1.setBounds(60, 330, 169, 44);
            contentPane.add(b1);

            b4 = new JButton("View Jobs");
            b4.addActionListener(this);
            b4.setBackground(new Color(23, 181, 72));
            b4.setFont(new Font("TimesNewRoman", Font.PLAIN | Font.BOLD, 14));
            b4.setForeground(Color.WHITE);
            b4.setBounds(360, 330, 169, 44);
            contentPane.add(b4);

            
            b6 = new JButton("Edit Details");
            b6.addActionListener(this);
            b6.setBackground(new Color(23, 181, 72));
            b6.setFont(new Font("TimesNewRoman", Font.PLAIN | Font.BOLD, 14));
            b6.setForeground(Color.WHITE);
            b6.setBounds(660, 330, 169, 44);
            contentPane.add(b6);
            contentPane.setBackground(Color.WHITE);
            
            JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/hom.jpg"));
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
                new Login().setVisible(true);
            }else if(msg.equals("Exit")){
                System.exit(ABORT);
            }
            
            
            
            
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AddCompany().setVisible(true);
            }
            
            
            if(ae.getSource() == b4){
                this.setVisible(false);
                new CompanyDetails().setVisible(true);
            }
            
                      
            if(ae.getSource() == b6){
                this.setVisible(false);
                new edit_form().setVisible(true);
            }
            
            
            
        }
}