import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;


public class location extends JFrame implements ActionListener{

	private JLabel num,nom,mat,cin,montant,d,duree;
	private JTextField numtext,mattext,nomtext,cintext,dureetext,dtext,montanttext;
	private JButton b01 = new JButton();
	private JButton b02 = new JButton();
	Location_info li=new Location_info();
	int k=1;
	
	public location(){}
	public location(String title){
		super(title);
		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\loc2.jpg")));
    	setLayout(new FlowLayout(FlowLayout.CENTER, 100,25));
		setBackground(Color.white);
				JPanel paninfo = new JPanel( ) ;
				paninfo. setBackground( new Color(150,185,240)) ;
				paninfo. setPreferredSize( new Dimension( 420, 300) ) ;
				
				
				mattext  = new JTextField();
				mattext.setPreferredSize(new Dimension(150, 25));
				
			
				numtext  = new JTextField();
				numtext.setPreferredSize(new Dimension(150, 25));
				
				
				nomtext  = new JTextField();
				nomtext.setPreferredSize(new Dimension(150, 25));
				
				
				cintext  = new JTextField();
				cintext.setPreferredSize(new Dimension(150, 25));


				dtext  = new JTextField();
				dtext.setPreferredSize(new Dimension(150, 25));


				dureetext  = new JTextField();
				dureetext.setPreferredSize(new Dimension(150, 25));
				

				montanttext  = new JTextField();
				montanttext.setPreferredSize(new Dimension(150, 25));
			
			
			paninfo.setBorder( BorderFactory. createTitledBorder( "Informations de votre location : ") ) ;
			mat = new JLabel( "Matricule du voiture : ") ;
			mat.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(mat);
			paninfo.add(mattext);
			num= new JLabel("Numéro du client : ") ;
			num.setPreferredSize(new Dimension( 150, 25));
			paninfo. add(num) ;
			paninfo. add( numtext) ;
			nom = new JLabel("Nom du client : ");
			nom.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(nom);
			paninfo.add(nomtext);
			cin = new JLabel("Cin du client : ");
			cin.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(cin);
			paninfo.add(cintext);
			d = new JLabel("Date : ");
			d.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(d);
			paninfo.add(dtext);
			duree = new JLabel("Durée prevue : ");
			duree.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(duree);
			paninfo.add(dureetext);
			montant = new JLabel("Montant : ");
			montant.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(montant);
			paninfo.add(montanttext);

			b01 = new JButton();
			b01.setText("Valider");
			b01.setBackground(Color.white);
			b01.setPreferredSize(new Dimension( 100, 20));
			paninfo.add(b01);

			b02 = new JButton();
			b02.setText("Annuler");
			b02.setPreferredSize(new Dimension( 100, 20));
			b02.setBackground(Color.white);
			paninfo.add(b02);
		    add(paninfo);



			b02.addActionListener( new ActionListener( ) {
				public void actionPerformed( ActionEvent arg0) {
					 setVisible(false);
				}});

			b01.addActionListener(this);
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(600,400);
			setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(b==b01) 
				{
					try {
					li.setmat(mattext.getText());
					li.setNum(Integer.parseInt ( numtext.getText()));
					li.setNom(nomtext.getText());
					li.setcin(cintext.getText());
					li.setD(dtext.getText());
					li.setduree(Integer.parseInt ( dureetext.getText()));
					li.montant();
					}catch (Exception ea)
				{
					k=0;
					 JOptionPane.showMessageDialog(null,
								ea,
								"PopUp Dialog",
								JOptionPane.INFORMATION_MESSAGE);         
				}
					
				if(li.verifie_mat(mattext.getText())==1 && li.verifie_nom(nomtext.getText())==1 && li.verifie_num(Integer.parseInt( numtext.getText()))==1 && li.verifie_duree(Integer.parseInt ( dureetext.getText()))==1)
				{
					try {
						Statement state = Connect.getInstance().createStatement();
							String requete = "INSERT INTO location values('"+mattext.getText()+"','"+cintext.getText()+"','"+Integer.parseInt ( numtext.getText())+"', '"+nomtext.getText()+"', '"+dtext.getText()+"' ,'"+Integer.parseInt (dureetext.getText())+"', '"+Integer.parseInt (montanttext.getText())+"')" ;
								String requete1="Update voiture set etat = reservee where mattricule='"+mattext.getText()+"'"; 
								String requete2="Update client set etat = sous_contrat where cin='"+cintext.getText()+"'"; 

								int resultat = state.executeUpdate(requete);
								state.executeUpdate(requete1);
								state.executeUpdate(requete2);
								 
								 JOptionPane confirmation = new JOptionPane();
									confirmation.showMessageDialog(null, "votre location  a été ajouter ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
			
									
						
						 state.close();
					} catch (SQLException ea) {
						// TODO Auto-generated catch block
						ea.printStackTrace();
					}
				 catch (Exception ea) {
					ea.printStackTrace();
				}
					}
				else {
					JOptionPane confirmation = new JOptionPane();
					confirmation.showMessageDialog(null, "Vérifier votre location ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);

				}
					
			}
			}
			
}
