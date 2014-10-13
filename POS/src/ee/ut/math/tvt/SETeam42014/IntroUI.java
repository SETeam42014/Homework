package ee.ut.math.tvt.SETeam42014;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class IntroUI {

	public IntroUI() { 

		//String[] nameOptions = {"email of leader"};
		Properties prop = new Properties();
		String propFileName = "version.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String version = prop.getProperty("build.number");
		propFileName = "application.properties";
		InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(inputStream2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String leader = prop.getProperty("team.leader");
		String email = prop.getProperty("team.email");
		String mem1 = prop.getProperty("team.mem1");
		String mem2 = prop.getProperty("team.mem2");
		String mem3 = prop.getProperty("team.mem3");
		String teamname = prop.getProperty("team.name");
		String[] teamOptions = {"Team leader:",leader," ",
				"Team leader e-mail:", email," ","Other team members:", mem1, mem2 ,mem3, " ",
				"Version number:", version};
		JFrame guiFrame = new JFrame();  
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		guiFrame.setTitle(teamname); 
		guiFrame.setSize(600,400);  
		guiFrame.setLocationRelativeTo(null); 
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String[] leaderOptions2 = {"Johani Vajakas"};
		//final JPanel comboPanel = new JPanel(); 
		//JLabel comboLbl = new JLabel("Team members:"); 
		//JComboBox nimed = new JComboBox(nameOptions);  
		//comboPanel.add(comboLbl); comboPanel.add(nimed);  
		final JPanel listPanel = new JPanel(new BorderLayout());
		//final JPanel listPanel2 = new JPanel();
		//listPanel.setLayout();
		listPanel.setVisible(true); 
		//JLabel listLbl = new JLabel("Team members:");
		//JLabel listLbl2 = new JLabel("Team leader:");
		//JLabel listLbl3 = new JLabel("Team leader email:");
		JList team = new JList(teamOptions); 
		//JList teamldr = new JList(leaderOptions2);
		//JList teamldrm = new JList(nameOptions);
		//team.setLayoutOrientation(JList.VERTICAL_WRAP);  
		listPanel.add(team);
		//listPanel.add(listLbl2, BorderLayout.WEST); listPanel.add(teamldr, BorderLayout.WEST);
		//listPanel.add(listLbl3, BorderLayout.SOUTH); listPanel.add(teamldrm, BorderLayout.SOUTH);
		JButton tiimilogo = new JButton( "Tiimi logo");  
		
		final JLabel pilt = new JLabel(new ImageIcon("etc/panaan2.png"));
		guiFrame.add(pilt, BorderLayout.CENTER);
		tiimilogo.addActionListener(new ActionListener() { 
			@Override public void actionPerformed(ActionEvent event) { 
				 pilt.setVisible(!pilt.isVisible()); 
				 //comboPanel.setVisible(!comboPanel.isVisible());
				 } 
			});
		guiFrame.add(listPanel, BorderLayout.WEST); 
		//guiFrame.add(listPanel2, BorderLayout.WEST);
		guiFrame.add(tiimilogo,BorderLayout.SOUTH); 
		guiFrame.setVisible(true);  }

	public void getPropertiesValues() {
		// TODO Auto-generated method stub
		
	}
	}

