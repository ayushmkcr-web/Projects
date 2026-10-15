import javax.swing.text.*;
import javax.swing.event.CaretListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
class UPd
{
    public static void main()
    {
       JLabel lin=new JLabel("Update the values");
        Font ff=new Font("Arial",Font.ITALIC,20);
        lin.setFont(ff);
        JLabel l=new JLabel("Enter you WhatsApp Number");
        JTextField tf=new JTextField("",20);
          tf.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {            
                sql11.main("SELECT * FROM PERSON WHERE WhatsApp='"+tf.getText()+"';");
            }
        });   
        JLabel l1=new JLabel("Enter New Name");
        JTextField tf1=new JTextField("",20);
        JLabel l2=new JLabel("Enter New Email");
        JTextField tf2=new JTextField("",20);
           tf2.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {            
                String s="UPDATE PERSON SET Name='"+tf1.getText()+"',Email='"+tf2.getText()+"' WHERE WhatsApp='"+tf.getText()+"';";
                String s1="update person set Name='"+tf1.getText()+"',Email='"+tf2.getText()+"' where WhatsApp='"+tf.getText()+"';";
                sql11.ins(s,s1);
            }
        });
        JLabel gl=new JLabel("Enter you Group ID");
        JTextField gtf=new JTextField("",20);
          tf.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {            
                sql11.main("SELECT * FROM GROUP WHERE GRO='"+tf.getText()+"';");
            }
        }); 
        JLabel y=new JLabel("OR");
        y.setFont(ff);
        JLabel gl1=new JLabel("Enter  WhatsApp Number to delete");
        JTextField gtf1=new JTextField("",20);
        JLabel ge=new JLabel("Enter Group");
        JTextField gw=new JTextField("",20);
           gw.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {            
                String s="DELETE FROM gg WHERE WhatsApp='"+gtf1.getText()+"' and GRO='"+gw.getText()+"';";   
                sql11.ingg(s);
            }
        });
        JFrame frame = new JFrame("UPDATE FRAME");
         JButton back=new JButton("Back to Menu Frame");
            back.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {             
                  Menu.main();
                  frame.dispose();
            }
        });
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new java.awt.FlowLayout());
      JPanel p=new JPanel();
        p.add(lin);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(l);
        p.add(tf);   
        p.add(l1);
         p.add(l1);
          p.add(tf1);
           p.add(l2);
         p.add(tf2);
         p.add(y);
         p.add(gl1);
         p.add(gtf1);
         p.add(ge);
         p.add(gw);
         p.add(back);
       frame.add(p);
    frame.setSize(400,550);
    frame.setResizable(false);
    frame.setVisible(true);
    tf.requestFocus();
            }
        }