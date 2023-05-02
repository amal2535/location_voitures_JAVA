import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class annuler_contrat {



	public annuler_contrat() throws SQLException {
	
		Statement state = Connect.getInstance()
		.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY
		);
		ResultSet res = state.executeQuery("SELECT id,nom,prenom,statut FROM facture WHERE statut='sortie' OR statut='attente'");
		
	
	

		res.last();
		int rowCount = res.getRow();
		System.out.println(rowCount);

		res.beforeFirst();
		Object[] data = new Object[rowCount];
	
		int i=0;
		while(res.next()){
			
				data[i] = res.getString("id")+" - "+res.getString("nom")+" - "+res.getString("prenom")+" - "+res.getString("statut");
	i++;
		
		}
		
		
		

		

		
		
	JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	jop.setPreferredSize(new Dimension(500, 200));
	ImageIcon img = new ImageIcon("images/annule.jpg");

	String id = (String)jop.showInputDialog(null, 
									"Veuillez choisir le contrat a annuler !",
									"Annulation d'un contrat !",
									JOptionPane.QUESTION_MESSAGE,
									img,
									 data,
									 null);
	try{ 
	String str[] = id.split("\\ - ");
		int idu = Integer.parseInt(str[0]);
	
		
		if(id !=null) {
	
	jop2 = new JOptionPane();			
	int option = jop.showConfirmDialog(null, "�tes-vous s�r de vouloir annuler le contrat avec le client "+str[1]+" "+str[2]+" ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	
	if(option == JOptionPane.OK_OPTION)
	{
	//PreparedStatement prepare = Connect.getInstance().prepareStatement("UPDATE professeur set prof_prenom = ? WHERE prof_nom = 'MAMOU'");
   

	res = state.executeQuery("SELECT * FROM facture WHERE id = '"+idu+"'");
	

	
	res.first();
	
	int ido = res.getInt("id");
	
	try{
	String query = "DELETE FROM facture WHERE id = '"+ido+"'";
	res = state.executeQuery(query);
	}
	catch(Exception e ){
	 JOptionPane confirmation = new JOptionPane();
		confirmation.showMessageDialog(null, "Le contrat a �t� annuler ", "Annulation contrat", JOptionPane.INFORMATION_MESSAGE, null);

	}
	}}
	}catch(NullPointerException e) {}
	res.close();
	state.close();
	
	
	
	
	

	}}
