package mini;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.net.*;
import java.io.*;

public class Server
{
	public static void main(String args[])throws IOException
	{
	ServerSocket s=new ServerSocket(8785);
	Socket s1=s.accept();
	DataInputStream in=new DataInputStream(s1.getInputStream());
	String x=in.readUTF();
	//System.out.println("The encrypted message is");
	
	System.out.println(x);
	
	JFrame frame=new JFrame();
	//frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Sony\\Desktop\\download.jpg")))));
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,300);
	//frame.setBackground(Color.red);
	JPanel panel=new JPanel(new GridBagLayout());
	frame.add(panel);
	panel.setBackground(Color.pink);
	 
	
	GridBagConstraints c=new GridBagConstraints();
	c.insets=new Insets(10,10,10,10);//spaces
	c.gridx=0;
	c.gridy=3;
	JLabel l1=new JLabel("YOUR SECRET MESSAGE HAS SUCCESSFULLY ARRIVED!!");
	
	l1.setFont(l1.getFont().deriveFont(45.0f));
	l1.setForeground(Color.blue);
	panel.add(l1,c);
	
	c.gridx=0;
	c.gridy=5;
	
	
JLabel l2=new JLabel("THE DECRYPTED MESSAGE IS "+x );
	
	l2.setFont(l1.getFont().deriveFont(30.0f));
	l2.setForeground(Color.red);
	panel.add(l2,c);
	
	
	
	
	
	
	
	/*String key=in.readUTF();
	System.out.println("The key used is");
	System.out.println(key);
	char a[]=new char[47];
	char b[]=new char[47];
	for(int i=0;i<47;i++)
	{
		a[0]='a';
		a[1]='b';
		a[2]='c';
		a[3]='d';
		a[4]='e';
		a[5]='f';
		a[6]='g';
		a[7]='h';
		a[8]='i';
		a[9]='j';
		a[10]='k';
		a[11]='l';
		a[12]='m';
		a[13]='n';
		a[14]='o';
		a[15]='p';
		a[16]='q';
		a[17]='r';
		a[18]='s';
		a[19]='t';
		a[20]='u';
		a[21]='v';
		a[22]='w';
		a[23]='x';
		a[24]='y';
		a[25]='z';
		a[26]='}';
		a[27]='{';
		a[28]=']';
		a[29]='[';
		a[30]='"';
		a[31]='/';
		a[32]='.';
		a[33]=',';
		a[34]='@';
		a[36]='#';
		a[37]='*';
		a[38]='%';
		a[39]='&';
		a[40]='!';
		a[41]='(';
		a[42]=')';
		a[43]='<';
		a[44]='>';
		a[45]=';';
		a[46]='?';
		}

	for(int i=0;i<26;i++)
	{
		b[i]=key.charAt(i);
	}
	for(int i=26;i<47;i++)
	{
		a[26]='?';
		a[27]=';';
		a[28]='>';
		a[29]='<';
		a[30]=')';
		a[31]='(';
		a[32]='!';
		a[33]='&';
		a[34]='%';
		a[36]='*';
		a[37]='#';
		a[38]='@';
		a[39]=',';
		a[40]='.';
		a[41]='/';
		a[42]='"';
		a[43]='[';
		a[44]=']';
		a[45]='{';
		a[46]='}';
		
		}
	char encr[]=x.toCharArray();
	char res[]=new char[x.length()];
	for(int i=0;i<encr.length;i++)
	{
		for(int j=0;j<26;j++)
		{
			if(encr[i]==b[j])
			{
				res[i]=a[j];
			}
		}
	}
	System.out.println("The decrypted message is");
	for(int i=0;i<res.length;i++)
	{
		System.out.print(res[i]);
	}
	
	
	*/
	}
}
