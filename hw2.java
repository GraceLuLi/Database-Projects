package hw2package;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class hw2 extends javax.swing.JFrame {
	private JEditorPane jEditorPane1;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JLabel jLabel5;
	private JEditorPane jEditorPane2;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jTextField2;
	private JLabel jLabel4;
	private JLabel jLabel1;
	private JScrollPane jScrollPane3;
	private JRadioButton jRadioButton2;
	
	static Connection mainConnection = null;
  	static Statement mainStatement = null;
  	static ResultSet mainResultSet = null;
  	static PreparedStatement SecondStatement = null;
	static Statement ThirdStatement = null;
	
	Graphics g = null;
	int clicks = 0;
	int x1,x2,y1,y2;
	int q1x, q1y;
	int q3x, q3y;
	int q4x, q4y;
	int res_x, res_y;
	int ph_x, ph_y;
	String res_type= "";
	String pht_id="";
	int index;
	int q1re_x[] =new int[40];
	int q1re_y[] =new int[40];
	int q1p_x[] =new int[30];
	int q1p_y[] =new int[30];
	int re_x[] =new int[40];
	int re_y[] =new int[40];
	int p_x[] =new int[30];
	int p_y[] =new int[30];
	java.util.List<Polygon> userls = new LinkedList<Polygon>();
	Polygon poly;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				hw2 inst = new hw2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public hw2() {
		super();
		ConnectToDB();
		initGUI();
		groupradios();
		g = jLabel2.getGraphics();
	}
	
	public static void ConnectToDB()
    {
		try
		{
			// loading Oracle Driver
    		System.out.print("Looking for Oracle's jdbc-odbc driver ... ");
	    	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	    	System.out.println(", Loaded.");

			String host = "localhost";
	  	    String port = "1521";
		    String dbName = "orcl";
		    String userName = "SYSTEM";
            String password = "KIDkid123";
		    String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbName;

	    	System.out.print("Connecting to DB...");
	    	mainConnection = DriverManager.getConnection(dbURL, userName, password);
	    	System.out.println(", Connected!");

    		mainStatement = mainConnection.createStatement();
	    	SecondStatement = mainConnection.prepareStatement( "insert into values" );
            ThirdStatement = mainConnection.createStatement(
                                         ResultSet.TYPE_SCROLL_INSENSITIVE,
                                         ResultSet.CONCUR_READ_ONLY);

   		}
   		catch (Exception e)
   		{
     		System.out.println( "Error while connecting to DB: "+ e.toString() );
     		e.printStackTrace();
     		System.exit(-1);
   		}
    }
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setTitle("Lu Li    4264118672");
			//setResizable(false);
			
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jEditorPane1 = new JEditorPane();
			}
			{
				jScrollPane3 = new JScrollPane();
				{
					jEditorPane2 = new JEditorPane();
					jEditorPane2.setText("Your submitted query should be displayed here.");
					jScrollPane3.setViewportView(jEditorPane2);
					jEditorPane2.setPreferredSize(new java.awt.Dimension(382, 157));
				}
			}
			{
				jRadioButton1 = new JRadioButton();
				jRadioButton1.setText("Nearest Neighbor");
				//jRadioButton1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				jRadioButton2 = new JRadioButton();
				jRadioButton2.setText("Range");
			}
			{
				jRadioButton3 = new JRadioButton();
				jRadioButton3.setText("Find Matching Restaurant");
			}
			{
				jRadioButton4 = new JRadioButton();
				jRadioButton4.setText("Find Relevant Photos");
			}
			{
				jLabel2 = new JLabel();
				jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/la.jpg")));
				jLabel2.setMaximumSize(new java.awt.Dimension(600, 500));
				jLabel2.setMinimumSize(new java.awt.Dimension(600, 500));
				jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						jLabel2MouseClicked(evt);
					}
				});
				jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
					public void mouseMoved(java.awt.event.MouseEvent evt) {
						jLabel2MouseMoved(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				jLabel3.setText("Active Features");
			}
			{
				jCheckBox1 = new JCheckBox();
				jCheckBox1.setText("Restaurants");
			}
			{
				jCheckBox2 = new JCheckBox();
				jCheckBox2.setText("Photos");
			}
			{
				jLabel4 = new JLabel();
				jLabel4.setText("Input");
			}
			{
				jTextField2 = new JTextField();
			}
			{
				jButton1 = new JButton();
				jButton1.setText("Clear");
				jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						jButton1MouseClicked(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				jButton2.setText("Submit Query");
				jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						jButton2MouseClicked(evt);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("Current Coordinates (X,Y):");
			}
			{
				jTextField1 = new JTextField();
			}
			{
				jLabel5 = new JLabel();
				
				jLabel5.setMinimumSize(new java.awt.Dimension(600,500));
				jLabel5.setMaximumSize(new java.awt.Dimension(600,500));
				jLabel5.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseMoved(MouseEvent evt) {
						jLabel5MouseMoved(evt);
					}
				});
				jLabel5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jLabel5MouseClicked(evt);
					}
				});
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
				        .addGap(33)
				        .addComponent(jEditorPane1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				        .addGap(61))
				    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
				.addGap(0, 21, Short.MAX_VALUE)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(jCheckBox2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jRadioButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jCheckBox1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addGap(17)))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jRadioButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(22)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jRadioButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
				                .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                    .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
				                .addGap(15))
				            .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(37, 37));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jLabel5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jLabel5, jLabel1, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jRadioButton4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
				                        .addGap(50))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
				                        .addGap(22)))
				                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jRadioButton3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
				                .addGap(50))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(jLabel1, jEditorPane1, LayoutStyle.ComponentPlacement.INDENT)
				                .addComponent(jEditorPane1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
				                .addGap(23)))
				        .addGap(9)))
				.addGap(31)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jScrollPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jCheckBox2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                .addGap(253))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
				                .addGap(238))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				                .addGap(245)))
				        .addGap(92)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 0, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 8, Short.MAX_VALUE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 29, Short.MAX_VALUE))))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(jScrollPane3, jLabel2, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 8, Short.MAX_VALUE)))
				.addContainerGap(45, 45));

			pack();
			this.setSize(893, 688);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) 
	{	
		jTextField1.setText(evt.getX() + ", " + evt.getY());
    }//GEN-LAST:event_jLabel1MouseMoved
	
	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) 
	{
		clicks++;
		if(jRadioButton2.isSelected())
		{
			if(clicks == 1)
			{
				x1 = evt.getX();
				y1 = evt.getY();
				g.setColor(Color.BLUE);
				g.drawLine(x1-4, y1-4, x1+4, y1+4);
				g.drawLine(x1-4, y1+4, x1+4, y1-4);
			}
			else if (clicks == 2)
			{
				x2 = evt.getX();
				y2 = evt.getY();
				g.setColor(Color.BLUE);
				g.drawRect(x1, y2, x2-x1, y1-y2);
				g.drawLine(x2-4, y2-4, x2+4, y2+4);
				g.drawLine(x2-4, y2+4, x2+4, y2-4);
			}
			else if(clicks>2)
			{
				//show the information of rspoints
				double dist_x, dist_y, dist;
				for(int i=0; i < re_x.length; i++)
				{
					dist_x = Math.abs(re_x[i]-evt.getX());
					dist_y = Math.abs(re_y[i]-evt.getY());
					dist = Math.sqrt(dist_x*dist_x + dist_y*dist_y);
					if(dist <= 5)
					{
						showRestaurantInfo(re_x[i],re_y[i]);
					}
				}
				
				//show the information of ptpoints
				int j = 0;
				for(int i=0; i < userls.size(); i++)
				{
					poly = userls.get(i);
					
					if(poly.contains(evt.getX(), evt.getY()) && j<1)
					{
						showPhotoPic(p_x[i],p_y[i],j);
					}
				}
			}
		}
		else if(jRadioButton1.isSelected())
		{
			if(clicks == 1)
			{
				q1x = evt.getX();
				q1y = evt.getY();
				g.setColor(Color.RED);
				g.drawLine(q1x-4, q1y-4, q1x+4, q1y+4);
				g.drawLine(q1x-4, q1y+4, q1x+4, q1y-4);
			}
			else if(clicks >1)
			{
				//show the information of rspoints 
				double dist_x, dist_y, dist;
				for(int i=0; i < q1re_x.length; i++)
				{
					dist_x = Math.abs(q1re_x[i]-evt.getX());
					dist_y = Math.abs(q1re_y[i]-evt.getY());
					dist = Math.sqrt(dist_x*dist_x + dist_y*dist_y);
					if(dist <= 5)
					{
						showRestaurantInfo(q1re_x[i],q1re_y[i]);
					}
				}

				//show the information of ptpoints
				int j = 0;
				for(int i=0; i < userls.size(); i++)
				{
					poly = userls.get(i);
					
					if(poly.contains(evt.getX(), evt.getY()) && j<1)
					{
						showPhotoPic(q1p_x[i],q1p_y[i],j);
					}
				}
			}
		}
		if(jRadioButton3.isSelected() && jRadioButton2.isSelected())
		{
			if(clicks > 2)
			{
				int j = 0;
				for(int i=0; i < userls.size(); i++)
				{
					poly = userls.get(i);
					
					if(poly.contains(evt.getX(), evt.getY()) && j<1)
					{
						
							j++;
							q3x = p_x[i];
							q3y = p_y[i];
        
					}
				}
			}
		}
		if(jRadioButton3.isSelected() && jRadioButton1.isSelected())
		{
			if(clicks > 1)
			{
				int j = 0;
				for(int i=0; i < userls.size(); i++)
				{
					poly = userls.get(i);
					
					if(poly.contains(evt.getX(), evt.getY()) && j<1)
					{
							j++;
							q3x = q1p_x[i];
							q3y = q1p_y[i];

        
					}
				}
			}
		}
		if(jRadioButton4.isSelected() && jRadioButton2.isSelected())
		{
			if(clicks > 2)
			{
				double dist_x, dist_y, dist;
				for(int i=0; i < re_x.length; i++)
				{
					dist_x = Math.abs(re_x[i]-evt.getX());
					dist_y = Math.abs(re_y[i]-evt.getY());
					dist = Math.sqrt(dist_x*dist_x + dist_y*dist_y);
					if(dist <= 5)
					{
						try
						{
							q4x = re_x[i];
							q4y = re_y[i];
							String querydc = "";
							querydc += "select r.r_name, r.r_id, r.r_phone ";
							querydc += "from rspoints r ";
							querydc += "where r.r_location.sdo_point.x=" + re_x[i] +" and r.r_location.sdo_point.y=" + re_y[i] + " ";
							querydc += "and sdo_relate(r.r_location, sdo_geometry(2003,null,null,sdo_elem_info_array(1,1003,3),";
							querydc += "sdo_ordinate_array(" + x1 +"," + y1 + "," + x2 + "," + y2 + ")),'mask=anyinteract')='TRUE'";
							ResultSet dcresult = mainStatement.executeQuery(querydc);
							while(dcresult.next())
							{
                                displayResInfo(dcresult, re_x[i],re_y[i]);
							}
							g.clearRect(0, 0, 600, 500);
							jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/la.jpg")));
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
        
					}

				}
			}
		}
		if(jRadioButton4.isSelected() && jRadioButton1.isSelected())
		{
			if(clicks > 1)
			{
				double dist_x, dist_y, dist;
				for(int i=0; i < q1re_x.length; i++)
				{
					dist_x = Math.abs(q1re_x[i]-evt.getX());
					dist_y = Math.abs(q1re_y[i]-evt.getY());
					dist = Math.sqrt(dist_x*dist_x + dist_y*dist_y);
					if(dist <= 5)
					{
						try
						{
							
							q4x = q1re_x[i];
							q4y = q1re_y[i];
							String querydc = "";
							querydc += "select r.r_name, r.r_id, r.r_phone ";
							querydc += "from rspoints r ";
							querydc += "where r.r_location.sdo_point.x=" + q1re_x[i] +" and r.r_location.sdo_point.y=" + q1re_y[i] + " ";
							querydc += "and sdo_relate(r.r_location, sdo_geometry(2003,null,null,sdo_elem_info_array(1,1003,3),";
							querydc += "sdo_ordinate_array(" + x1 +"," + y1 + "," + x2 + "," + y2 + ")),'mask=anyinteract')='TRUE'";
							ResultSet dcresult = mainStatement.executeQuery(querydc);
							while(dcresult.next())
							{
								displayResInfo(dcresult, q1re_x[i],q1re_y[i]);
							}
							g.clearRect(0, 0, 600, 500);
							jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/la.jpg")));
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
        
					}

				}
			}
		}
	}
	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) 
	{
		if(!jRadioButton3.isSelected() && !jRadioButton4.isSelected())
		{
			if(jCheckBox1.isSelected() && !jCheckBox2.isSelected() && jRadioButton2.isSelected() && clicks>1 )
			{
				try 
				{
					String querydc = queryResInRange();
					ResultSet dcresult = mainStatement.executeQuery(querydc);
					jEditorPane2.setText(querydc);
					int i=0;
					while(dcresult.next())
					{
						re_x[i] = dcresult.getInt("x");
						re_y[i] = dcresult.getInt("y");
						drawYellowCircle(re_x[i],re_y[i]);
						i++;
					}
					dcresult.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
			else if(!jCheckBox1.isSelected() && jCheckBox2.isSelected() && jRadioButton2.isSelected() && clicks>1 )
			{
				try 
				{
					
                    String queryuser = queryPhoInRange();
                    ResultSet uresult = mainStatement.executeQuery(queryuser);
            		jEditorPane2.setText(queryuser);
					int i=0;
					while(uresult.next())
					{
						p_x[i] = uresult.getInt("x");
						p_y[i] = uresult.getInt("y");
						g.setColor(Color.black);
						drawRedTriangle(p_x[i],p_y[i],i);
						i++;
					}
					uresult.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
			else if(jCheckBox1.isSelected() && jCheckBox2.isSelected() && jRadioButton2.isSelected() && clicks>1 )
			{
				try 
				{
					String querydc = queryResInRange();
					ResultSet dcresult = mainStatement.executeQuery(querydc);
					
					
					int i=0;
					while(dcresult.next())
					{
						re_x[i] = dcresult.getInt("x1");
						re_y[i] = dcresult.getInt("y1");
						drawYellowCircle(re_x[i],re_y[i]);
						i++;
					}
					
                    String queryuser = queryPhoInRange();
                    ResultSet uresult = mainStatement.executeQuery(queryuser);
					jEditorPane2.setText("Query1: "+ querydc+ "\nQuery2:"+ queryuser);
					
					i=0;
					while(uresult.next())
					{
						p_x[i] = uresult.getInt("x2");
						p_y[i] = uresult.getInt("y2");
						g.setColor(Color.black);
						drawRedTriangle(p_x[i],p_y[i],i);
						i++;
					}
					dcresult.close();
					uresult.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
			else if( jRadioButton1.isSelected() && !("".equals(jTextField2.getText())) && clicks>0)
			{
				String querydc = "";
				String queryuser = "";
				//jcheckbox1 is selected
				if(jCheckBox1.isSelected()){
				try 
				{
					
					querydc += "select r.r_location.sdo_point.x AS x, r.r_location.sdo_point.y AS y ";
					querydc += "from rspoints r ";
					querydc += "where sdo_nn(r.r_location, sdo_geometry(2001,null,sdo_point_type(" + q1x + "," + q1y + ", null), null, null),'sdo_num_res= " + jTextField2.getText() + "')='TRUE'";
				
					ResultSet dcresult = mainStatement.executeQuery(querydc);
					jEditorPane2.setText(querydc);
					
					int i=0;
					while(dcresult.next())
					{
						q1re_x[i] = dcresult.getInt("x");
						q1re_y[i] = dcresult.getInt("y");
						drawYellowCircle(q1re_x[i],q1re_y[i]);
						i++;
					}
					dcresult.close();
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
				}
				//jicheckbox2 is selected
               if(jCheckBox2.isSelected()){
				try 
				{
					
					queryuser += "select p.p_location.sdo_point.x AS x, p.p_location.sdo_point.y AS y ";
					queryuser += "from ptpoints p ";
					queryuser += "where sdo_nn(p.p_location, sdo_geometry(2001,null,sdo_point_type(" + q1x + "," + q1y + ", null), null, null),'sdo_num_res= " + jTextField2.getText() + "')='TRUE'";
					ResultSet uresult = mainStatement.executeQuery(queryuser);
					jEditorPane2.setText(queryuser);
					
					int i=0;
					while(uresult.next())
					{
						q1p_x[i] = uresult.getInt("x");
						q1p_y[i] = uresult.getInt("y");
						g.setColor(Color.black);
						drawRedTriangle(q1p_x[i],q1p_y[i],i);
						i++;
					}
					uresult.close();
				} 
				
				catch (Exception e) 
				{
					System.out.println(e);
				}
               }
               jEditorPane2.setText("Query1: "+ querydc+ "\nQuery2:"+ queryuser);
			}
			
		}
		else if (jRadioButton3.isSelected() && jRadioButton2.isSelected() && clicks >2)
		{
			
			try 
			{
				String querydc = "";
				querydc += "select r1.r_location.sdo_point.x as x, r1.r_location.sdo_point.y as y ";
				querydc += "from rspoints r1, ptpoints p ";
				querydc += "where p.p_id ='"+ pht_id+"' and r1.r_name = p.p_name ";
				querydc += "order by sdo_geom.sdo_distance(r1.r_location, sdo_geometry(2001,null,sdo_point_type(" + res_x + "," + res_y + ", null), null, null),0.05)";

				ResultSet dcresult = mainStatement.executeQuery(querydc);
				jEditorPane2.setText(querydc);
					
				int i=0;
				index= 0;
				while(dcresult.next())
				{
					re_x[i] = dcresult.getInt("x");
					re_y[i] = dcresult.getInt("y");
					drawGreenCircle(re_x[i],re_y[i]);
					g.setColor(Color.black);
					g.drawString(Integer.toString(index+1),re_x[i]+10,re_y[i]+10);
					i++;
					index++;
				}
				dcresult.close();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
				
		}
		else if (jRadioButton3.isSelected() && jRadioButton1.isSelected() && clicks >1)
		{
			
			try 
			{
				String querydc = "";
				querydc += "select r1.r_location.sdo_point.x as x, r1.r_location.sdo_point.y as y ";
				querydc += "from rspoints r1, ptpoints p ";
				querydc += "where p.p_id = '"+pht_id +"'and r1.r_name = p.p_name ";
				querydc += "order by sdo_geom.sdo_distance(r1.r_location, sdo_geometry(2001,null,sdo_point_type(" + res_x + "," + res_y + ", null), null, null),0.05)";
				ResultSet dcresult = mainStatement.executeQuery(querydc);
				jEditorPane2.setText(querydc);
					
				int i=0;
				index =0;
				while(dcresult.next())
				{
					q1re_x[i] = dcresult.getInt("x");
					q1re_y[i] = dcresult.getInt("y");
					drawGreenCircle(q1re_x[i], q1re_y[i]);
					g.setColor(Color.black);
					g.drawString(Integer.toString(index+1),q1re_x[i]+10,q1re_y[i]+10);
					i++;
					index++;
				}
				dcresult.close();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
				
		}
		else if(jRadioButton4.isSelected() && jRadioButton2.isSelected() && clicks >1 && !("".equals(jTextField2.getText())))
		{
			
		
			try 
			{
				String queryuser = "";
				queryuser += "select p.p_location.SDO_POINT.x as x,p.p_location.SDO_POINT.y as y ";
				queryuser += "from ptpoints p, ";
				queryuser += "(select p1.p_id as id ";
				queryuser += "from ptpoints p1, psensor ps where ps.p_id = p1.p_id and ps.p_sensor= '"+res_type+"' ";		
				queryuser += "order by sdo_geom.sdo_distance(p1.p_location, sdo_geometry(2001,null,sdo_point_type(174,195, null), null, null),0.05))a ";
				queryuser += "where p.p_id = a.id and rownum<='"+jTextField2.getText()+"'";
				ResultSet uresult = mainStatement.executeQuery(queryuser);
				jEditorPane2.setText(queryuser);
				System.out.println(queryuser);
				
				int i=0;
				while(uresult.next())
				{
					p_x[i] = uresult.getInt("x");
					p_y[i] = uresult.getInt("y");
					g.setColor(Color.black);
					drawRedTriangle(p_x[i],p_y[i],i);
					
					i++;
				}
				uresult.close();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		else if(jRadioButton4.isSelected() && jRadioButton1.isSelected() && clicks >1 && !("".equals(jTextField2.getText())))
		{
			g = jLabel2.getGraphics();
			drawYellowCircle(q4x,q4y);
			
			try 
			{
				String queryuser = "";
				queryuser += "select p.p_location.SDO_POINT.x as x,p.p_location.SDO_POINT.y as y ";
				queryuser += "from ptpoints p, ";
				queryuser += "(select p1.p_id as id ";
				queryuser += "from ptpoints p1, psensor ps where ps.p_id = p1.p_id and ps.p_sensor= '"+res_type+"' ";		
				queryuser += "order by sdo_geom.sdo_distance(p1.p_location, sdo_geometry(2001,null,sdo_point_type(174,195, null), null, null),0.05))a ";
				queryuser += "where p.p_id = a.id and rownum<='"+jTextField2.getText()+"'";
				ResultSet uresult = mainStatement.executeQuery(queryuser);
				jEditorPane2.setText(queryuser);
				
				int i=0;
				while(uresult.next())
				{
					q1p_x[i] = uresult.getInt(1);
					q1p_y[i] = uresult.getInt(2);
					g.setColor(Color.black);
					drawRedTriangle(q1p_x[i], q1p_y[i], i);
					i++;
				}
				uresult.close();
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
	}
	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) 
	{
		g.clearRect(0, 0, 600, 500);
		clicks = 0;
		jCheckBox1.setSelected(false);
		jCheckBox2.setSelected(false);
		Arrays.fill(re_x, 0);Arrays.fill(re_y, 0);
		Arrays.fill(p_x, 0);Arrays.fill(p_y, 0);
		Arrays.fill(q1re_x, 0);Arrays.fill(q1re_y, 0);
		Arrays.fill(q1p_x, 0);Arrays.fill(q1p_y, 0);
		jEditorPane1.setText("");
		jTextField2.setText("");
		jEditorPane2.setText("Your submitted query should be displayed here.");
		repaint();
		groupradios( ) ;
		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(" ")));
	}
	
	private void groupradios( ) 
	{
		ButtonGroup bg1 = new ButtonGroup( );
		ButtonGroup bg2 = new ButtonGroup( );
		bg1.add(jRadioButton1);
		bg1.add(jRadioButton2);
		bg2.add(jRadioButton3);
		bg2.add(jRadioButton4);
		bg1.clearSelection();
		bg2.clearSelection();
		
	}
	
	//******draw yellow circle*******
	private void drawYellowCircle(int x, int y){
		g.setColor(Color.yellow);
		g.fillOval(x-5, y-5, 10, 10);
	}
	
	private void drawGreenCircle(int x, int y){
		g.setColor(Color.green);
		g.fillOval(x-5, y-5, 10, 10);
	}
	
	private void drawRedTriangle(int x, int y,int i){
		Point pttra1 = new Point(x, y - 8);
		Point pttra2 = new Point(x - 6, y + 3);
		Point pttra3 = new Point(x + 6, y + 3);
		g.drawLine((int)pttra1.getX(), (int)pttra1.getY(), (int)pttra2.getX(), (int)pttra2.getY());
		g.drawLine((int)pttra1.getX(), (int)pttra1.getY(), (int)pttra3.getX(), (int)pttra3.getY());
		g.drawLine((int)pttra2.getX(), (int)pttra2.getY(), (int)pttra3.getX(), (int)pttra3.getY());
		int xPoints[] = {(int)pttra1.getX(), (int)pttra2.getX(), (int)pttra3.getX()};
		int yPoints[] = {(int)pttra1.getY(), (int)pttra2.getY(), (int)pttra3.getY()};
		int nPoints = 3;
		poly = new Polygon(xPoints,yPoints,nPoints);
		userls.add(i, poly);
		g.setColor(Color.red);
		g.fillPolygon(xPoints, yPoints, nPoints);
		
		
	}
	
	private void showRestaurantInfo(int x, int y){

			try
			{
				String querydc = "";
				querydc += "select r.r_name, r.r_id, r.r_phone,r.r_location.sdo_point.x as x, r.r_location.sdo_point.y as y ";
				querydc += "from rspoints r ";
				querydc += "where r.r_location.sdo_point.x=" + x +" and r.r_location.sdo_point.y=" + y + " ";
				
				ResultSet dcresult = mainStatement.executeQuery(querydc);
				
				while(dcresult.next())
				{
					String dc1 = "Name: " + dcresult.getString(1)+"\nLocation: "+ x + "," + y + "\nPhone: "+dcresult.getString(3)+"\nFoodType: ";
					String querydc2 = "";
					querydc2 += "select rs.r_sensor as r_type from rsensor rs ";
					querydc2 += "where rs.r_id = '" + dcresult.getString(2) + "'";
					ph_x = dcresult.getInt("x");
					ph_y = dcresult.getInt("y");

					ResultSet dcresult2 = mainStatement.executeQuery(querydc2);
					
					while(dcresult2.next())
					{
						dc1 += dcresult2.getString(1) + " ";
						res_type = dcresult2.getString("r_type");
						res_type = res_type.toLowerCase();
					}
					jEditorPane1.setText(dc1);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	private void showPhotoPic(int x, int y, int j){

		try
		{
			j++;
			String queryuser = "";
			queryuser += "select p.p_name, p.p_id, p.p_num,p.p_location.sdo_point.x as x, p.p_location.sdo_point.y as y ";
			queryuser += "from ptpoints p ";
			queryuser += "where p.p_location.sdo_point.x=" + x +" and p.p_location.sdo_point.y=" + y + " ";
			ResultSet uresult = mainStatement.executeQuery(queryuser);
			
			while(uresult.next())
			{
				res_x = uresult.getInt("x");
				res_y = uresult.getInt("y");
				pht_id = uresult.getString("p_id");
				String dc1 = "/"+uresult.getString("p_num") ;
				jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(dc1)));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	
	}
	
	private void displayResInfo(ResultSet resResult , int x, int y) throws SQLException{
		String dc1 = "Name: " + resResult.getString(1)+"\nLocation: "+ x + "," + y + "\nPhone: " + resResult.getString(3)+"\nFoodType: ";
		String querydc2 = "";
		querydc2 += "select rs.r_sensor from rsensor rs ";
		querydc2 += "where rs.r_id = '" + resResult.getString(2) + "'";
		ResultSet dcresult2 = mainStatement.executeQuery(querydc2);
		while(dcresult2.next())
		{
			dc1 += dcresult2.getString(1) + " ";
		}
		jEditorPane1.setText(dc1);
	}
	
	private String queryResInRange(){
		String querydc = "";
		querydc += "select r.r_location.sdo_point.x AS x, r.r_location.sdo_point.y AS y ";
		querydc += "from rspoints r ";
		querydc += "where sdo_relate(r.r_location, sdo_geometry(2003,null,null,sdo_elem_info_array(1,1003,3),";
		querydc += "sdo_ordinate_array(" + x1 + "," + y1 + "," + x2 + "," + y2 + ")),'mask=anyinteract')='TRUE'";

		return querydc;
	}
	
	private String queryPhoInRange(){
		String queryuser = "";
		queryuser += "select p.p_location.sdo_point.x AS x, p.p_location.sdo_point.y AS y ";
		queryuser += "from ptpoints p ";
		queryuser += "where sdo_relate(p.p_location, sdo_geometry(2003,null,null,sdo_elem_info_array(1,1003,3),";
		queryuser += "sdo_ordinate_array(" + x1 + "," + y1 + "," + x2 + "," + y2 + ")),'mask=anyinteract')='TRUE'";
		return queryuser;
	}
	
	private void jLabel5MouseClicked(MouseEvent evt) {
		System.out.println("jLabel5.mouseClicked, event="+evt);
		//TODO add your code for jLabel5.mouseClicked
	}
	
	private void jLabel5MouseMoved(MouseEvent evt) {
		System.out.println("jLabel5.mouseMoved, event="+evt);
		//TODO add your code for jLabel5.mouseMoved
	}

}
