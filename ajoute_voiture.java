import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Statement;


public class ajoute_voiture extends JFrame implements ActionListener , ItemListener{

	private JLabel mat,mar,clr,d,prix;
	private JTextField mattext,martext,clrtext,dtext,prixtext;
	private JButton b01 = new JButton();
	private JButton b02 = new JButton();
	Voiture v=new Voiture();
	Choice choix1=new Choice();
	Choice choix2=new Choice();
	String marque;
	String coleur;
	int k=1;
	
	
	public ajoute_voiture(){}
	public ajoute_voiture(String title){
		super(title);
		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\v.jpg.jpg")));
    	setLayout(new FlowLayout(FlowLayout.CENTER, 75,25));
		setBackground(Color.white);
				JPanel paninfo = new JPanel( ) ;
				paninfo. setBackground( new Color(150,185,240)) ;
				
				
				paninfo. setPreferredSize( new Dimension( 420, 300) ) ;
				
				mattext  = new JTextField();
				mattext.setPreferredSize(new Dimension(150, 25));

				
				clrtext  = new JTextField();
				clrtext.setPreferredSize(new Dimension(150, 25));
				
				
				dtext  = new JTextField();
				dtext.setPreferredSize(new Dimension(150, 25));
				
				choix1.setPreferredSize(new Dimension(150, 25));
				choix2.setPreferredSize(new Dimension(150, 25));

				prixtext  = new JTextField();
				prixtext.setPreferredSize(new Dimension(150, 25));
				
				choix1.addItemListener(this);
				choix1.add("BMW");
				choix1.add("Bugatti");
				choix1.add("Cupra");
				choix1.add("Ford");
				choix1.add("Honda");
				choix1.add("Hyundai");
				choix1.add("Kia");
				choix1.add("Tesla");
				choix1.add("Jaguar");
				
				choix2.addItemListener(this);
				choix2.add("Noir");
				choix2.add("Gray");
				choix2.add("Cyan");
				choix2.add("Rouge");
				choix2.add("Jaune");
				choix2.add("Vert");
				choix2.add("Bleu");
				choix2.add("Blanc");

			
			
			paninfo.setBorder( BorderFactory. createTitledBorder( "Informations de votre voiture : ") ) ;
			mat = new JLabel( "Matricule du voiture : ") ;
			mat.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(mat);
			paninfo.add(mattext);
			mar= new JLabel("Marque du voiture : ") ;
			mar.setPreferredSize(new Dimension( 150, 25));
			paninfo. add(mar) ;
			paninfo. add(choix1) ;
			clr = new JLabel("Couleur de voiture : ");
			clr.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(clr);
			paninfo.add(choix2);
			d = new JLabel("Date d'achat: ");
			d.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(d);
			paninfo.add(dtext);
			prix = new JLabel("Prix : ");
			prix.setPreferredSize(new Dimension( 150, 25));
			paninfo.add(prix);
			paninfo.add(prixtext);

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
			setSize(750,500);
			setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(b==b01) 
				{
					try {
					v.setmat(mattext.getText());
					v.setd(dtext.getText());
					v.setprix(Float.parseFloat (prixtext.getText()));
					}catch (Exception ea)
				{
					k=0;
					 JOptionPane.showMessageDialog(null,
								ea,
								"PopUp Dialog",
								JOptionPane.INFORMATION_MESSAGE);         
				}
					
				if(v.verifie_mat(mattext.getText())==1 )
				{
					try {
						Statement state = Connect.getInstance().createStatement();
							String requete = "INSERT INTO voiture values('"+mattext.getText()+"','"+marque+"', '"+coleur+"', '"+dtext.getText()+"' ,'"+Float.parseFloat (prixtext.getText())+"' ,'"+ "disponible"+"')" ;
								 int resultat = state.executeUpdate(requete);
								 
								 JOptionPane confirmation = new JOptionPane();
									confirmation.showMessageDialog(null, "votre voiture  a été ajoutée ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
			
									
						
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
					confirmation.showMessageDialog(null, "Vérifier votre voiture ", "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);

				}
					
			}
			}
			
public void itemStateChanged(ItemEvent e) {
	Object ob=(Object)e.getSource();
	if(ob==choix1){
		if(choix1.getSelectedItem().toString().equals("Rouge"))
			coleur="Rouge";
		else if(choix1.getSelectedItem().toString().equals("Noir"))
			coleur="Noir";
		else if(choix1.getSelectedItem().toString().equals("Blanc"))
			coleur="Blanc";
		else if(choix1.getSelectedItem().toString().equals("Jaune"))
			coleur="Jaune";
		else if(choix1.getSelectedItem().toString().equals("Vert"))
			coleur="Vert";
		else if(choix1.getSelectedItem().toString().equals("Blue"))
			coleur="Blue";
		else if(choix1.getSelectedItem().toString().equals("Cyan"))
			coleur="Gray";
		else	coleur="cyan";
			
		}
	else if(ob==choix2) {
		if(choix2.getSelectedItem().toString().equals("BMW"))
			marque="BMW";
		else if(choix2.getSelectedItem().toString().equals("Bugatti"))
			marque="Bugatti";
		else if(choix2.getSelectedItem().toString().equals("Cupra"))
			marque="Cupra";
		else if(choix2.getSelectedItem().toString().equals("Ford"))
			marque="Ford";
		else if(choix2.getSelectedItem().toString().equals("Honda"))
			marque="Honda";
		else if(choix2.getSelectedItem().toString().equals("Hyundai"))
			marque="Hyundai";
		else if(choix2.getSelectedItem().toString().equals("Kia"))
			marque="Kia";
		else if(choix2.getSelectedItem().toString().equals("Tesla"))
			marque="Tesla";
		else 
			marque="Jaguar";
	}
	
}
}

