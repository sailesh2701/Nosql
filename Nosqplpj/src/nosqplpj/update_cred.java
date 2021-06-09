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
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;
import org.bson.Document;

public class update_cred extends JFrame implements ActionListener{

    MongoDatabase database = null;
    MongoCollection<Document> collection = null;
    
    public JPanel contentPane;
    public JTextField textField;
    public JTextField textField_1;
    public JTextField textField_2;
    public JTextField textField_3,tf4,tf5,tf6,tf7,tfc;
    public JButton b1, b2, b3;
    public JComboBox comboBox;
    static String loc,sk;


    public static void main(String[] args) {
        new update_cred().setVisible(true);
    }
    
    public String getskills(){
            return sk;
        }
        public String getloc(){
            return loc;
        }

    public update_cred() {
        super("Update Details");
        setBounds(500, 150, 1206, 616);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);
        
        JLabel nam=new JLabel("UPDATE");
        nam.setBounds(240,0,290,95);
        nam.setForeground(Color.BLACK);
        nam.setFont(new Font("Serif",Font.BOLD,28));
        contentPane.add(nam);

	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.BLACK);
	lblUsername.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Password :");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Name :");
	lblPassword.setForeground(Color.BLACK);
	lblPassword.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblPassword.setBounds(99, 160, 92, 26);
	contentPane.add(lblPassword);

	JLabel lblAnswer = new JLabel("Answer :");
	lblAnswer.setForeground(Color.BLACK);
	lblAnswer.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblAnswer.setBounds(99, 234, 92, 26);
	contentPane.add(lblAnswer);

        comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
			"Your child SuperHero?", "Your childhood Name ?" }));
	comboBox.setBounds(265, 202, 148, 20);
	contentPane.add(comboBox);

	JLabel lblSecurityQuestion = new JLabel("Security Question :");
	lblSecurityQuestion.setForeground(Color.BLACK);
	lblSecurityQuestion.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblSecurityQuestion.setBounds(99, 197, 140, 26);
	contentPane.add(lblSecurityQuestion);

        textField = new JTextField();
	textField.setBounds(265, 91, 148, 20);
	contentPane.add(textField);
	textField.setColumns(10);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(265, 128, 148, 20);
	contentPane.add(textField_1);

        textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(265, 165, 148, 20);
	contentPane.add(textField_2);

	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(265, 239, 148, 20);
	contentPane.add(textField_3);
        
        
        JLabel College=new JLabel("College Name");
        College.setBounds(99,240,290,95);
        College.setForeground(Color.BLACK);
        College.setFont(new Font("TimesNewRoman",Font.BOLD,14));
        contentPane.add(College);
        
        tf7 = new JTextField();
	tf7.setColumns(10);
	tf7.setBounds(635, 165, 148, 20);
	contentPane.add(tf7);

	JLabel Cgpa = new JLabel("CGPA");
	Cgpa.setForeground(Color.BLACK);
	Cgpa.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	Cgpa.setBounds(499, 86, 92, 26);
	contentPane.add(Cgpa);

	JLabel loc = new JLabel("Location to work");
	loc.setForeground(Color.BLACK);
	loc.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	loc.setBounds(499, 123, 132, 26);
	contentPane.add(loc);

	JLabel sk = new JLabel("Skills");
	sk.setForeground(Color.BLACK);
	sk.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	sk.setBounds(499, 160, 92, 26);
	contentPane.add(sk);
        
        tf4= new JTextField();
	tf4.setBounds(265, 280, 148, 20);
	contentPane.add(tf4);
	tf4.setColumns(10);

	tf5 = new JTextField();
	tf5.setColumns(10);
	tf5.setBounds(635, 91, 148, 20);
	contentPane.add(tf5);

        tf6 = new JTextField();
	tf6.setColumns(10);
	tf6.setBounds(635, 128, 148, 20);
	contentPane.add(tf6);

	b1 = new JButton("Update");
	b1.addActionListener(this);
	b1.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
	b1.setBounds(140, 369, 130, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
	b2.setBounds(330, 369, 130, 40);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
        
        b3 = new JButton("Retrieve");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 16));
	b3.setBounds(550, 369, 130, 40);
	b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);
        
        JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(88, 66, 776, 376);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);


        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/sign.jpeg"));
        Image im = back.getImage().getScaledInstance(1200, 616,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 1206, 616);
        contentPane.add(bg);
        
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                if(textField_1.getText().isEmpty() || textField_2.getText().isEmpty() ||textField_3.getText().isEmpty() || 
                            textField.getText().isEmpty()|| tf4.getText().isEmpty()|| tf5.getText().isEmpty()
                        || tf6.getText().isEmpty()|| tf7.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Enter Valid Details");            
                    }

                    else{
                        boolean b=true;
                if(b){
                        database = new Conn().getConnect("Nosql");
                        collection = database.getCollection("userlogin");
                        BasicDBObject fin= new BasicDBObject();
                       ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                        String tf1=textField.getText();
                        String tf2=textField_1.getText();
                        String tf3=textField_2.getText();
                        String tf_4=(String) comboBox.getSelectedItem();
                        String tf_5=textField_3.getText();
                        String tf_6=tf4.getText();
                        String tf_7=tf5.getText();
                        String tf_8=tf6.getText();
                        String tf_9=tf7.getText();
                        Document document = new Document().append("Username",tf1).
                        append("Password",tf2).append("Name",tf3).append("Squestion",tf_4).append("Answer",tf_5)
                        .append("college",tf_6).append("CGPA",tf_7).append("location",tf_8)
                        .append("skills",tf_9);                

                        collection.updateOne(Filters.eq("Username", tf1), new Document("$set", new Document(document)));;
                        
                        obj.add(new BasicDBObject("Username", tf1));
                        obj.add(new BasicDBObject("Password", tf2));
                        fin.put("$and", obj);
                        sk=collection.find(fin).projection(Projections.include("skills")).first().getString("skills");
                        loc=collection.find(fin).projection(Projections.include("location")).first().getString("location");
                        }
                        else{
                            b=false;
                        }
                        if(b){
                            JOptionPane.showMessageDialog(null, "Updated Successfully");
                        }
                        
                    }
                
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new UserHome().setVisible(true);
			
            }
            
            
            if(ae.getSource() == b3){
                String un=textField.getText();
                String pa=textField_1.getText();
                database = new Conn().getConnect("Nosql");
                collection = database.getCollection("userlogin");
                BasicDBObject fin= new BasicDBObject();
                ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                obj.add(new BasicDBObject("Username", un));
                obj.add(new BasicDBObject("Password", pa));
                fin.put("$and", obj);
                FindIterable<Document> cursor = collection.find(fin);
                //It will get a particular feild required
                
                String Nam  = collection.find(fin).projection(Projections.include("Name")).first().getString("Name");
                textField_2.setText(Nam);
                System.out.println(Nam);
                String Sec_Que  = collection.find(fin).projection(Projections.include("Squestion")).first().getString("Squestion");
                comboBox.setSelectedItem(Sec_Que);
                
                String ans  = collection.find(fin).projection(Projections.include("Answer")).first().getString("Answer");
                textField_3.setText(ans);
                String colna  = collection.find(fin).projection(Projections.include("college")).first().getString("college");
                tf4.setText(colna);
                String cgpa  = collection.find(fin).projection(Projections.include("CGPA")).first().getString("CGPA");
                tf5.setText(cgpa);
                String loca  = collection.find(fin).projection(Projections.include("location")).first().getString("location");
                tf6.setText(loca);
                String skil  = collection.find(fin).projection(Projections.include("skills")).first().getString("skills");
                tf7.setText(skil);
                
                
                
                
                for(Document doc : cursor){
                    System.out.println(doc);
                    
                }
                
            }
        }catch(Exception e){
            
        }
    }
}

