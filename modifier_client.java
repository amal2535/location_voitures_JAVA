import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class modifier_client extends JFrame implements ActionListener{

	private JLabel age,adresse,nom, prenom,cin,code,tel,email,CIN,permis;
	private JTextField tage,tadresse,tnom, tprenom,tcin,tcode,ttel,tmail,tCIN,tpermis;

	JPanel paninfo = new JPanel( ) ;
	JPanel pain = new JPanel( ) ;
	
	JButton rechercher = new JButton("Valider");
	JButton ok = new JButton("Valider");
	JButton cancel = new JButton("CANCEL");
	Clients a=new Clients();
	ResultSet k;


	    public modifier_client(String title){
			super(title);

			setLayout(new BorderLayout());
	        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\b.jpg")));
	    	setLayout(new FlowLayout(FlowLayout.CENTER, 100,25));
			setBackground(Color.white);
		
					paninfo = new JPanel( ) ;
					paninfo. setBackground(new Color(150,185,240)) ;
					paninfo. setPreferredSize( new Dimension( 420, 370) ) ;
					
					pain = new JPanel( ) ;
					pain. setBackground( new Color(150,185,240)) ;
					pain. setPreferredSize( new Dimension( 420, 370) ) ;
					
					
					tcin  = new JTextField();
					tcin.setPreferredSize(new Dimension(150, 25));
					
					tpermis  = new JTextField();
					tpermis.setPreferredSize(new Dimension(150, 25));
					
					tCIN  = new JTextField();
					tCIN .setPreferredSize(new Dimension(150, 25));
					
				
					tnom  = new JTextField();
					tnom.setPreferredSize(new Dimension(150, 25));
					
					
					tprenom  = new JTextField();
					tprenom.setPreferredSize(new Dimension(150, 25));
					
					
					tage  = new JTextField();
					tage.setPreferredSize(new Dimension(150, 25));

					tadresse  = new JTextField();
					tadresse.setPreferredSize(new Dimension(150, 25));

					tcode  = new JTextField();
					tcode.setPreferredSize(new Dimension(150, 25));
					
					tmail  = new JTextField();
					tmail.setPreferredSize(new Dimension(150, 25));
					
					ttel  = new JTextField();
					ttel.setPreferredSize(new Dimension(150, 25));
				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Modifier votre informations Presonnalles : ") ) ;
				pain.setBorder( BorderFactory. createTitledBorder( "Modifier informations Presonnalles : ") ) ;
				
				CIN= new JLabel( "CIN de Client : ") ;
				CIN.setPreferredSize(new Dimension( 150, 25));
				pain.add(CIN);
				pain.add(tCIN);
				
				rechercher = new JButton();
				rechercher.setText("Valider");
				rechercher.setBackground(Color.white);
				rechercher.setPreferredSize(new Dimension( 100, 20));
				pain.add(rechercher);
				
				cin = new JLabel( "CIN de Client : ") ;
				cin.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(cin);
				paninfo.add(tcin);
				permis = new JLabel( "Code permis de Client : ") ;
				permis.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(permis);
				paninfo.add(tpermis);
				nom= new JLabel("Nom du client : ") ;
				nom.setPreferredSize(new Dimension( 150, 25));
				paninfo. add(nom) ;
				paninfo. add( tnom) ;
				prenom = new JLabel("Prenom du client : ");
				prenom.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(prenom);
				paninfo.add(tprenom);
				age = new JLabel("Age du client : ");
				age.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(age);
				paninfo.add(tage);
				adresse = new JLabel("Adresse : ");
				adresse.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(adresse);
				paninfo.add(tadresse);
				code = new JLabel("Code Postale : ");
				code.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(code);
				paninfo.add(tcode);
				email = new JLabel("Email de client : ");
				email.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(email);
				paninfo.add(tmail);
				tel = new JLabel("Numéro de téléphone : ");
				tel.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(tel);
				paninfo.add(ttel);
				
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
		str=Con.prepareStatement("Select * from client where CIN=? ");
		str.setString(1, tCIN.getText());
		k = str.executeQuery();
		
		if(!(tCIN.getText().isEmpty()) && k.next()==true ) {
			pain.setVisible(false);
			paninfo.setVisible(true);
			
			/*tcin.setText(k.getString("CIN"));
			tpermis.setText(k.getString("Code_permis"));
			tnom.setText(k.getString("Nom"));
			tprenom.setText(k.getString("Prenom"));
			tage.setText(k.getString("Age"));
			tadresse.setText(k.getString("Adresse"));
			tmail.setText(k.getString("Email"));
			tcode.setText(k.getString("Code_Postale"));
			ttel.setText(k.getString("Phone_Number"));*/
			
			
			if(b==ok) {
				try {
				a.set_cin(tcin.getText());
				a.set_permis(tpermis.getText());
				a.set_nom(tnom.getText());
				a.set_prenom(tprenom.getText());
				a.set_age(Integer.parseInt ( tage.getText()));
				a.set_email(tmail.getText());
				a.set_phone(Integer.parseInt ( ttel.getText()));
				a.set_code(Integer.parseInt (tcode.getText()));
			}catch (exception ea)
			{
				
				 JOptionPane.showMessageDialog(null,
			                ea,
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);         
			}
			
			if(a.verifie_cin(tcin.getText())==1 && a.verifie_permis(tpermis.getText())==1 && a.verifie_nom(tnom.getText())==1 && a.verifie_age(Integer.parseInt( tage.getText()))==1  && a.verifie_email(tmail.getText())==1  && a.verifie_phone(Integer.parseInt ( ttel.getText()))==1 && tadresse.getText().length()!=0 && a.verifie_code(Integer.parseInt ( tcode.getText()))==1)
				{
				Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					try {
					
					String query = "UPDATE client SET CIN = '"+tcin.getText()+"', Code_permis = '"+tpermis.getText()+"', Nom = '"+tnom.getText()+"', Prenom = '"+tprenom.getText()+"', Age = '"+Integer.parseInt ( tage.getText())+"', Adresse = '"+tadresse.getText()+"', Code_Postal = '"+Integer.parseInt (tcode.getText())+"', Email = '"+tmail.getText()+"', Phone_number = '"+Integer.parseInt (ttel.getText())+"'WHERE CIN = '"+tCIN.getText()+"'";
					
						
					state.executeUpdate(query);
			
		                     
		                        JOptionPane confirmation = new JOptionPane();
								confirmation.showMessageDialog(null, "Le Client a été modifier" , "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
								
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
			}
			}
			else {
			JOptionPane.showMessageDialog(null,
	                "Le client n'existe pas",
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE); 
		}
		}
	catch (Exception ea) {
		ea.printStackTrace();
	}

}

}

