import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class liste_loc extends JFrame implements ActionListener{
	
	Container container;
    JTable table;
    JScrollPane scrollPane;
    
	public liste_loc(String title) {
		super(title);
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		String[] entetes = {"matricule","cin","nom","numéro_permis","date","duree","montant"};
		Object[][] donnees =getEmployeeDetails() ;
		JTable tableau = new JTable(donnees, entetes);
		tableau.setBackground(Color.white);
        tableau.setSize(500,500);
		scrollPane = new JScrollPane(tableau);
        container.add(scrollPane);
        
			 tableau.getColumnModel().getColumn(1).setPreferredWidth(100);
			 tableau.getColumnModel().getColumn(4).setPreferredWidth(100);
			 tableau.getColumnModel().getColumn(3).setPreferredWidth(100);
			 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setSize(500,400);
				setVisible(true);
				
			 
       
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Object[][] getEmployeeDetails() {

		Object[][] data = null;


		final String QUERY = "Select * from location";
		
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

				data[i][j++] = rs.getString("matricule");
				data[i][j++] = rs.getInt("cin");
				data[i][j++] = rs.getString("nom");
				data[i][j++] = rs.getString("numéro");
				data[i][j++] = rs.getString("date");
				data[i][j++] = rs.getInt("duree");
				data[i][j++] = rs.getDouble("montant");

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
