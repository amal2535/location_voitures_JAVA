import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class supprimer_voiture extends JFrame implements ActionListener {
	
	GridLayout g=new GridLayout(3,2,2,2);
	JPanel paninfo = new JPanel( ) ;
	JPanel p = new JPanel( ) ;
	private JLabel mat,a;
	private JTextField mattext;
	JButton ok = new JButton("OK");
	JTable tble = new JTable();
	JScrollPane jScrollPane1 =new JScrollPane();
	DefaultTableModel model=new DefaultTableModel();
	private JButton jButton1 = new JButton();
	Location_info li=new Location_info();
	ResultSet k;

	public supprimer_voiture(String title) {
		
		super(title);
		paninfo.setLayout(g);
		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("loc2.jpg")));
		setLayout(new FlowLayout(FlowLayout.CENTER, 55,15));
		setBackground( new Color(150,185,240));
	
				paninfo.setBackground( new Color(150,185,240)) ;
				paninfo. setPreferredSize( new Dimension( 355, 100) );
				
				p. setPreferredSize( new Dimension( 460, 400) );
				mattext  = new JTextField();
				mattext.setPreferredSize(new Dimension(100, 25));
				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Supprimer une location : ") ) ;
				

				mat = new JLabel( "Mattricule du voiture : ") ;
				mat.setPreferredSize(new Dimension( 100, 25));
				paninfo.add(mat);
				paninfo.add(mattext);
				
				a = new JLabel( "") ;
				a.setPreferredSize(new Dimension( 100, 25));
				paninfo.add(a);
				JButton jButton1= new JButton();
				jButton1.setBackground(Color.white);
				jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
                //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\supprimer.png")));
                jButton1.setText("Supprimer");
		        paninfo.add(jButton1);
				add(paninfo);	
			    jButton1.addActionListener(this);
			    
				Object[][] donnees =getLocationDetails() ;
				 
				String[] entetes = {"mattricule","marque","coleur","date_dachat","prix","etat"};
		 
				JTable tableau = new JTable(donnees, entetes);
		        tableau.setBackground(Color.white);
		        tableau.setSize(400,400);
				p.add(new JScrollPane(tableau), BorderLayout.SOUTH);
				add(p,BorderLayout.SOUTH);	
				
				
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setSize(500,500);
				setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
			JButton b=(JButton)e.getSource();
			PreparedStatement str = null;
			Connection Con = Connect.getInstance();
			try {
			str=Con.prepareStatement("Select * from voiture where  mattricule=?");
			str.setString(1, mattext.getText());
			k = str.executeQuery();
			
			if(!(mattext.getText().isEmpty()) && k.next()==true ) {
				Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				try {
				
				String query = "DELETE from voiture WHERE mattricule='"+mattext.getText()+"' ";
				
					
				state.executeUpdate(query);
				
	                        JOptionPane confirmation = new JOptionPane();
							confirmation.showMessageDialog(null, "La location a été supprimer" , "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
							
				}
			  catch (Exception ea) {
	            				ea.printStackTrace();
	            			}
			}
			else {
					
						JOptionPane confirmation = new JOptionPane();
						confirmation.showMessageDialog(null, "La voiture n'existe pas" , "Mise à ajour", JOptionPane.ERROR_MESSAGE, null);
			}		
						
				
			}
			catch (Exception ea) {
				ea.printStackTrace();
			}
	}
		
	private Object[][] getLocationDetails() {

			Object[][] data = null;


			final String QUERY = "Select * from voiture";
			
			try {   

				// Loading the Driver
				

				// Getting Database Connection Object by Passing URL, Username and Password

				Statement statement = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = statement.executeQuery(QUERY);

				int rowCount = getRowCount(rs); // Row Count
				int columnCount = getColumnCount(rs); // Column Count

				data = new Object[rowCount][columnCount];

				// Starting from First Row for Iteration
				rs.beforeFirst();

				int i = 0;
				
				if(rowCount==0) {
					JOptionPane confirmation = new JOptionPane();
					confirmation.showMessageDialog(null, "La liste est vide!" , "Mise à ajour", JOptionPane.ERROR_MESSAGE, null);
					setVisible(false);
				}
				else {
				while (rs.next()) {

					int j = 0;

					data[i][j++] = rs.getString("mattricule");
					data[i][j++] = rs.getString("marque");
					data[i][j++] = rs.getString("coleur");
					data[i][j++] = rs.getString("date_dachat");
					data[i][j++] = rs.getInt("prix");
					data[i][j++] = rs.getString("etat");

					i++;
				}

				boolean status = true;
				
				// Closing the Resources;
				statement.close();
				
			}} catch (Exception e) {

				e.printStackTrace();
			}
			

			return data;
	}

		private int getRowCount(ResultSet rs) {

			try {
				
				if(rs != null) {
					
					rs.last();
					
					return rs.getRow(); 
				}
				
			} catch (SQLException e) {

				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			return 0;
		}

		// Method to get Column Count from ResultSet Object
		private int getColumnCount(ResultSet rs) {

			try {

				if(rs != null)
					return rs.getMetaData().getColumnCount();

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				e.printStackTrace();
			}

			return 0;
		}

}