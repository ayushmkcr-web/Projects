import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
class VIEW
{
    public static void main()
    {
       JLabel lin=new JLabel("View the values                         ");
        Font ff=new Font("Arial",Font.ITALIC,20);
        lin.setFont(ff);
        JLabel l=new JLabel("Enter WhatsApp Number");
        JTextField tf=new JTextField("",12);
        JFrame frame=new JFrame();
        JLabel l1=new JLabel("Enter GROUP ID");
        JTextField tf1=new JTextField("",12);
        JButton bin=new JButton("More Info All");
        bin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sql11.moreinfo("select o.bday,o.address,o.Oph,c.WhatsApp from info as o inner join person as c on o.WhatsApp=c.WhatsApp;");
            }
        });
        bin.setVisible(false);
        JButton bin2=new JButton("More Info");
        bin2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sql11.moreinfo("select * from info where WhatsApp='"+tf.getText()+"';");
            }
        });
        bin2.setVisible(false);
           tf.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {                
                  sql11.main("SELECT * FROM PERSON WHERE WhatsApp="+tf.getText());
                  bin2.setVisible(true);
            }
        });
          tf1.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {                
                  sql11.main("SELECT * FROM PERSON WHERE WhatsApp in(SELECT WhatsApp FROM gg WHERE GRO="+tf1.getText()+");");
            }
        }); 
        JButton b=new JButton("Show All Contacts");
        b.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {                
                  sql11.main("SELECT * FROM PERSON");
                  bin.setVisible(true);
            }
        });
        JButton b1=new JButton("Show All GROUP");
        b1.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent ev)
            {                
                 sql11.maing("SELECT * FROM gg order by GRO;");
            }
        });
        JButton back=new JButton("Back to Menu Frame");
         back.addActionListener(new ActionListener()
        { 
            public  void actionPerformed(ActionEvent ev)
            {    
                  Menu.main();
                  frame.dispose();
            }
        });   
        JPanel p=new JPanel();
        p.add(lin);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(l);
        p.add(tf);   
        p.add(b);
         p.add(l1);
          p.add(tf1);
           p.add(b1);
         p.add(back);
         p.add(bin);
         p.add(bin2);
       frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane( ).setLayout(new java.awt.FlowLayout( ));
    frame.setSize(400,550);
    frame.setResizable(false);
    frame.setVisible(true);
    tf.requestFocus();
            }
        }