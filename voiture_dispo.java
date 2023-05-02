import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class voiture_dispo extends JFrame implements ActionListener{
	
	Container container;
    JTable table;
    JScrollPane scrollPane;
    
	public voiture_dispo(String title) {
		super(title);
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		String[] entetes = {"matricule", "marque", "couleur", "date d'achat", "prix"};
		Object[][] donnees =getEmployeeDetails() ;
		JTable tableau = new JTable(donnees, entetes);
		tableau.setBackground(Color.white);
        tableau.setSize(500,500);
		scrollPane = new JScrollPane(tableau);
        container.add(scrollPane);
        

        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(500,400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Object[][] getEmployeeDetails() {

		Object[][] data = null;


		final String QUERY = "Select * from voiture where etat='"+"disponible"+"'";
		
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