package mini;
import java.awt.*;

import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.*;
public class tryproj  {
	public static void main(String ars[])throws IOException{
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		JPanel panel=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(10,10,10,10);//spaces
		c.gridx=0;
		c.gridy=3;
		frame.add(panel);
		panel.setBackground(Color.blue);
		JLabel l1=new JLabel("DATA ENCRYPTION AND DECRYPTION TECHNIQUES");
		l1.setFont(l1.getFont().deriveFont(50.0f));
		l1.setForeground(Color.cyan);
		panel.add(l1,c);
		JLabel l2=new JLabel();
		l2.setIcon(new ImageIcon("C:\\Users\\Sony\\Desktop\\download.jpg"));
		c.gridx=0;
		c.gridy=4;
		
		panel.add(l2,c);
		frame.validate();
		
		JLabel l3=new JLabel();
		l3.setIcon(new ImageIcon("C:\\Users\\Sony\\Desktop\\key.jpg"));
		c.gridx=0;
		c.gridy=5;
		
		panel.add(l3,c);
		frame.validate();
		
		JButton b1=new JButton("Substitution");
		c.gridx=0;
		c.gridy=6;
		
		panel.add(b1,c);
		JButton b2=new JButton("Transposition");
		c.gridx=0;
		c.gridy=7;
		
		panel.add(b2,c);
		JButton b3=new JButton("Onetime pad");
		c.gridx=0;
		c.gridy=8;
		
		panel.add(b3,c);
		b1.addActionListener(new Action());
		b2.addActionListener(new Action());
		b3.addActionListener(new Action());
		frame.pack();
	}
	static class Action implements ActionListener {
			public void actionPerformed(ActionEvent ae) 
			{
				try
				{
					Socket st=new Socket("192.168.137.20",8987);
					DataOutputStream u=new DataOutputStream(st.getOutputStream());
				 String action = ae.getActionCommand();
				 if (action.equals("Substitution"))
				{

					char a[]=new char[26];
					char b[]=new char[26];
					for(int i=0;i<26;i++){
						a[0]='a';a[1]='b';a[2]='c';a[3]='d';a[4]='e';a[5]='f';a[6]='g';a[7]='h';a[8]='i';a[9]='j';a[10]='k';a[11]='l';a[12]='m';a[13]='n';a[14]='o';a[15]='p';a[16]='q';a[17]='r';a[18]='s';a[19]='t';a[20]='u';a[21]='v';a[22]='w';a[23]='x';a[24]='y';a[25]='z';}
					for(int i=0;i<26;i++){
						b[0]='z';b[1]='e';b[2]='b';b[3]='r';b[4]='a';b[5]='s';b[6]='c';b[7]='d';b[8]='f';b[9]='g';b[10]='h';b[11]='i';b[12]='j';b[13]='k';b[14]='l';b[15]='m';b[16]='n';b[17]='o';b[18]='p';b[19]='q';b[20]='t';b[21]='u';b[22]='v';b[23]='w';b[24]='x';b[25]='y';}
					String msg="";
					msg=JOptionPane.showInputDialog(null,"Please enter the secret message to be encrypted");
					String s1[]=msg.split(" ");
					String res="";
					for(int i=0;i<s1.length;i++){
						res=res+s1[i];}
					char[] charac=res.toCharArray();
					int number[]=new int[50];
					int k=0;
					
					for(int j=0;j<charac.length;j++)
					{
						for(int l=0;l<a.length;l++)
						{
						char c=a[l];
						char c1=charac[j];
						if(Character.isUpperCase(c1))
						{
							String x=c+"";
							x=x.toLowerCase();
							c1=x.charAt(0);
						}
						if(c1==(c))
						{
							number[k]=l;
							k++;
							break;
						}
						}
					}
					String out="";
					for(int j=0;j<k;j++)
					{
							int var=number[j];
							System.out.print(b[var]);
							out=out+b[var];
						
					}
					JOptionPane.showMessageDialog(null,"The encrypted message is "+ out);
								    		char encr[]=out.toCharArray();
					char res1[]=new char[out.length()];
					for(int i=0;i<encr.length;i++)
					{
						for(int j=0;j<26;j++)
						{
							if(encr[i]==b[j])
							{
								res1[i]=a[j];
							}
						}
					}
   
					String x="";
					for(int i=0;i<res1.length;i++)
					{
						x=x+res1[i];
					}
					JOptionPane.showMessageDialog(null,"The decypted message is "+ x);
					u.writeUTF(x);
				}
				else if (action.equals("Transposition"))
				{
					String s="";
				    s= JOptionPane.showInputDialog(null,"enter key");
					int n=s.length();
					String input="";
					input=JOptionPane.showInputDialog(null,"enter text to be encryped :");
					char crypt1[]=input.toCharArray();
					int count=0,x;
					for(int i=0;i<crypt1.length;i++)
					{
						if(crypt1[i]!=' ')
						count++;	
					}
					x=count;
					int l=0;
					int var=x/n;
					int var1=x%n;
					int leti;
					if(var1!=0)
					{
						 leti=var+1;
					}
					else
					{
						leti=var;
					}
					int var2=var1+var;
					
					if(var2==1)
					{
					char crypt[][]=new char[1][n];
					
					for(int i=0;i<1;i++)
					{
						for(int j=0;j<n;j++)
						{
							if(crypt1[l]==' ')
							{
								l++;
							}
							else
							{
							crypt[i][j]=crypt1[l];
							l++;
							}
							if(l==crypt1.length+1)
								break;
							}
					}
					char charac[]="abcdefghijklmnopqrstuvwxyz".toCharArray();
					char test[]=s.toCharArray();
					int index[]=new int[n];
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<26;j++)
						{
							if(test[i]==charac[j])
							{
								index[i]=j;
								break;
							}
						}
					}
					int index1[]=new int [n];
					for(int i=0;i<n;i++)
					{
				      index1[i]=index[i];
				      System.out.print(index[i]);
					}
					for(int i=0;i<n;i++)
					{
				     for(int j=i+1;j<n;j++)
				     {
				   	  if(index1[i]>index1[j])
				   	  {
				   		  int temp=index1[i];
				   		  index1[i]=index1[j];
				   		  index1[j]=temp;
				   	  }
				     }
					}
					int result[]=new int[n];
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<n;j++)
						{
							if(index1[i]==index[j])
							{
								result[i]=j;
								break;
							}
						}
					}
					String t="";
					for(int i=0;i<n;i++)
					{
						int j=result[i];
						for(int z=0;z<leti;z++)
						{
							if(crypt[z][j]!='\u0000')
							t=t+crypt[z][j];
						}
					}
					JOptionPane.showMessageDialog(null, "Encrypted message is"+t);
					String out1="";
					for(int i=0;i<leti;i++)
					{
						for(int j=0;j<n;j++)
					{
							out1=out1+crypt[i][j];
							
					}
				}
					JOptionPane.showMessageDialog(null, "Decrypted message is"+out1);
					u.writeUTF(out1);
					}
					else
					{
					char crypt[][]=new char[var2*n][n];
					for(int i=0;i<leti;i++)
					{
						for(int j=0;j<n;j++)
						{
							if(crypt1[l]==' ')
							{
								if(l==crypt1.length-1 && i==leti)
									break;	
							j=j-1;
							if(l==crypt1.length-1)
								break;
							l++;
							}
							else
							{
							if(l==crypt1.length-1 && i==leti)
								break;
							crypt[i][j]=crypt1[l];
							if(l==crypt1.length-1)
								break;
							l++;
							}
							
						}
						if(l==crypt1.length-1 && i==leti)
							break;	
					}
					for(int i=0;i<leti;i++)
					{
						for(int j=0;j<n;j++)
						{
							System.out.print(crypt[i][j]+" ");
							
						}
						System.out.println();
					}
					char charac[]="abcdefghijklmnopqrstuvwxyz".toCharArray();
					char test[]=s.toCharArray();
					int index[]=new int[n];
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<26;j++)
						{
							if(test[i]==charac[j])
							{
								index[i]=j;
							}
						}
					}
					int index1[]=new int [n];
					for(int i=0;i<n;i++)
					{
				      index1[i]=index[i];
					}
					for(int i=0;i<n;i++)
					{
				     for(int j=i+1;j<n;j++)
				     {
				   	  if(index1[i]>index1[j])
				   	  {
				   		  int temp=index1[i];
				   		  index1[i]=index1[j];
				   		  index1[j]=temp;
				   	  }
				     }
					}
					int result[]=new int[n];
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<n;j++)
						{
							if(index1[i]==index[j])
							{
								result[i]=j;
								break;
							}
						}
					}
					String str1="";
					for(int i=0;i<n;i++)
					{
						int j=result[i];
						for(int z=0;z<leti;z++)
						{
							if(crypt[z][j]!='\u0000')
								str1=str1+crypt[z][j];
						}
					}
					JOptionPane.showMessageDialog(null, "Encrypted message is"+str1);
					String out1="";
					for(int i=0;i<leti;i++)
					{
						for(int j=0;j<n;j++)
					{
							out1=out1+crypt[i][j];
							
					}
				}
					JOptionPane.showMessageDialog(null, "Decrypted message is"+out1);
					u.writeUTF(out1);


					}
					
				}
				else if (action.equals("Onetime pad"))
				{
					 String msg1 = "";
					 msg1=JOptionPane.showInputDialog(null,"Please enter the secret message to be encrypted");
					    int asc[]=new int[msg1.length()];
					    String send=msg1;
					     for(int i=0;i<msg1.length();i++)
					     {
					    	 asc[i]=(int) msg1.charAt(i);
					     }
					     int bin[]=new int[500];
					     int k=0;
					     int len=0;
					     
					 for(int i=0;i<asc.length;i++)
					 {
						 
						 int num=asc[i];
						 while(num>0)
						 {
						 bin[k]=num%2;
						 num=num/2;
						 k++;
						 len++;
						 if(k==7)
						 {
							 k=0;
							break; 
						 }
						 }
					 }
					 System.out.println(len);
					 int f=0;
					 int rand[]=new int[len];
					 for(int i=0;i<len;i++)
					 {
						 if(i%2==0)
						 {
							 rand[i]=0;
						 }
						 else
						 {
							 rand[i]=1;
						 }
					 }
					 int gen[]=new int[len];
					 for(int i=0;i<len;i++)
					 {
						 if(rand[i]==bin[i])
						 {
							 gen[i]=0;
						 }
						 else
						 {
							 gen[i]=1;
						 }
					 }
					 String hu="";
					 for(int i=0;i<len;i++)
					 {
					      hu=hu+gen[i];
					 }
					 JOptionPane.showMessageDialog(null, "encrypted mssage is "+hu);
					 int conv[]=new int[7];
					 int stor[]=new int[msg1.length()];
					 int t=0;
					int decim=0;
					 int x=0;
					 int v=1,lol=0;
					 while(lol==0)
					 {
					 for(int i=len-1;i>=0;i--)
					 {	 
					 int temp=gen[i];
					 decim=decim+(int)Math.pow(2,i)*temp;
					 v++;
					 if(v%8==0 && t<msg1.length())
					 {
					 stor[t]=decim;
					 t++;
					 decim=0;
						 break;
					 }
					 if(i==0)
					 {
						 lol=1;
					 }
					 }
					 }
					 u.writeUTF(send);
					 }}
				 catch( Exception e)
				 {
					 System.out.println(e);
				 }
				 }
			}
	}

