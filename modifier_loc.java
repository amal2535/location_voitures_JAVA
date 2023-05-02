
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class modifier_loc extends JFrame implements ActionListener{

	private JLabel mat,num,nom,cin,date,duree,montant;
	private JTextField mattext,cintext,Mattext,CINtext,nomtext,numtext,dureetext,montanttext,dtext;

	JPanel paninfo = new JPanel( ) ;
	JPanel pain = new JPanel( ) ;
	
	JButton rechercher = new JButton("Valider");
	JButton ok = new JButton("Valider");
	JButton cancel = new JButton("CANCEL");
	Location_info li=new Location_info();
	ResultSet k;


	    public modifier_loc(String title){
			super(title);

			setLayout(new BorderLayout());
	        setContentPane(new JLabel(new ImageIcon("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\locv.jpg")));
	    	setLayout(new FlowLayout(FlowLayout.CENTER, 100,25));
			setBackground(Color.white);
		
					paninfo = new JPanel( ) ;
					paninfo. setBackground( new Color(150,185,240)) ;
					paninfo. setPreferredSize( new Dimension( 420, 370) ) ;
					
					pain = new JPanel( ) ;
					pain. setBackground( new Color(150,185,240)) ;
					pain. setPreferredSize( new Dimension( 420, 370) ) ;
					
					
					
					
					mattext  = new JTextField();
					mattext.setPreferredSize(new Dimension(150, 25));
					
					Mattext  = new JTextField();
					Mattext.setPreferredSize(new Dimension(150, 25));
				
					numtext  = new JTextField();
					numtext.setPreferredSize(new Dimension(150, 25));
					
					
					nomtext  = new JTextField();
					nomtext.setPreferredSize(new Dimension(150, 25));
					
					
					cintext  = new JTextField();
					cintext.setPreferredSize(new Dimension(150, 25));
					
					CINtext  = new JTextField();
					CINtext.setPreferredSize(new Dimension(150, 25));


					dtext  = new JTextField();
					dtext.setPreferredSize(new Dimension(150, 25));


					dureetext  = new JTextField();
					dureetext.setPreferredSize(new Dimension(150, 25));
					

					montanttext  = new JTextField();
					montanttext.setPreferredSize(new Dimension(150, 25));
			
				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Modifier vos informations Personnelles : ") ) ;
				pain.setBorder( BorderFactory. createTitledBorder( "Modifier informations Personnelles : ") ) ;
				
				cin= new JLabel( "CIN de Client : ") ;
				cin.setPreferredSize(new Dimension( 150, 25));
				pain.add(cin);
				pain.add(CINtext);
				mat= new JLabel( "Matricule du voiture : ") ;
				mat.setPreferredSize(new Dimension( 150, 25));
				pain.add(mat);
				pain.add(Mattext);
				
				mat = new JLabel( "Matricule du voiture : ") ;
				mat.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(mat);
				paninfo.add(mattext);
				cin = new JLabel("Cin du client : ");
				cin.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(cin);
				paninfo.add(cintext);
				nom = new JLabel("Nom du client : ");
				nom.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(nom);
				paninfo.add(nomtext);
				num= new JLabel("Numéro du client : ") ;
				num.setPreferredSize(new Dimension( 150, 25));
				paninfo. add(num) ;
				paninfo. add( numtext) ;
				
				date = new JLabel("Date : ");
				date.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(date);
				paninfo.add(dtext);
				duree = new JLabel("Durée prevue : ");
				duree.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(duree);
				paninfo.add(dureetext);
				montant = new JLabel("Montant : ");
				montant.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(montant);
				paninfo.add(montanttext);
				
				rechercher = new JButton();
				rechercher.setText("Valider");
				rechercher.setBackground(Color.white);
				rechercher.setPreferredSize(new Dimension( 100, 20));
				pain.add(rechercher);
				
				
				ok = new JButton();
				ok.setText("Valider");
				ok.setBackground(Color.white);
				ok.setPreferredSize(new Dimension( 100, 20));
				paninfo.add(ok);

				cancel = new JButton();
				cancel.setText("Annuler");
				cancel.setPreferredSize(new Dimension( 100, 20));
				cancel.setBackground(Color.white);
				paninfo.add(cancel);
			    add(paninfo);
			    add(pain);
        
			cancel.addActionListener( new ActionListener( ) {
					public void actionPerformed( ActionEvent arg0) {
						 setVisible(false);
					}});    
	
			ok.addActionListener(this);
			rechercher.addActionListener(this);
			paninfo.setVisible(false);
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(750,500);
			setVisible(true);
	
    	}
	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton)e.getSource();
		PreparedStatement str = null;
		Connection Con = Connect.getInstance();
		try {
		str=Con.prepareStatement("Select * from location where cin=? and matricule=? ");
		str.setString(1, CINtext.getText());
		str.setString(2, Mattext.getText());
		k = str.executeQuery();
		
		if(!(CINtext.getText().isEmpty()) && k.next()==true ) {
			pain.setVisible(false);
			paninfo.setVisible(true);
			
			/*mattext.setText(k.getString("Matricule"));
			numtext.setText(k.getString("Numéro"));
			nomtext.setText(k.getString("Nom"));
			cintext.setText(k.getString("CIN"));
			dtext.setText(k.getString("Date"));
			dureetext.setText(k.getString("Duree"));
			montanttext.setText(k.getString("Montant"));*/
			
			
		   if(b==ok) {
				try {
				li.setmat(mattext.getText());
				li.setNum(Integer.parseInt(numtext.getText()));
				li.setNom(nomtext.getText());
				li.setcin(cintext.getText());
				//li.setD();
				li.setduree(Integer.parseInt (dureetext.getText()));
				li.montant();
			}catch (exception ea)
			{
				
				 JOptionPane.showMessageDialog(null,
			                ea,
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);         
			}
			
				if(li.verifie_mat(mattext.getText())==1 && li.verifie_nom(nomtext.getText())==1 && li.verifie_num(Integer.parseInt( numtext.getText()))==1 && li.verifie_duree(Integer.parseInt ( dureetext.getText()))==1)				{
				Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					try {
					
					String query = "UPDATE location SET matricule = '"+mattext.getText()+"', numéro ='"+Integer.parseInt ( numtext.getText())+"', nom = '"+nomtext.getText()+"',  cin = '"+cintext.getText()+"',date='"+dtext.getText()+"' , duree = '"+Integer.parseInt (dureetext.getText())+"' , montant = '"+Integer.parseInt (montanttext.getText())+"' WHERE cin= '"+CINtext.getText()+"' and matricule='"+Mattext.getText()+"'";
				
					
					state.executeUpdate(query);
			
		                     
		                        JOptionPane confirmation = new JOptionPane();
								confirmation.showMessageDialog(null, "Votre location a été modifier" , "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
								
					}
				  catch (Exception ea) {
		            				ea.printStackTrace();
		            			}
					finally {
						try {
							state.close();
						}catch (Exception ea) {
            				ea.printStackTrace();
            			}
					}
					}
				else {
					JOptionPane.showMessageDialog(null,
			                "Verifier La location ",
			                "PopUp Dialog",
			                JOptionPane.ERROR_MESSAGE); 
				}
			}
			}
			else {
			JOptionPane.showMessageDialog(null,
	                "La location n'existe pas",
	                "PopUp Dialog",
	                JOptionPane.ERROR_MESSAGE); 
		}
		}
	catch (Exception ea) {
		ea.printStackTrace();
	}

}

}
