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
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import Connection.util.Conn;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import java.awt.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Dashboard extends JFrame implements ActionListener {

    MongoDatabase database = null;
    MongoCollection<Document> collection = null;

    static String sk, loc;
    private JPanel contentPane;
    private JTable table;
    public JTextField search;
    private JButton b1;
    public JComboBox comboBox;

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("Search Details");
        setBounds(50, 20, 1800, 975);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(220, 220, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 1631, 688);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 0).toString());
            }
        });

        table.setBackground(new Color(240, 248, 255));
        table.setForeground(Color.DARK_GRAY);
        table.setFont(new Font("Times New Roman", Font.BOLD, 20));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);

        JLabel l1 = new JLabel("Recommended Companies");
        l1.setForeground(new Color(102, 205, 170));
        l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 38));
        l1.setBounds(700, 17, 470, 47);
        contentPane.add(l1);

//        search = new JTextField();
//        search.setBackground(Color.WHITE);
//        search.setForeground(new Color(47, 79, 79));
//        search.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
//        search.setBounds(659, 79, 710, 45);
//        contentPane.add(search);
//        search.setColumns(10);

//        b1 = new JButton("Search");
//        b1.addActionListener(this);
//        b1.setForeground(new Color(199, 21, 133));
//        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
//        b1.setBounds(1531, 79, 158, 45);
//        contentPane.add(b1);

        JLabel l2 = new JLabel("Back");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                UserHome home = new UserHome();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 33));
        l2.setBounds(97, 79, 92, 38);
        contentPane.add(l2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Search Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
        panel.setBounds(58, 59, 1700, 800);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        //student();

        UserLogin ul = new UserLogin();
        sk = ul.getskills();
        loc = ul.getloc();
        
        update_cred uc=new update_cred();
        String skill=uc.getskills();
        String loca=uc.getloc();
        
        if(skill!=null && loca!=null && skill!=sk && loca!=loc){
            sk=skill;
            loc=loca;
        }
        
        
        
        
        
        MongoClient mongoClient = null;
            DBCursor cursor = null;
            mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("Nosql");
            DBCollection coll = db.getCollection("pj");

            BasicDBObject fin = new BasicDBObject();
            ArrayList<BasicDBObject> obje = new ArrayList<BasicDBObject>();
                obje.add(new BasicDBObject("skills", sk));
                obje.add(new BasicDBObject("joblocation_address", loc));
            
            fin.put("$and", obje);
            cursor = coll.find(fin);

            String columnNames[] = {"company", "education", "experience", "industry", "joblocation_address", "jobtitle",
                 "numberofpositions", "payrate", "skills"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String company = (String) obj.get("company");
                String education = (String) obj.get("education");
                String experience = (String) obj.get("experience");
                String industry = (String) obj.get("industry");
                //String jobdescription = (String)obj.get("jobdescription");
                String joblocation_address = (String) obj.get("joblocation_address");
                String jobtitle = (String) obj.get("jobtitle");
                String numberofpositions = (String) obj.get("numberofpositions");
                String payrate = (String) obj.get("payrate");
                String skills = (String) obj.get("skills");
                //ObjectId id = (ObjectId)obj.get("_id");
                model.addRow(new Object[]{company, education, experience, industry,
                     joblocation_address, jobtitle, numberofpositions, payrate, skills});
            }
            table.setModel(model);
            cursor.close();
            mongoClient.close();
        
        
        

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

//            MongoClient mongoClient = null;
//            DBCursor cursor = null;
//            mongoClient = new MongoClient("localhost", 27017);
//            DB db = mongoClient.getDB("Nosql");
//            DBCollection coll = db.getCollection("pj");
//
//            BasicDBObject fin = new BasicDBObject();
//            ArrayList<BasicDBObject> obje = new ArrayList<BasicDBObject>();
//                obje.add(new BasicDBObject("skills", sk));
//                obje.add(new BasicDBObject("joblocation_address", loc));
//            
//            fin.put("$and", obje);
//            cursor = coll.find(fin);
//
//            String columnNames[] = {"company", "education", "experience", "industry", "joblocation_address", "jobtitle",
//                 "numberofpositions", "payrate", "skills"};
//            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//            while (cursor.hasNext()) {
//                DBObject obj = cursor.next();
//                String company = (String) obj.get("company");
//                String education = (String) obj.get("education");
//                String experience = (String) obj.get("experience");
//                String industry = (String) obj.get("industry");
//                //String jobdescription = (String)obj.get("jobdescription");
//                String joblocation_address = (String) obj.get("joblocation_address");
//                String jobtitle = (String) obj.get("jobtitle");
//                String numberofpositions = (String) obj.get("numberofpositions");
//                String payrate = (String) obj.get("payrate");
//                String skills = (String) obj.get("skills");
//                //ObjectId id = (ObjectId)obj.get("_id");
//                model.addRow(new Object[]{company, education, experience, industry,
//                     joblocation_address, jobtitle, numberofpositions, payrate, skills});
//            }
//            table.setModel(model);
//            cursor.close();
//            mongoClient.close();

            //System.out.println(sk + " " + loc + " " + op);

        }

    }
}
