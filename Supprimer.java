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

public class Supprimer extends JFrame implements ActionListener {
	
	GridLayout g=new GridLayout(1,3,4,4);
	JPanel paninfo = new JPanel( ) ;
	JPanel p = new JPanel( ) ;
	private JLabel cin,mat;
	private JTextField tcin,tmat;
	JButton jButton1= new JButton();
	JTable tableau;
	JScrollPane jScrollPane1 =new JScrollPane();
	DefaultTableModel model=new DefaultTableModel();
	ResultSet k;

	public Supprimer(String title) {
		
		super(title);
		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("image.jpg")));
		setLayout(new FlowLayout(FlowLayout.CENTER, 75,15));
		setBackground(new Color(150,185,240));
		
				paninfo.setLayout(g);
				paninfo.setBackground(new Color(150,185,240));
				
				p. setPreferredSize( new Dimension( 455, 255) );
				
				tcin  = new JTextField();
				tcin.setPreferredSize(new Dimension(150, 25));

				tmat  = new JTextField();
				tmat.setPreferredSize(new Dimension(150, 25));
				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Supprimer une location : ") ) ;
				
				cin = new JLabel( "CIN de Client : ") ;
				cin.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(cin);
				paninfo.add(tcin);

				jButton1.setBackground(Color.white);
				jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
                //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("supprimer.png")));
                jButton1.setText("Supprimer");
                jButton1.addActionListener(this);
		        paninfo.add(jButton1);
				add(paninfo,BorderLayout.NORTH);					

		        	Object[][] donnees =getEmployeeDetails() ;
				 
						String[] entetes = {"CIN", "Code_permis", "Nom", "Prenom", "Age","Adresse","Code Postal","Email","Numéro_tel"};
				 
						JTable tableau = new JTable(donnees, entetes);
				        tableau.setBackground(Color.white);
				        tableau.setSize(900,900);
						p.add(new JScrollPane(tableau), BorderLayout.SOUTH);
						add(p,BorderLayout.SOUTH);	
						for(int i=0;i<9;i++) {
						 tableau.getColumnModel().getColumn(i).setPreferredWidth(50);
						}
						
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						setSize(600,400);
						setVisible(true);
				 
	}
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		PreparedStatement str = null;
		Connection Con = Connect.getInstance();
		try {
		str=Con.prepareStatement("Select * from client where CIN=? ");
		str.setString(1, tcin.getText());
		k = str.executeQuery();
		
		if(!(tcin.getText().isEmpty()) && k.next()==true &&b== jButton1) {
			Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			try {
			
			String query = "DELETE from  client WHERE CIN = '"+tcin.getText()+"'";
			
				
			state.executeUpdate(query);
			
                        JOptionPane confirmation = new JOptionPane();
						confirmation.showMessageDialog(null, "Le Client a été supprimé" , "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
						
			}
		  catch (Exception ea) {
            				ea.printStackTrace();
            			}
		}
		else {
			JOptionPane confirmation = new JOptionPane();
			confirmation.showMessageDialog(null, "Vérifier si le CIN est correct" , "Mise à ajour", JOptionPane.ERROR_MESSAGE, null);
			
		}
		}
		catch (Exception ea) {
			ea.printStackTrace();
		}
	}
	
	private Object[][] getEmployeeDetails() {

		Object[][] data = null;


		final String QUERY = "Select * from client";
		
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

				data[i][j++] = rs.getString("CIN");
				data[i][j++] = rs.getString("Code_permis");
				data[i][j++] = rs.getString("Nom");
				data[i][j++] = rs.getString("Prenom");
				data[i][j++] = rs.getInt("Age");
				data[i][j++] = rs.getString("Adresse");
				data[i][j++] = rs.getInt("Code_Postal");
				data[i][j++] = rs.getString("Email");
				data[i][j++] = rs.getInt("Phone_number");

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
