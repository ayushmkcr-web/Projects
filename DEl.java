import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
class DEl       
{
    public static void main()
    {
       JLabel lin=new JLabel("Delete the desired values                  ");
        Font ff=new Font("Arial",Font.ITALIC,20);  lin.setFont(ff);
        JLabel l=new JLabel("Enter WhatsApp");
        JTextField tf=new JTextField("",20);
           tf.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {    
              String s="DELETE FROM info WHERE WhatsApp='"+tf.getText()+"';"; 
              String s2="DELETE FROM GG WHERE WhatsApp='"+tf.getText()+"';"; 
              String s1="DELETE FROM Person WHERE WhatsApp='"+tf.getText()+"';"; 
             
              sql11.dell(s,s1,s2);   
            }
        });
        JLabel l1=new JLabel("Enter Group id");
        JTextField tf1=new JTextField("",20);
           tf1.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {    
              String s="DELETE FROM gg WHERE GRO="+tf1.getText()+";"; 
              sql11.ingg(s);   
            }
        });
        JFrame frame = new JFrame("JTextFieldExample");
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
        frame.getContentPane( ).setLayout(new java.awt.FlowLayout( ));
        frame.add(lin);
        frame.add(l);
        frame.getContentPane( ).add(tf);
         frame.add(l1);
        frame.getContentPane( ).add(tf1);
        frame.add(back);
        frame.setSize(400,550);
        frame.setResizable(false);
        frame.setVisible(true);
          tf.requestFocus();
            }
        }