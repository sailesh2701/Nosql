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
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
import org.bson.Document;

public class Signup extends JFrame implements ActionListener{

    MongoDatabase database = null;
    MongoCollection<Document> collection = null;
    
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton b1, b2;
    private JComboBox comboBox;


    public static void main(String[] args) {
        new Signup().setVisible(true);
    }

    public Signup() {
        super("Signup");
        setBounds(600, 250, 706, 416);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

        JLabel nam=new JLabel("Sign Up");
        nam.setBounds(310,0,290,95);
        nam.setForeground(Color.BLACK);
        nam.setFont(new Font("Serif",Font.BOLD,28));
        contentPane.add(nam);
        
	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setForeground(Color.BLACK);
	lblUsername.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblUsername.setBounds(99, 86, 92, 26);
	contentPane.add(lblUsername);

	JLabel lblName = new JLabel("Name :");
	lblName.setForeground(Color.BLACK);
	lblName.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	lblName.setBounds(99, 123, 92, 26);
	contentPane.add(lblName);

	JLabel lblPassword = new JLabel("Password :");
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

	b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
	b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
	b2.setBounds(300, 289, 100, 30);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setForeground(new Color(34, 139, 34));
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Create-Account",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
	panel.setBounds(88, 66, 376, 276);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
        JLabel bg = new JLabel("");
        ImageIcon back;
        back = new ImageIcon(ClassLoader.getSystemResource("nosqplpj/icons/sign.jpeg"));
        Image im = back.getImage().getScaledInstance(706, 376,Image.SCALE_DEFAULT);
        ImageIcon bgroung = new ImageIcon(im);
        bg = new JLabel(bgroung);
        bg.setBounds(0, 0, 706, 376);
        contentPane.add(bg);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                
                
                if(textField_1.getText().isEmpty() || textField_2.getText().isEmpty() ||textField_3.getText().isEmpty() || 
                        textField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Valid Details");            
                }
            
                else{
                    boolean b=true;
                    if(b){
                    database = new Conn().getConnect("Nosql");
                    collection = database.getCollection("login");
                    String tf=textField.getText();
                    String tf1=textField_1.getText();
                    String tf2=textField_2.getText();
                    String tfc=(String) comboBox.getSelectedItem();
                    String tf3=textField_3.getText();
                    Document document = new Document().append("Username",tf).
                    append("Name",tf1).append("Password",tf2).append("Squestion",tfc).append("Answer",tf3);
                    collection.insertOne(document);
                    }
                    else{
                        b=false;
                    }
                    if(b){
                        JOptionPane.showMessageDialog(null, "successfully Created");
                    } 
                }
            
            
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Login().setVisible(true);
			
            }
        }catch(Exception e){
            
        }
    }
}

