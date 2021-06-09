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
import Connection.util.Conn;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.bson.Document;

public class UserLogin extends JFrame implements ActionListener{

        MongoDatabase database = null;
        MongoCollection<Document> collection = null;
        
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;
        static String skil,loc;


	public UserLogin() {
        super("User Login");
	setBackground(new Color(169, 169, 169));	
        setBounds(500, 200, 930, 570);
		
        panel = new JPanel();
	panel.setBackground(new Color(255, 255, 255));
	setContentPane(panel);
	panel.setLayout(null);
        
        JLabel nam=new JLabel("User Login Page");
        nam.setBounds(330,20,290,95);
        nam.setForeground(Color.BLACK);
        nam.setFont(new Font("Serif",Font.BOLD,34));
        panel.add(nam);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(290, 119, 125, 50);
        l1.setBackground(Color.BLACK);
        l1.setFont(new Font("Times New Roman",Font.BOLD,23));
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(290, 159, 125, 50);
        l2.setBackground(Color.BLACK);
        l2.setFont(new Font("Times New Roman",Font.BOLD,23));
	panel.add(l2);

        Font font1 = new Font("SansSerif", Font.BOLD, 14);
        
	textField = new JTextField();
	textField.setBounds(430, 129, 187, 28);
        textField.setFont(font1);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(430, 173, 187, 28);        
        passwordField.setFont(font1);
	panel.add(passwordField);

        
	JLabel l3 = new JLabel("");
        ImageIcon i4;
        i4 = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(34, 32,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(240, 125, 38, 32);
        panel.add(l3);

	JLabel l4 = new JLabel("");
        ImageIcon pass;
        pass = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/2.png"));
        Image P = pass.getImage().getScaledInstance(34, 32,Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(P);
        l4 = new JLabel(i7);
        l4.setBounds(240, 174, 34, 28);
        panel.add(l4);

	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(255,255,255));
	b1.setBackground(new Color(0,0,0));
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	b1.setBounds(299, 221, 118, 42);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(new Color(255,255,255));
	b2.setBackground(new Color(0,0,0));
        b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
	b2.setBounds(469, 221, 118, 42);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(255,255,255));
	b3.setBackground(new Color(0,0,0));
        b3.setFont(new Font("Times New Roman", Font.BOLD, 20));
	b3.setBounds(359, 271, 189, 45);
	panel.add(b3);      
        
        JLabel l23 = new JLabel("Back");
	l23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Nosqplpj().setVisible(true);
			}
		});
	l23.setForeground(Color.BLACK);
	l23.setFont(new Font("Times New Roman", Font.BOLD, 28));
	l23.setBounds(20, 10, 78, 69);
	panel.add(l23);
        
        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/bg1.jpg"));
        Image im = back.getImage().getScaledInstance(930, 570,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 930, 570);
        panel.add(bg);

	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                boolean b=false;
                int c=0;
                String un=textField.getText();
                String p=passwordField.getText();
                database = new Conn().getConnect("Nosql");
                collection = database.getCollection("userlogin");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                obj.add(new BasicDBObject("Username", un));
                obj.add(new BasicDBObject("Password", p));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin); 
                for(Document doc : cursor){
                    System.out.println(doc);
                    c++;  
                }
                
//                String usn=textField.getText();
//                database = new Conn().getConnect("Nosql");
//                collection = database.getCollection("userlogin");
//                BasicDBObject f_in= new BasicDBObject();
//                ArrayList<BasicDBObject> obje = new ArrayList<BasicDBObject>();
//                obje.add(new BasicDBObject("Username", usn));
//                f_in.put("$and", obje);
//                
//
                skil  = collection.find(fin).projection(Projections.include("skills")).first().getString("skills");
                System.out.println(skil);    
                loc  = collection.find(fin).projection(Projections.include("location")).first().getString("location");                    
                    
                    
                if(c>0){
                    //JOptionPane.showMessageDialog(null, "Valid Credentials");
                    new UserHome().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "InValid Credentials");
                }
            }
            if(ae.getSource() == b2){
                setVisible(false);
		UserSignup su = new UserSignup();
		su.setVisible(true);
           }   
            if(ae.getSource() == b3){
                setVisible(false);
		UserForgot forgot = new UserForgot();
		forgot.setVisible(true);
          }
        }
        
  	public static void main(String[] args) {
            skil="";
            loc="";
                new UserLogin().setVisible(true);
	}
        public String getskills(){
            return skil;
        }
        public String getloc(){
            return loc;
        }

}
