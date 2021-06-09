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
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;
import org.bson.Document;

public class UserForgot extends JFrame implements ActionListener{

    MongoDatabase database = null;
    MongoCollection<Document> collection = null;
        
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;

    public static void main(String[] args) {
	new UserForgot().setVisible(true);
    }

    public UserForgot() {
        super("User Forgot Password");
        setBounds(500, 200, 650, 450);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Username");
	l1.setFont(new Font("Tahoma", Font.BOLD, 13));
	l1.setBounds(109, 83, 87, 29);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setFont(new Font("Tahoma", Font.BOLD, 13));
	l2.setBounds(109, 122, 75, 21);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Your Security Question");
	l3.setFont(new Font("Tahoma", Font.BOLD, 13));
	l3.setBounds(109, 154, 156, 27);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Answer");
	l4.setFont(new Font("Tahoma", Font.BOLD, 13));
	l4.setBounds(109, 192, 104, 21);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Password");
	l5.setFont(new Font("Tahoma", Font.BOLD, 13));
	l5.setBounds(109, 224, 104, 21);
	contentPane.add(l5);

	t1 = new JTextField();
	t1.setFont(new Font("Tahoma", Font.BOLD, 13));
	t1.setForeground(new Color(105, 105, 105));
	t1.setBounds(277, 88, 139, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setEditable(false);
	t2.setFont(new Font("Tahoma", Font.BOLD, 13));
	t2.setForeground(new Color(165, 42, 42));
	t2.setColumns(10);
	t2.setBounds(277, 123, 139, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setEditable(false);
	t3.setFont(new Font("Tahoma", Font.BOLD, 12));
	t3.setForeground(new Color(72, 61, 139));
	t3.setColumns(10);
	t3.setBounds(277, 161, 221, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setFont(new Font("Tahoma", Font.BOLD, 13));
	t4.setForeground(new Color(205, 92, 92));
	t4.setColumns(10);
	t4.setBounds(277, 193, 139, 20);
	contentPane.add(t4);

	t5 = new JTextField();
	t5.setEditable(false);
	t5.setFont(new Font("Tahoma", Font.BOLD, 13));
	t5.setForeground(new Color(50, 205, 50));
	t5.setColumns(10);
	t5.setBounds(277, 225, 139, 20);
	contentPane.add(t5);

	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 12));
	b1.setBounds(428, 83, 80, 29);
	b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

	b2 = new JButton("Retrieve");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 12));
	b2.setBounds(426, 188, 85, 29);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 13));
	b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "Forgot-Panel",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
	panel.setBounds(47, 45, 508, 281);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/fp.jpg"));
        Image im = back.getImage().getScaledInstance(830, 520,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 830, 520);
        contentPane.add(bg);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                String un=t1.getText();
                database = new Conn().getConnect("Nosql");
                collection = database.getCollection("userlogin");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                obj.add(new BasicDBObject("Username", un));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin);
                //It will get a particular feild required
                
                String Nam  = collection.find(fin).projection(Projections.include("Name")).first().getString("Name");
                t2.setText(Nam);
                System.out.println(Nam);
                String Sec_Que  = collection.find(fin).projection(Projections.include("Squestion")).first().getString("Squestion");
                t3.setText(Sec_Que);                
                
                for(Document doc : cursor){
                    System.out.println(doc);
                    
                }

            }
            if(ae.getSource() == b2){
                String ans=t4.getText();
                database = new Conn().getConnect("Nosql");
                collection = database.getCollection("userlogin");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                obj.add(new BasicDBObject("Answer", ans));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin);
                
                
                String pass  = collection.find(fin).projection(Projections.include("Password")).first().getString("Password");
                t5.setText(pass);
                System.out.println(pass);
                for(Document doc : cursor){
                    System.out.println(doc);   
                }

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
		new UserLogin().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }

}
