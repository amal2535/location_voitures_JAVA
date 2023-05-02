import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Gra_Client extends JFrame implements ActionListener{
	
	
	
private JLabel age,adresse,nom, prenom,cin,code,tel,email,permis;
private JTextField tage,tadresse,tnom, tprenom,tcin,tcode,ttel,tmail,tpermis;

	
JButton ok = new JButton("OK");
JButton cancel = new JButton("CANCEL");
Clients a=new Clients();
int k=1;

    public Gra_Client(String title){
		super(title);

		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\b.jpg")));
    	setLayout(new FlowLayout(FlowLayout.CENTER, 100,25));
		setBackground(Color.white);
	
				JPanel paninfo = new JPanel( ) ;
				paninfo. setBackground( new Color(150,185,240)) ;
				paninfo. setPreferredSize( new Dimension( 420, 370) ) ;
				
				
				tcin  = new JTextField();
				tcin.setPreferredSize(new Dimension(150, 25));
				
				tpermis  = new JTextField();
				tpermis.setPreferredSize(new Dimension(150, 25));
			
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
			
			paninfo.setBorder( BorderFactory. createTitledBorder( "Votre informations Presonnalles : ") ) ;
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
		    


			cancel.addActionListener( new ActionListener( ) {
				public void actionPerformed( ActionEvent arg0) {
					 setVisible(false);
				}});
			ok.addActionListener(this);
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(750,500);
			setVisible(true);
	
    	}
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
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
				k=0;
				 JOptionPane.showMessageDialog(null,
			                ea,
			                "PopUp Dialog",
			                JOptionPane.INFORMATION_MESSAGE);         
			}
			
		if(a.verifie_cin(tcin.getText())==1 &&a.verifie_permis(tpermis.getText())==1&& a.verifie_nom(tnom.getText())==1 && a.verifie_age(Integer.parseInt( tage.getText()))==1  && a.verifie_email(tmail.getText())==1  && a.verifie_phone(Integer.parseInt ( ttel.getText()))==1 && tadresse.getText().length()!=0 && a.verifie_code(Integer.parseInt ( tcode.getText()))==1)
		{
			try {
			Statement state = Connect.getInstance()
					.createStatement();
				String requete = "INSERT INTO client values('"+tcin.getText()+"', '"+tpermis.getText()+"', '"+tnom.getText()+"', '"+tprenom.getText()+"', '"+Integer.parseInt ( tage.getText())+"', '"+tadresse.getText()+"', '"+Integer.parseInt (tcode.getText())+"', '"+tmail.getText()+"', '"+Integer.parseInt (ttel.getText())+"', '"+"libre"+"')" ;
					 int resultat = state.executeUpdate(requete);
					 
					 JOptionPane confirmation = new JOptionPane();
						confirmation.showMessageDialog(null, "Le client a été ajouter ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);

						
			
			 state.close();
		} catch (SQLException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}
	 catch (Exception ea) {
		ea.printStackTrace();
	}
		}
		
}
}
}
		

