import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contrat extends JFrame {
	private JLabel num,nom,pnom,cin,mar,prix,mat,du,au,rd,aud,aur,cb,cheq,tc;
	private JTextArea textarea;
	private JTextField numtext,mattext,nomtext,cintext,prenomtext,martext,prixtext,dutext,autext,rtext,cbtext,cheqtext,tctext;
	JButton b =new JButton("Valider");
	public Contrat(String title){
		super(title);
		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\v.jpg.jpg")));
    	setLayout(new FlowLayout(FlowLayout.CENTER, 100,25));
		setBackground(Color.white);
		
				JPanel paninfo = new JPanel( ) ;
				paninfo. setBackground( new Color(4,139,154)) ;
				paninfo. setPreferredSize( new Dimension( 300, 300) ) ;
				nomtext  = new JTextField();
				nomtext.setPreferredSize(new Dimension(150, 25));
				

				prenomtext  = new JTextField();
				prenomtext.setPreferredSize(new Dimension(150, 25));
				
			
				numtext  = new JTextField();
				numtext.setPreferredSize(new Dimension(150, 25));
				
			
				cintext  = new JTextField();
				cintext.setPreferredSize(new Dimension(150, 25));
				
				paninfo.setBorder( BorderFactory. createTitledBorder( "Conducteur locataire (Le client) ") ) ;
				nom = new JLabel("Nom : ");
				nom.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(nom);
				paninfo.add(nomtext);
				pnom = new JLabel("Prénom : ");
				pnom.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(pnom);
				paninfo.add(prenomtext);
				num= new JLabel("Numéro de permis: ") ;
				num.setPreferredSize(new Dimension( 150, 25));
				paninfo. add(num) ;
				paninfo. add( numtext) ;
				cin = new JLabel("Cin: ");
				cin.setPreferredSize(new Dimension( 150, 25));
				paninfo.add(cin);
				paninfo.add(cintext);
				
				add(paninfo);
				
				
				
				
				JPanel panv = new JPanel( ) ;
				panv. setBackground( new Color(4,139,154)) ;
				panv. setPreferredSize( new Dimension( 300, 300) ) ;
				
				mattext  = new JTextField();
				mattext.setPreferredSize(new Dimension(150, 25));
				

				martext  = new JTextField();
				martext.setPreferredSize(new Dimension(150, 25));
				
			
				prixtext  = new JTextField();
				prixtext.setPreferredSize(new Dimension(150, 25));
				
				panv.setBorder( BorderFactory. createTitledBorder( "VEHICULE" )) ;
				mat = new JLabel("Matricule: ");
				mat.setPreferredSize(new Dimension( 150, 25));
				panv.add(mat);
				panv.add(mattext);
				mar = new JLabel("Marque : ");
				mar.setPreferredSize(new Dimension( 150, 25));
				panv.add(mar);
				panv.add(martext);
				prix= new JLabel("Prix : ") ;
				prix.setPreferredSize(new Dimension( 150, 25));
				panv. add(prix) ;
				panv. add(prixtext) ;
				
				add(panv);
				
				JPanel panc = new JPanel( ) ;
				panc. setBackground( new Color(4,139,154)) ;
				panc. setPreferredSize( new Dimension( 300, 300) ) ;
				
				
				dutext  = new JTextField();
				dutext.setPreferredSize(new Dimension(150, 25));
				

				autext  = new JTextField();
				autext.setPreferredSize(new Dimension(150, 25));
				
				
				rtext  = new JTextField();
				rtext.setPreferredSize(new Dimension(150, 25));
				
				
				panc.setBorder( BorderFactory. createTitledBorder( "AU DEPART *** AU RETOUR" )) ;
				
				du = new JLabel("Du: ");
				du.setPreferredSize(new Dimension( 150, 25));
				panc.add(du);
				panc.add(dutext);
				au = new JLabel("Au : ");
				au.setPreferredSize(new Dimension( 150, 25));
				panc.add(au);
				panc.add(autext);
				rd = new JLabel("Rendu le : ");
				rd.setPreferredSize(new Dimension( 150, 25));
				panc.add(rd);
				panc.add(rtext);
				add(panc);
				
				
				JPanel panl = new JPanel( ) ;
				panl. setBackground( new Color(4,139,154)) ;
				panl. setPreferredSize( new Dimension( 300, 300) ) ;
				

				cbtext  = new JTextField();
				cbtext.setPreferredSize(new Dimension(150, 25));
				

				cheqtext  = new JTextField();
				cheqtext.setPreferredSize(new Dimension(150, 25));
				
				
				tctext  = new JTextField();
			    tctext.setPreferredSize(new Dimension(150, 25));
				
				
				panl.setBorder( BorderFactory. createTitledBorder( "CAUTION (VALEUR DE LA FRANCHISSE)" )) ;
				
				cb = new JLabel("CB(encaissé): ");
				cb.setPreferredSize(new Dimension( 150, 25));
				panl.add(cb);
				panl.add(cbtext);
				cheq = new JLabel("Chèque : ");
				cheq.setPreferredSize(new Dimension( 150, 25));
				panl.add(cheq);
				panl.add(cheqtext);
				tc = new JLabel("Total caution : ");
				tc.setPreferredSize(new Dimension( 150, 25));
				panl.add(tc);
				panl.add(tctext);
				
				
			    textarea = new JTextArea("LA FRANCHISSE EST EGALE AU MONTANT DE LA CAUTION :\n"
						+ " En cas de vol ou accident responsable la franchisse reste acquise au louer. Le client déclare louer ,sous son entiere responsabilité, le véhicule et n'est pas autorisé à le preter. \n"
						+ "Le deux roues est assuré TOUS RISQUES.Le client utilisera le véhicule loué avec soin , \n"
						+ "réglera tous frais, amendes et dépenses pour toutes infractions à la circulation ,\n"
						+ "au stationnement,etc...Le client n'est pas autorisé à effectuer de répartition sur le véhicule\n"
						+ " à l'exception des frais consécutifs à:crevaison, pannes d'électricité.");
			    JScrollPane scrollPane = new  JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane. HORIZONTAL_SCROLLBAR_ALWAYS);
			    textarea.setPreferredSize(new Dimension(260, 78));
				panl.add(scrollPane);
				
				textarea.setColumns(20);
				
				
				
				add(panl);
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				pack();
				setVisible(true);
				setSize(900,900);
				
				
				
				
				
				

	}

}