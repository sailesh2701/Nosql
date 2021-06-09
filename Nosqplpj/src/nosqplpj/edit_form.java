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
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import org.bson.Document;
        
public class edit_form extends JFrame implements ActionListener{
    
    MongoDatabase database = null;
    MongoCollection<Document> collection = null;
    
    
     private JPanel contentPane;
     private JButton b1,b2,b3;
     private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
     private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
     
     public static void main(String[] args) {
        new edit_form().setVisible(true);
    }
     
     public edit_form(){
         super("Edit details");
         setBounds(450, 150, 850, 565);
        contentPane = new JPanel();
	contentPane.setBackground(new Color(220, 220, 220)); 
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        
        JLabel Title = new JLabel("Edit Details");
	Title.setForeground(new Color(0, 0, 0));
	Title.setFont(new Font("Times New Roman", Font.BOLD , 24));
	Title.setBounds(250, 0, 400, 47);
	contentPane.add(Title);
        
        JLabel l1 = new JLabel("Company Name");
	l1.setForeground(new Color(0,0,0));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 51, 110, 22);
	contentPane.add(l1);
        
        JLabel l2 = new JLabel("Education");
	l2.setForeground(new Color(0,0,0));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 84, 110, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Experience");
	l3.setForeground(new Color(0,0,0));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 117, 110, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Industry");
	l4.setForeground(new Color(0,0,0));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 150, 110, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Job Description");
	l5.setForeground(new Color(0,0,0));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 183, 110, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Job Location");
	l6.setForeground(new Color(0,0,0));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(73, 249, 110, 22);
	contentPane.add(l6);

	

	JLabel l7 = new JLabel("Job Title");
	l7.setForeground(new Color(0,0,0));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(393, 51, 110, 22);
	contentPane.add(l7);
	
	JLabel l8 = new JLabel("Openings");
	l8.setForeground(new Color(0,0,0));
	l8.setFont(new Font("Tahoma", Font.BOLD, 14));
	l8.setBounds(73, 282, 110, 22);
	contentPane.add(l8);
	
	JLabel l9 = new JLabel("Pay rate");
	l9.setForeground(new Color(0,0,0));
	l9.setFont(new Font("Tahoma", Font.BOLD, 14));
	l9.setBounds(73, 315, 110, 22);
	contentPane.add(l9);
	
	JLabel l10 = new JLabel("Skills required");
	l10.setForeground(new Color(0,0,0));
	l10.setFont(new Font("Tahoma", Font.BOLD, 14));
	l10.setBounds(73, 348, 110, 22);
	contentPane.add(l10);

	t1 = new JTextField();
	t1.setForeground(new Color(0,0,0));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(185, 54, 198, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(0,0,0));
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
	t5.setBounds(185, 186, 288, 50);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(185, 249, 198, 20);
	contentPane.add(t6);
	
	t7 = new JTextField();
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(460, 54, 198, 20);
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
	
        
        b1 = new JButton("Search");
	b1.addActionListener(this);
        b1.setBackground(new Color(23, 181, 72));
        b1.setForeground(Color.WHITE);
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b1.setBounds(670, 50, 100, 30);
        contentPane.add(b1);
        
      
        b2 = new JButton("Update");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(47, 397, 118, 33);
	b2.setBackground(new Color(23, 181, 72));
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);
   
        b3 = new JButton("Delete");
    	b3.addActionListener(this);
    	b3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
    	b3.setBounds(224, 397, 118, 33);
    	b3.setBackground(new Color(23, 181, 72));
        b3.setForeground(Color.WHITE);
    	contentPane.add(b3);
    
        
        JLabel l23 = new JLabel("Back");
	l23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
	l23.setForeground(Color.BLACK);
	l23.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
	l23.setBounds(377, 387, 118, 63);
	contentPane.add(l23);
        
        
//        JPanel panel1 = new JPanel();
//	panel1.setBorder(new TitledBorder(new LineBorder(new Color(23, 0, 0), 2), "Edit Details", TitledBorder.LEADING,
//			TitledBorder.TOP, null, Color.BLACK));
//	panel1.setBounds(10, 29, 810, 475);
//	contentPane.add(panel1);
//        panel1.setBackground(Color.WHITE);
//        contentPane.setBackground(Color.WHITE);
        
        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/edit.jpg"));
        Image im = back.getImage().getScaledInstance(850, 565,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 850, 565);
        contentPane.add(bg);
     }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getSource() == b1)
            {
               database = new Conn().getConnect("Nosql");
                collection = database.getCollection("pj");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                String com=t1.getText();
                String Title=t7.getText();
                obj.add(new BasicDBObject("company", com));
                obj.add(new BasicDBObject("jobtitle", Title));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin);
                
                String edu  = collection.find(fin).projection(Projections.include("education")).first().getString("education");
                t2.setText(edu);
                String exp  = collection.find(fin).projection(Projections.include("experience")).first().getString("experience");
                t3.setText(exp);
                String indus  = collection.find(fin).projection(Projections.include("industry")).first().getString("industry");
                t4.setText(indus);
                String jobdes  = collection.find(fin).projection(Projections.include("jobdescription")).first().getString("jobdescription");
                t5.setText(jobdes);
                String jobloc  = collection.find(fin).projection(Projections.include("joblocation_address")).first().getString("joblocation_address");
                t6.setText(jobloc);
                String Op  = collection.find(fin).projection(Projections.include("numberofpositions")).first().getString("numberofpositions");
                t8.setText(Op);
                String pay  = collection.find(fin).projection(Projections.include("payrate")).first().getString("payrate");
                t9.setText(pay);
                String skil  = collection.find(fin).projection(Projections.include("skills")).first().getString("skills");
                t10.setText(skil);
                
                System.out.println(edu+" "+exp);
                for(Document doc : cursor){
                    System.out.println(doc);
                    
                }
            }
            if(ae.getSource()==b2)
            {
                
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
                
                collection.updateOne(Filters.eq("company", tf1), new
    Document("$set", new Document(document)));;
                }
                else{
                    b=false;
                }
                if(b){
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                }                
                
            }

            if(ae.getSource() == b3){
                
                boolean b=true;
                if(b){
                database = new Conn().getConnect("Nosql");
                collection = database.getCollection("pj");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                String com=t1.getText();
                String Title=t7.getText();
                obj.add(new BasicDBObject("company", com));
                obj.add(new BasicDBObject("jobtitle", Title));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin);
                
                for(Document dc : cursor){
                    System.out.println(dc);
                    
                }
                collection.deleteOne(Filters.eq("company",com));
                }
                else{
                    b=false;
                }
                if(b){
                    JOptionPane.showMessageDialog(null, "successfully Deleted");
                }
                
                
            }
        }catch(Exception e){}
    }
    
}
