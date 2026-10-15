import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
class INS
{
    public static void main()
    
    {
       JLabel lin=new JLabel("Insert the following values");
        Font ff=new Font("Arial",Font.ITALIC,20);
        lin.setFont(ff);
        JButton inp=new JButton("Insert in Person");
        JLabel l=new JLabel("Enter you Name");
        JTextField tf=new JTextField("",20);//name     
        JLabel l1=new JLabel("Enter you Whatapp Number"); ///////whatsapp no
        JTextField tf1=new JTextField("",20);//whatapp
        JLabel l2=new JLabel("Enter you Email");//emial
        JTextField tf2=new JTextField("",20);
        JLabel bb=new JLabel("Enter you Birthday");
        JTextField bd=new JTextField("",20);//bithday
        JLabel ph=new JLabel("Enter you Other Phone");
        JTextField Oph=new JTextField("",20);//phone
        JLabel ad3=new JLabel("Enter you Address");
        JTextField add=new JTextField("",20);//address
        JFrame f = new JFrame("JTextFieldExample"); 
        JButton ing=new JButton("Insert in Group");
        JLabel g=new JLabel("Enter Group id"); 
        l.setVisible(false);
            JTextField gin=new JTextField("",20);
        g.setVisible(false);
        gin.setVisible(false);
        tf.setVisible(false);
        l1.setVisible(false);
        tf1.setVisible(false);
        l2.setVisible(false);
        tf2.setVisible(false);
        bb.setVisible(false);
        bd.setVisible(false);
        ph.setVisible(false);
        Oph.setVisible(false);
        ad3.setVisible(false);
        add.setVisible(false);
        JButton b=new JButton("Submit");
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sql11.ins("INSERT INTO PERSON(Name,WhatsApp,Email) VALUES('"+tf.getText()+"','"+tf1.getText()+"','"+tf2.getText()+"');","INSERT INTO INFO(bday,Oph,address,WhatsApp) VALUES('"+bd.getText()+"','"+Oph.getText()+"','"+add.getText()+"','"+tf1.getText()+"');");
                 tf.setText(""); tf.setText(""); tf1.setText(""); tf2.setText(""); bd.setText(""); add.setText(""); Oph.setText("");
                 
            }
        });
        b.setVisible(false);
        inp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               l.setVisible(true);  
                tf.setVisible(true);
                l1.setVisible(true);
                tf1.setVisible(true);
                l2.setVisible(true);
                tf2.setVisible(true);
                  bb.setVisible(true);
               bd.setVisible(true);
                ph.setVisible(true);
               Oph.setVisible(true);
               ad3.setVisible(true);
               ing.setVisible(false);
               add.setVisible(true);
               b.setVisible(true);
               inp.setVisible(false);
            }
        }); 
        JButton b1=new JButton("Submit");
        b1.setVisible(false);
        ing.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               g.setVisible(true);  
                gin.setVisible(true);
                l1.setVisible(true);
                tf1.setVisible(true);
                ing.setVisible(false);
                inp.setVisible(false);  
                 b1.setVisible(true);
            }
        });
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               sql11.ingg("insert into gg(GRO,WhatsApp) values('"+gin.getText()+"','"+tf1.getText()+"');");
               gin.setText("");  tf1.setText("");
            }
        });
         JButton back=new JButton("Back to Menu Frame");
         back.addActionListener(new ActionListener()
        { 
            public  void actionPerformed(ActionEvent ev)
            {    
                  Menu.main();
                  f.dispose();
            }
        });   
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane( ).setLayout(new java.awt.FlowLayout( ));
        f.setSize(400,500);
        f.add(inp);
        
        f.add(ing);
        f.add(g);
        f.add(gin);
        f.add(l);
        f.add(tf);
         f.add(l1);
        f.add(tf1);
         f.add(l2);
        f.add(tf2);
         f.add(bb);
        f.add(bd);
         f.add(ph);
        f.add(Oph);
         f.add(ad3);
        f.add(add);
        f.add(b);
        f.add(b1);
        f.add(back);
        
        f.setResizable(false);
        f.setVisible(true);
        tf.requestFocus();
            }
        }