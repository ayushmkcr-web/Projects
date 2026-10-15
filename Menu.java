import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Menu 
{
    public static void main()
    {
        JLabel l=new JLabel("Choose option to perform desired operation on database");
        Font ff=new Font("Arial",Font.ITALIC,20);
        l.setFont(ff);
        JButton ins=new JButton("Insert");
        JFrame f=new JFrame("Menu Frame");
        JButton del=new JButton("Delete");
        JButton view=new JButton("View");
        JButton upd=new JButton("Update");
        ins.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {  
                INS.main();
                f.dispose();
            }
        });
        view.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                VIEW.main();
                f.dispose();
            }
        });
        upd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                UPd.main();
                f.dispose();
            }
        });
        del.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DEl.main();
                f.dispose();
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p=new JPanel();
        p.add(l,BorderLayout.CENTER);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(ins);
        p.add(del);
        p.add(view);
        p.add(upd);
        f.add(p);
        f.setSize(600,400);
        f.setResizable(false);
        f.setVisible(true);
    }
}