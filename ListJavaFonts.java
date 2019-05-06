package swing;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ListJavaFonts  implements ListSelectionListener{
	JList <String>jlist,jlist2,jlist3;
	JLabel sample;
	ListJavaFonts(){
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JFrame fontframe=new JFrame("font");
		fontframe.setSize(700,700/2);
		fontframe.setLayout(new GridBagLayout());
		sample=new JLabel("AaBbCcDd");
		//sample.setBounds(500,700,50,30);
		JLabel locallabel1=new JLabel("         Font:         ");
		JLabel locallabel2=new JLabel("         Font Style:   ");
		JLabel locallabel3=new JLabel("         Size:         ");
		JLabel locallabel4=new JLabel("Sample:");
		JButton b1=new JButton("OK");
		JButton b2=new JButton("CANCEL");
		/*JLabel locallabel5=new JLabel("Dictionary");*/
		String fontnames[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		String fontstyle[]= {"PLAIN","BOLD","ITALIC"};
		String fontsize[]=new String[14];
		for (int i=0;i<14;i++) { fontsize[i]=4*i+8+"";	}
		jlist=new JList<String>(fontnames);
		jlist2=new JList<String>(fontstyle);
		jlist3=new JList<String>(fontsize);
		jlist.setSelectedIndex(8);
		jlist2.setSelectedIndex(0);
		jlist3.setSelectedIndex(2);
		jlist.addListSelectionListener((ListSelectionListener) this);
		jlist2.addListSelectionListener((ListSelectionListener) this);
		jlist3.addListSelectionListener((ListSelectionListener) this);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jscrollpane=new JScrollPane(jlist);
		jscrollpane.setPreferredSize(new Dimension(210,150));
		JScrollPane jscrollpane2=new JScrollPane(jlist2);
		jscrollpane2.setPreferredSize(new Dimension(120,150));
		JScrollPane jscrollpane3=new JScrollPane(jlist3);
		jscrollpane3.setPreferredSize(new Dimension(10,150));
		sample.setFont(new Font(fontnames[jlist.getSelectedIndex()],Font.PLAIN,16));
		
		//JPanel jp=new JPanel();
		//jp.add(jlist);
		//jp.add(jscrollpane);
		//jwindow.add(jp);
		
		//jwindow.setSize(200,200);
		//jp.setBackground(Color.RED);
		
		//jwindow.setVisible(true);
		//fontframe.add(jlist);
		
		p1.add(locallabel1);
		p1.add(locallabel2);
		p1.add(locallabel3);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		fontframe.add(p1,c);
		
		p2.add(jscrollpane);
		p2.add(jscrollpane2);
		p2.add(jscrollpane3);
		c.gridx = 1;
		c.gridy = 0;
		fontframe.add(p2,c);
		
		p3.add(locallabel4);
		p3.add(sample);
		p3.setLayout(new GridLayout(3,3,10,10));
		fontframe.add(p3);
		
		p4.add(b1);
		p4.add(b2);
		p4.setLayout(new GridLayout(4,3,10,10));
		fontframe.add(p4);
		
		fontframe.setVisible(true);
	}
	 public void valueChanged(ListSelectionEvent e) {
		 String Font_=jlist.getSelectedValue();
		 String Font_style=jlist2.getSelectedValue();
		 int fs=Font.PLAIN;
		 if(Font_style.equals("BOLD")) {fs=Font.BOLD;}
		 if(Font_style.equals("PLAIN")) {fs=Font.PLAIN;}
		 if(Font_style.equals("ITALIC")) {fs=Font.ITALIC;}
		 //if(Font_style.equals("ITALIC")) {fs=Font.ITALIC;}
		 int Font_Size=jlist3.getSelectedIndex()*4+8;
		 sample.setFont(new Font(Font_,fs,Font_Size));
	 }
	
	  	  }

	
