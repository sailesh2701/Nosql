/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nosqplpj;
import Connection.util.Conn;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Sailesh
 */
public class Nosqplpj extends JFrame implements ActionListener{
   
    
    private JPanel panel;
    
    public Nosqplpj(){    
        super("Welcome");    
        setBackground(new Color(169, 169, 169));	
        setBounds(470, 170, 1010, 680);
        
        panel = new JPanel();
	panel.setBackground(new Color(255,255,255));
	setContentPane(panel);
	panel.setLayout(null);
        
        JLabel l1 = new JLabel("Admin Login");
//	l1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                setVisible(false);
//		new Login().setVisible(true);
//            }
//	});
        l1.setForeground(Color.BLACK);
	l1.setFont(new Font("Times New Roman", Font.BOLD, 33));
	l1.setBounds(297, 275, 252, 48);
	panel.add(l1);
        
        JLabel l3 = new JLabel("");
        ImageIcon i4;
        i4 = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/6.png"));
        Image i5 = i4.getImage().getScaledInstance(154, 104,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
		new Login().setVisible(true);
            }
	});
        l3.setBounds(537, 245, 164, 108);
        panel.add(l3);
        
        JLabel l2 = new JLabel("User Login");
        l2.setForeground(Color.BLACK);
	l2.setFont(new Font("Times New Roman", Font.BOLD, 33));
	l2.setBounds(297, 409, 242, 48);
	panel.add(l2);
        
        JLabel l4 = new JLabel("");
        ImageIcon pass;
        pass = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/7.png"));
        Image P = pass.getImage().getScaledInstance(144, 110,Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(P);
        l4 = new JLabel(i7);
        l4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
		new UserLogin().setVisible(true);
            }
	});
        l4.setBounds(537, 399, 164, 118);
        panel.add(l4);
        
        
         JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/wel.jpg"));
        Image im = back.getImage().getScaledInstance(1010, 680,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 1010, 680);
        panel.add(bg);   
    }
    
    
    public static void main(String[] args) {
        
        String s="Nosql";
        MongoDatabase database=new Conn().getConnect(s);
        new Nosqplpj().setVisible(true);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
