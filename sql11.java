import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class sql11
{
       private static final String url="jdbc:mysql://localhost:3306/CONTACTSYS";
         private static final String user="root";
        private static final String pass="2002";
          public static void ingg(String p1)
       {
           try
           {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection(url,user,pass);
               Statement stmt=conn.createStatement();
               int  r=stmt.executeUpdate(p1);
               conn.close();
           }catch(Exception e)
           {
                System.out.println(e.getMessage());
           }
        } 
       public static void ins(String p1,String p2)
       {
           try
           {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection(url,user,pass);
               Statement stmt=conn.createStatement();
               int  r=stmt.executeUpdate(p1);
               int r1=stmt.executeUpdate(p2);
               conn.close();
           }catch(Exception e)
           {
                System.out.println(e.getMessage());
           }
        } 
          public static void dell(String p1,String p2,String u)
       {
           try
           {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection(url,user,pass);
               Statement stmt=conn.createStatement();
               int  r=stmt.executeUpdate(p1);
               int r2=stmt.executeUpdate(u);
               int r1=stmt.executeUpdate(p2);
               
               conn.close();
           }catch(Exception e)
           {
                System.out.println(e.getMessage());
           }
        } 
    public static void main(String p)
    {
        JFrame f=new JFrame("View Frame");
        JLabel l=null,l1=null,l2=null;
        JPanel pp=new JPanel();
        JPanel p1=new JPanel();
        int t=0;
         try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,user,pass);
           Statement stmt=conn.createStatement();
                        ResultSet rr=stmt.executeQuery(p);
                        while(rr.next())
                       {
                           t++;  
                           l1=new JLabel(t+").Name::"+rr.getString("Name"));
                               l=new JLabel("   WhatsApp::"+rr.getString("WhatsApp"));
                            l2=new JLabel("   Email::"+rr.getString("Email"));
                              pp.add(l1);
                                pp.add(l);
                             pp.add(l2);
                        }    
                        conn.close();
                }
                  catch(Exception e)
                 {
                         System.out.println("No Such data");
                        }
            if(l2==null)
            System.out.println("No such data exist");
            pp.setLayout(new BoxLayout(pp,BoxLayout.Y_AXIS));
        f.getContentPane( ).setLayout(new java.awt.FlowLayout( ));
            p1.add(pp);
        f.add(p1);
        f.setSize(500,1000);
        f.setResizable(false);
        f.setVisible(true);   
    }
    public static void moreinfo(String h)
    {
      JFrame f=new JFrame("View Frame");
        JLabel l=null,l1=null,l2=null,l3=null;
        JPanel pp=new JPanel();
         pp.setLayout(new BoxLayout(pp,BoxLayout.Y_AXIS));
        int t=0;
         try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,user,pass);
           Statement stmt=conn.createStatement();
                        ResultSet rr=stmt.executeQuery(h);
                        while(rr.next())
                       {
                           t++;  
                           l1=new JLabel(   "    Birthday::"+rr.getString("bday"));
                               l=new JLabel(t+").WhatsApp::"+rr.getString("WhatsApp"));
                            l2=new JLabel("    Other Phone Number::"+rr.getString("Oph"));
                            l3=new JLabel("    Address::"+rr.getString("address"));
                              pp.add(l);
                                pp.add(l1);
                             pp.add(l2);  pp.add(l3);
                         }        
                        conn.close();
                }
                  catch(Exception e)
                 {
                         System.out.println("No Such data");
                        }
            if(l2==null)
            System.out.println("No such data exist");
        f.add(pp);
        f.setSize(500,1000);
        f.setResizable(false);
        f.setVisible(true);   
    }
    public static void maing(String p)
    {
        JFrame f=new JFrame("View Frame");
        JLabel l=null,l1=null; 
        JPanel pp=new JPanel();
        pp.setLayout(new BoxLayout(pp,BoxLayout.Y_AXIS));
         try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url,user,pass);
           Statement stmt=conn.createStatement();
                        ResultSet rr=stmt.executeQuery(p);
                        while(rr.next())
                       {
                              l1=new JLabel("Group::"+rr.getString("GRO")); 
                              l=new JLabel("  WhatsApp NO.::"+rr.getString("WhatsApp"));
                               pp.add(l1);
                               pp.add(l);
                        }
                        conn.close();
                }
                  catch(Exception e)
                 {
                         System.out.println("No Such data");
                        }
            if(l1==null)
            System.out.println("No such data exist");
        f.add(pp);
        f.setSize(500,500);
        f.setResizable(false);
        f.setVisible(true);    
    }
}