import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class modifier_voiture extends JFrame implements ActionListener,ItemListener{

	private JLabel mat,mar,clr,d,prix;
	private JTextField mattext,dtext,prixtext,tMattricule;
	Choice choix1=new Choice();
	Choice choix2=new Choice();
	String marque;
	String coleur;
	JPanel paninfo = new JPanel( ) ;
	JPanel pain = new JPanel( ) ;
	
	JButton rechercher = new JButton("Valider");
	JButton ok = new JButton("Valider");
	JButton cancel = new JButton("CANCEL");
	Voiture v=new Voiture();
	ResultSet k;


	    public modifier_voiture(String title){
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
					
					
					mattext  = new JTextField();
					mattext.setPreferredSize(new Dimension(150, 25));

					
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
					
					tMattricule  = new JTextField();
					tMattricule.setPreferredSize(new Dimension(150, 25));

				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Modifier les informations d'une voiture : ") ) ;
				pain.setBorder( BorderFactory. createTitledBorder( "Modifier les informations d'une voiture : ") ) ;
				
				mat= new JLabel( "Matricule de Voiture : ") ;
				mat.setPreferredSize(new Dimension( 150, 25));
				pain.add(mat);
				pain.add(tMattricule);
				
				rechercher = new JButton();
				rechercher.setText("Valider");
				rechercher.setBackground(Color.white);
				rechercher.setPreferredSize(new Dimension( 100, 20));
				pain.add(rechercher);
				
				mat = new JLabel( "Matricule de Client : ") ;
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
		str=Con.prepareStatement("Select * from voiture where mattricule=? ");
		str.setString(1, tMattricule.getText());
		k = str.executeQuery();
		
		if(!(tMattricule.getText().isEmpty()) && k.next()==true ) {
			pain.setVisible(false);
			paninfo.setVisible(true);
			
				
			if(b==ok) {
				try {
					v.setmat(mattext.getText());
					v.setd(dtext.getText());
					v.setprix(Float.parseFloat (prixtext.getText()));
					}catch (Exception ea)
				{
					 JOptionPane.showMessageDialog(null,
								ea,
								"PopUp Dialog",
								JOptionPane.INFORMATION_MESSAGE);         
				}
			
			if(v.verifie_mat(mattext.getText())==1)
				{
				Statement state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					try {
					
					String query = "UPDATE voiture SET mattricule = '"+mattext.getText()+"', marque = '"+marque+"', coleur = '"+coleur+"', date_dachat= '"+dtext.getText()+"', prix = '"+Integer.parseInt ( prixtext.getText())+"' WHERE mattricule = '"+tMattricule.getText()+"'";
					
						
					state.executeUpdate(query);
			
		                     
		                        JOptionPane confirmation = new JOptionPane();
								confirmation.showMessageDialog(null, "La voiture a été modifiée" , "Mise à ajour", JOptionPane.INFORMATION_MESSAGE, null);
								
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
	                "La voiture n'existe pas",
	                "PopUp Dialog",
	                JOptionPane.INFORMATION_MESSAGE); 
		}
		}
	catch (Exception ea) {
		ea.printStackTrace();
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

