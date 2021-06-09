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
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import org.bson.Document;

public class AddCompany extends JFrame implements ActionListener{
    
    MongoDatabase database = null;
    MongoCollection<Document> collection = null;

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private JButton b1,b2;
    JComboBox comboBox;
        
    public static void main(String[] args) {
	new AddCompany().setVisible(true);
    }
    public AddCompany() {
        super("Registration Form");
        setBounds(600, 200, 500, 550);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Company Name");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 51, 110, 22);
	contentPane.add(l1);
        
        JLabel l2 = new JLabel("Education");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 84, 110, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Experience");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 117, 110, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Industry");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 150, 110, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Job Description");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 183, 110, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Job Location");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(73, 216, 110, 22);
	contentPane.add(l6);

	

	JLabel l7 = new JLabel("Job Title");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(73, 249, 110, 22);
	contentPane.add(l7);
	
	JLabel l8 = new JLabel("Openings");
	l8.setForeground(new Color(47, 79, 79));
	l8.setFont(new Font("Tahoma", Font.BOLD, 14));
	l8.setBounds(73, 282, 110, 22);
	contentPane.add(l8);
	
	JLabel l9 = new JLabel("Pay rate");
	l9.setForeground(new Color(47, 79, 79));
	l9.setFont(new Font("Tahoma", Font.BOLD, 14));
	l9.setBounds(73, 315, 110, 22);
	contentPane.add(l9);
	
	JLabel l10 = new JLabel("Skills required");
	l10.setForeground(new Color(47, 79, 79));
	l10.setFont(new Font("Tahoma", Font.BOLD, 14));
	l10.setBounds(73, 348, 110, 22);
	contentPane.add(l10);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(185, 54, 198, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(185, 87, 198, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(185, 120, 198, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(185, 153, 198, 20);
	contentPane.add(t4);

        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(185, 186, 198, 20);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(185, 219, 198, 20);
	contentPane.add(t6);
	
	t7 = new JTextField();
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(185, 252, 198, 20);
	contentPane.add(t7);
	
	t8 = new JTextField();
	t8.setForeground(new Color(47, 79, 79));
	t8.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t8.setColumns(10);
	t8.setBounds(185, 285, 198, 20);
	contentPane.add(t8);
	
	t9 = new JTextField();
	t9.setForeground(new Color(47, 79, 79));
	t9.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t9.setColumns(10);
	t9.setBounds(185, 318, 198, 20);
	contentPane.add(t9);
	
	t10 = new JTextField();
	t10.setForeground(new Color(47, 79, 79));
	t10.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t10.setColumns(10);
	t10.setBounds(185, 351, 198, 20);
	contentPane.add(t10);	

        b1 = new JButton("Add");
	b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(102, 441, 120, 38);
        b1.setBackground(new Color(23, 181, 72));
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b2.setBounds(252, 441, 128, 38);
        b2.setBackground(new Color(23, 181, 72));
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Add Details", TitledBorder.LEADING,
			TitledBorder.TOP, null, Color.BLACK));
	panel.setBounds(45, 29, 380, 380);
	contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        
        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/add.jpg"));
        Image im = back.getImage().getScaledInstance(900, 580,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 900, 580);
        contentPane.add(bg);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            
            if(t1.getText().isEmpty() || t2.getText().isEmpty() ||t3.getText().isEmpty() ||t4.getText().isEmpty()||t5.getText().isEmpty()
                    ||t6.getText().isEmpty()||t7.getText().isEmpty()||t8.getText().isEmpty()||t9.getText().isEmpty()||t10.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Valid Details");
            }
            
            
            else{
                boolean b=true;
                    if(b){
                    database = new Conn().getConnect("Nosql");
                    collection = database.getCollection("pj");
                    BasicDBObject fin= new BasicDBObject();
                    ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                    String tf1=t1.getText();
                    String tf2=t2.getText();
                    String tf3=t3.getText();
                    String tf4=t4.getText();
                    String tf5=t5.getText();
                    String tf6=t6.getText();
                    String tf7=t7.getText();
                    String tf8=t8.getText();
                    String tf9=t9.getText();
                    String tf10=t10.getText();
                    Document document = new Document().append("company",tf1).
                    append("education",tf2).append("experience",tf3).append("industry",tf4).append("jobdescription",tf5)
                    .append("joblocation_address",tf6).append("jobtitle",tf7).append("numberofpositions",tf8)
                    .append("payrate",tf9).append("skills",tf10);                
                    collection.insertOne(document);
                    }
                    else{
                        b=false;
                    }
                    if(b){
                        JOptionPane.showMessageDialog(null, "successfully inserted");
                    }
            }
            
        }

        if(ae.getSource() == b2){        
            this.setVisible(false);	
            new Home().setVisible(true);    
        }
    }
}
