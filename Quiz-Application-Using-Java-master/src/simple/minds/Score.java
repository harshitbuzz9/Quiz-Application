package simple.minds;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class Score extends JFrame implements ActionListener{
    String val="";
    String val2="";
     
    Score(String username, int score){
         
        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("simple/minds/icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 200, 300, 250);
        add(l1);
        
        JLabel l2 = new JLabel("Thankyou " + username + " for Playing Simple Minds");
        l2.setBounds(45, 30, 700, 30);
        l2.setFont(new Font("RALEWAY", Font.PLAIN, 26));
        add(l2);
        
        JLabel l3 = new JLabel("Your Score is " + score);
        l3.setBounds(350, 200, 300, 30);
        l3.setFont(new Font("Jokerman", Font.PLAIN, 26));
        l3.setForeground(new Color(199, 21, 133));
        add(l3);
        
        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        
        b1.setBounds(400, 270, 120, 30);
        add(b1);
        val=username;
        val2=""+score;
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Db1?useSSL=false","root","412000");
        Statement stm=conn.createStatement();
        String query="insert into recorddb values('"+val+"','"+val2+"')";
        int a=stm.executeUpdate(query);
       // PreparedStatement pst=conn.prepareStatement("insert into records(val,val2) values(?,?)");
       // pst.setString(1,val);
       // pst.setDouble(2, val2);
       // pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "data added"+a);
        conn.close();
        }catch(Exception e){
            
            System.out.println(e);
        }
          this.setVisible(false);
        new SimpleMinds().setVisible(true);
         
       
    }
    
    public static void main(String[] args){
        new Score("", 0).setVisible(true);
    }
}
