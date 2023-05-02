
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.Border;


public class Accueil extends JFrame {


	private static final JMenuItem Bon_de_reservation = null;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu edition = new JMenu("Edition");
	private JMenu location = new JMenu("Vehicule");
	private JMenu clients = new JMenu("Clients");
	private JMenu reservation = new JMenu("Réservation");
	private JMenu facture = new JMenu("Facture");
	private JMenu contrat = new JMenu("Contrat");
	private JMenu aide = new JMenu("Aide");
	private JMenu config = new JMenu("Accueil");
	private JMenuItem serveur = new JMenuItem("Envoyer message au serveur");
	private JMenuItem factura = new JMenuItem("Facture");
	private JMenuItem aide_support = new JMenuItem("Aide et Support");
	private static JMenuItem liste_poste = new JMenuItem("Liste des membres CSL connectés");
	private JMenuItem liste_tout = new JMenuItem("Liste du groupe CSL");
	private JMenuItem liste_client = new JMenuItem("Liste de tout les clients");
	private JMenuItem liste_client_attente = new JMenuItem("Liste des clients en attente");
	private JMenuItem liste_client_cours = new JMenuItem("Liste des clients sous contrat");
	static JMenuItem liste_voiture_libre = new JMenuItem("Liste des vehicules disponible");
	static JMenuItem liste_voiture_sorties = new JMenuItem("Liste des vehicule sorties");
	static JMenuItem liste_voiture_reserve = new JMenuItem("Liste des vehicule réservés");
	private JMenuItem liste_voiture_retard = new JMenuItem("Liste des vehicule en retard");
	private JMenuItem tout_voiture = new JMenuItem("Liste de toutes les voitures");
	private JMenuItem bon_de_reservation = new JMenuItem("Bon de reservation");
	private JMenuItem liste_des_reservation = new JMenuItem("Liste des réservation");
	private JMenuItem nouvelle_facture = new JMenuItem("Nouvelle Facture");
	private JMenuItem annuler_contrat = new JMenuItem("Annuler un contrat");
	private JMenuItem contrat_listes = new JMenuItem("Liste des contrats");
	private JMenuItem facture_listes = new JMenuItem("Liste des factures");
	private JMenuItem contrat_de_location = new JMenuItem("Contrat de location");
	private JMenuItem fermer = new JMenuItem("Fermer");
	private JMenu maj_voiture = new JMenu("Mise à jour");
	private JMenu maj_client= new JMenu("Mise à jour");
	private JMenuItem ajouter_vehicule = new JMenuItem("Créer");
	private JMenuItem modifier_vehicule = new JMenuItem("Modifier");
	private JMenuItem supprimer_vehicule = new JMenuItem("Supprimer");
	private JMenuItem ajouter_client = new JMenuItem("Créer");
	private JMenuItem modifier_client = new JMenuItem("Modifier");
	private JMenuItem supprimer_client = new JMenuItem("Supprimer");
	public static String adr;
	final Background contient= new Background();
	final Background2 contient2= new Background2();
	private static JSplitPane split;
	private static JPanel menu = new JPanel();
	private JTabbedPane p;
	
	private static boolean ok =false, gauche=true, droite=false,haut=false,bas=false;
	private static String rowCount,rowCount2,rowCount3,rowCount4,rowCount5,rowCount6;
	private  int row1,row2,row3,row4,row6;
	private JTextField text3,text1,text2,text4,text6;
	public static int onglet = JTabbedPane.LEFT;
	
	public Accueil(boolean ok){
		this.ok=ok;
		
	}
	public Accueil(){
		
		this.setTitle("Auto Location ");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	
		fermer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}				
		});

		
	
		// NOUVELLE FACTURE
		nouvelle_facture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				facture f= new facture("Facture de client");
				
			}
			
		});
		/*
		icone_facture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				facture();
				
			}
			
		});
		
		
	*/
		contrat_de_location.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				Contrat c =new Contrat("Contrat d'une location");
			
			
			}
			
		});
		/*
		icone_contrat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				
				
				try {

					marques();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			
			}
			
		});*/
		annuler_contrat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				//annuler_contra();
				
			}

			
			
		});
		
		contrat_listes.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
					//contrat_list(requete);
			}
			
		});
		
		liste_des_reservation.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				liste_loc l= new liste_loc("");
			}
			
		});
		/*
		connecte.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='sortie' ORDER BY id ";
				contrat_list(requete);
			}
			
		});
		
		*/facture1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				//facture_list(requete);
			}
			
		});
		
		
		bon_de_reservation.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				location az=new location("");
			}
			
		});
		/*
		icone_reserva.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						Reserva l = new Reserva(null, "Réservation : Informations Véhicule", true);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			
		 		} catch (MalformedURLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (NotBoundException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
			}
			
		});
		
		reservee.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String requete = "SELECT id,nom,prenom,nss,marque,modele FROM facture WHERE statut='attente' ORDER BY id ";
				reservation_list(requete);
			}
			
		});
		
		sortie1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
		String requete = "SELECT marque,modele FROM vehicule WHERE statut = 'sortie'  ORDER BY marque";
		vehicule(requete);
		
	}
			
		});*/
		facture_listes.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			//facture_list(requete);
			}
			
		});
		
		liste_client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				liste_client l=new liste_client("Liste de clients");
			}
			
		});
		
		ajouter_client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Gra_Client l=new Gra_Client("Ajoutes d'un client");
			}
		
		});
		
		modifier_client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				modifier_client l=new modifier_client("modifier un client");
			}
		
		});
		supprimer_client.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				Supprimer l=new Supprimer("Supprimer un client");
			}
		
		});
		liste_client_cours.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				client_libre lads=new client_libre("");
			}
			
		});
		liste_client_attente.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				client_sous_contrat lads=new client_sous_contrat("");
			}
			
		});
		// LISTE VOITURES DISPONIBLE
		liste_voiture_libre.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				voiture_dispo dis=new voiture_dispo("Voitures disponible");
			}
			
		});
		
		
	
		liste_voiture_reserve.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				voiture_loyee dis=new voiture_loyee("Voitures loyée");
			}
			
		});
		
		tout_voiture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				liste_voiture v= new liste_voiture("");
			}
			
		});
		
		
		config.setBackground(Color.white);
		location.setBackground(Color.white);
		clients.setBackground(Color.white);
		reservation.setBackground(Color.white);
		contrat.setBackground(Color.white);
		facture.setBackground(Color.white);
		liste_voiture_libre.setBackground(Color.white);
		config.setMnemonic('P');
		menuBar.add(config);
		
		location.setMnemonic('V');
		menuBar.add(location);
		    	
		clients.setMnemonic('l');
		menuBar.add(clients);
		reservation.setMnemonic('R');
		menuBar.add(reservation);
		
		
		
		contrat.setMnemonic('C');
		menuBar.add(contrat);
		facture.setMnemonic('F');
		menuBar.add(facture);
		
		
	
		this.setVisible(true);
			
	
			// /////////////////////////////////////////////////////
		
		
		
		
		
		
	
		this.location.add(liste_voiture_libre);
		this.location.add(liste_voiture_sorties);
		this.location.add(liste_voiture_reserve);
		this.location.add(tout_voiture);
		this.location.addSeparator();
		this.location.add(maj_voiture);
	
		liste_voiture_sorties.setBackground(Color.white);
		liste_voiture_reserve.setBackground(Color.white);
		tout_voiture.setBackground(Color.white);
		maj_voiture.setBackground(Color.white);
		
		
		liste_voiture_libre.setIcon(new ImageIcon("images/disponible.jpg"));
		liste_voiture_sorties.setIcon(new ImageIcon("images/sortie.jpg"));
		liste_voiture_reserve.setIcon(new ImageIcon("images/reserve.jpg"));
		tout_voiture.setIcon(new ImageIcon("images/list_voiture.jpg"));
		maj_voiture.setIcon(new ImageIcon("images/maj.jpg"));
		liste_voiture_libre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                KeyEvent.CTRL_MASK));
		liste_voiture_sorties.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
                KeyEvent.CTRL_MASK));
		liste_voiture_reserve.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,
                KeyEvent.CTRL_MASK));
		liste_voiture_retard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,
                KeyEvent.CTRL_MASK));
		tout_voiture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8,
                KeyEvent.CTRL_MASK));
		maj_voiture.setBackground(Color.white);

		maj_voiture.add(ajouter_vehicule);
		maj_voiture.add(modifier_vehicule);
		maj_voiture.add(supprimer_vehicule);
		

		maj_client.add(ajouter_client);
		maj_client.add(modifier_client);
		maj_client.add(supprimer_client);
	

		modifier_vehicule.setBackground(Color.white);
		ajouter_vehicule.setBackground(Color.white);
		supprimer_vehicule.setBackground(Color.white);

		modifier_client.setBackground(Color.white);
		ajouter_client.setBackground(Color.white);
		supprimer_client.setBackground(Color.white);
		fermer.setBackground(Color.white);
		liste_client.setBackground(Color.white);
		liste_client_attente.setBackground(Color.white);
		liste_client_cours.setBackground(Color.white);
		
		
		fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		ajouter_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		modifier_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		supprimer_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		ajouter_client.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		modifier_client.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		supprimer_client.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		
		this.clients.add(liste_client);
		this.clients.add(liste_client_attente);
		this.clients.add(liste_client_cours);
		this.clients.add(maj_client);
		
		
		liste_client_attente.setIcon(new ImageIcon("images/client_res.jpg"));
		liste_client_cours.setIcon(new ImageIcon("images/client_loc.jpg"));
		liste_client.setIcon(new ImageIcon("images/client.jpg"));
		liste_client.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                KeyEvent.CTRL_MASK));
		liste_client_attente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_MASK));
		liste_client_cours.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                KeyEvent.CTRL_MASK));
		
			 contrat.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(1);
						    }catch(Exception e11 ){}
					}

					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						p.setSelectedIndex(1);
					}
					}
		 );
			 location.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(5);
						    }catch(Exception e11 ){}
					}

					
					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						p.setSelectedIndex(5);
					}
					}
		 );
			 
			 clients.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(4);
						    }catch(Exception e11 ){}
					}

					
					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						p.setSelectedIndex(4);
					}
					}
		 );
			 facture.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(3);
						    }catch(Exception e11 ){}
					}

					
					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						p.setSelectedIndex(1);
					}
					}
		 );
			 reservation.addMouseMotionListener(new MouseMotionListener(){
					public void mouseDragged(MouseEvent e) {
						 try
						    {
							 p.setSelectedIndex(2);
						    }catch(Exception e11 ){}
					}

					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						p.setSelectedIndex(2);
					}
					}
		 );
			
			 
			 nouvelle_facture.setIcon(new ImageIcon("images/icone_facture.jpg"));
			 facture_listes.setIcon(new ImageIcon("images/facture.jpg"));
			 contrat_de_location.setIcon(new ImageIcon("images/icone_contra.jpg"));
			 contrat_listes.setIcon(new ImageIcon("images/connecte.jpg"));
			
		this.facture.add(nouvelle_facture);
		this.facture.add(facture_listes);
		this.contrat.add(contrat_de_location);
		this.contrat.add(annuler_contrat);
		this.contrat.add(contrat_listes);
		this.reservation.add(bon_de_reservation);
		this.reservation.add(liste_des_reservation);
		
			
	
		
		   

		this.menuBar.add(contrat);
		this.menuBar.add(facture);
		this.menuBar.add(reservation);
			
			this.menuBar.add(clients);
			this.menuBar.add(location);
			
	
			
			this.setJMenuBar(menuBar);
			
			
			bon_de_reservation.setBackground(Color.white);
			nouvelle_facture.setBackground(Color.white);
			facture_listes.setBackground(Color.white);
			contrat_de_location.setBackground(Color.white);
			annuler_contrat.setBackground(Color.white);
			liste_des_reservation.setBackground(Color.white);

			contrat_listes.setBackground(Color.white);
			
			annuler_contrat.setIcon(new ImageIcon("images/annula.jpg"));
			
			bon_de_reservation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                    KeyEvent.CTRL_MASK));
			liste_des_reservation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
                    KeyEvent.CTRL_MASK));
			nouvelle_facture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                    KeyEvent.CTRL_MASK));
			facture_listes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                    KeyEvent.CTRL_MASK));
			
			contrat_de_location.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                    KeyEvent.CTRL_MASK));
			contrat_listes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                    KeyEvent.CTRL_MASK));
			annuler_contrat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                    KeyEvent.CTRL_MASK));
			facture.add(nouvelle_facture);
			Border[] listBorder = {	
					BorderFactory.createEtchedBorder(Color.green, Color.GRAY),
					BorderFactory.createLineBorder(Color.green),
					BorderFactory.createLineBorder(Color.orange),
					BorderFactory.createLineBorder(Color.red),
					BorderFactory.createMatteBorder(5, 2, 5, 2, Color.black),
					BorderFactory.createRaisedBevelBorder(),
					BorderFactory.createTitledBorder("Titre")
					
						
				};
			
		
			rowCount2 = "SELECT mattricule FROM voiture WHERE etat = 'disponible' ";
			row2 = nombre_vehicule(rowCount2);
			
			rowCount3 = "SELECT mattricule FROM voiture WHERE etat = 'reservee' ";
			row3 =nombre_vehicule(rowCount3);

			rowCount4 = "SELECT mattricule FROM voiture ";
			row4 =nombre_vehicule(rowCount4);
			
		

			 row2 = nombre_vehicule(rowCount2);
			 row3 = nombre_vehicule(rowCount3);
			row4 = nombre_vehicule(rowCount4);
		

			
			rowCount="1";rowCount2="2";rowCount3="3";rowCount4="4";rowCount5="5";rowCount6="6";
			 JButton actualiser = new JButton("Actualiser");
			 actualiser.setPreferredSize(new Dimension(200, 20));
			 
			 actualiser.addActionListener(new ActionListener(){

			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		 row1 = /*nombre_vehicule(rowCount);*/	11;
			 			row2 = nombre_vehicule(rowCount2);
			 			 row3 = nombre_vehicule(rowCount3);;
			 			text3.setText(""+row3);
			 			text2.setText(""+row2);
			 			text1.setText(""+row1);
			 			row4 = nombre_vehicule(rowCount4);
			 			 row6 = /*nombre_vehicule(rowCount6);*/  55;
			 			text4.setText(""+row4);
			 			text6.setText(""+row6);
			 			 System.out.println(row4);
			 	}
			 	
			 });
		
	

JLabel lib = new JLabel("Nombre de contrat:");
JLabel lib2 = new JLabel("Vehicule disponible:");
JLabel lib4 = new JLabel("Vehicule reservés:");
JLabel lib3 = new JLabel("Vehicule sorties:" );
JLabel lib6 = new JLabel("Nombre de réservation:");


JPanel panlib6 = new JPanel();
lib6.setPreferredSize(new Dimension(160, 20));
panlib6.setBorder(listBorder[0]);
lib6.setAlignmentX(JLabel.CENTER);
text6 =  new JTextField(""+row6);
text6.setPreferredSize(new Dimension(50, 20));
JLabel iconlib6 = new JLabel(new ImageIcon("images/reservee.jpg"));
JButton boutonlib6 = new JButton("Voir");
panlib6.add(iconlib6);
panlib6.add(lib6);
panlib6.add(text6);
panlib6.add(boutonlib6);
panlib6.setBackground(Color.white);

JPanel premiere_couche = new JPanel();
premiere_couche.setPreferredSize(new Dimension(350, 380));
premiere_couche.setBackground(Color.white);


client_attente.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		
		client_libre lads=new client_libre("");
		
	
		
	
	}
	
});

//AJOUTER VEHICULE
ajouter_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		ajoute_voiture zd = new ajoute_voiture("Ajoute d'une voiture");
	}				
});

//CONSULTER VEHICULE


//MODIFIER VEHICULE
modifier_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		
		modifier_voiture m = new modifier_voiture("");
		
		
		
	}				
});

//SUPPRIMER VEHICULE
supprimer_vehicule.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		
			supprimer_voiture s = new supprimer_voiture("");
		
	
	}				
});

//FERMER VEHICULE

fermer.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}				
});


change_onglet.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		if(gauche) {
		p.setTabPlacement(1);
		gauche=false;
		haut = true;
		
		}
		else if(haut){
			p.setTabPlacement(2);
			haut=false;
			gauche=false;
			droite=false;
			bas=true;
			
		}
		else if(bas){
			p.setTabPlacement(3);
			bas=false;
			haut=false;
			gauche=false;
			droite=true;
			
		}
		else if(droite){
			p.setTabPlacement(4);
			droite=false;
			bas=false;
			haut=false;
			gauche=true;
			
		}
	}				
});



p = new JTabbedPane(onglet);



p.add("", new Onglet_Voiture());
menu.setBackground(Color.white);
p.setBackground(Color.white);


contient.add(new JLabel("Progiciel répartie - Programmer en java évenementielle par REFES Chabane - Copie non autorisé"), BorderLayout.SOUTH);
this.setContentPane(p);

	}
	public class Background extends JPanel {
		 
	    public void paintComponent(Graphics g){
	            try {
	                    Image img = ImageIO.read(new File("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\aze.jpg"));
	                     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	            } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	            }
	            
	    }               
	}	
	
	public class Background2 extends JPanel {
		 
	                
	}	
	public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException, NotBoundException, InterruptedException{
		
		if(true){
	chargement wind = new chargement();
		wind.setVisible(true);
		Thread.sleep(4500);
		wind.setVisible(false);
		
		
	
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			
				new Accueil();
			}
		});
		}
	}
	  private JToolBar toolBar = new JToolBar();
	  private JButton 	connecte = new JButton(new ImageIcon("images/connecte.jpg")),
	  disponible = new JButton(new ImageIcon("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\disponible.jpg")),
	  sortie1 = new JButton(new ImageIcon("sortie.jpg")),
	  reserve = new JButton(new ImageIcon("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\reserve.jpg")),
	  retard = new JButton(new ImageIcon("retard.jpg")),
	  client = new JButton(new ImageIcon("images/client.jpg")),
	  client_contrat = new JButton(new ImageIcon("images/client_loc.jpg")),
	  client_attente = new JButton(new ImageIcon("images/client_res.jpg")),
	  facture1 = new JButton(new ImageIcon("images/facture.jpg")),
	  reservee = new JButton(new ImageIcon("C:\\Users\\Mazen Sghaier\\eclipse-workspace\\Gestion_allocation_voitures\\src\\reservee.jpg")),
	  change_onglet = new JButton(new ImageIcon("images/change_onglet.jpg")),
	  change_onglet_haut = new JButton(new ImageIcon("images/change_onglet.jpg")),
	  change_onglet_droit= new JButton(new ImageIcon("images/change_onglet.jpg")),
	  change_onglet_bas = new JButton(new ImageIcon("images/change_onglet.jpg")),
	  icone_contrat = new JButton(new ImageIcon("images/icone_contra.jpg")),
	  icone_reserva = new JButton(new ImageIcon("images/icone_reserva.jpg")),
	  icone_facture = new JButton(new ImageIcon("images/icone_facture.jpg"));
	  
	 
private Color fondBouton = Color.white;

	 private void initToolBar(){
	    	
	    	//this.contrat_listes.setBackground(fondBouton);
		 icone_facture.setToolTipText("Faire une nouvelle facture");
		 icone_contrat.setToolTipText("Faire une nouveau contrat");
		 icone_reserva.setToolTipText("Faire une nouvelle réservation");
		 change_onglet.setToolTipText("Changer la position de l'onglet");
		 reservee.setToolTipText("Afficher la liste des réservation");
		 facture1.setToolTipText("Afficher la liste des factures");
		 client_attente.setToolTipText("Afficher la liste des clients ayant réservé");
		 client_contrat.setToolTipText("Afficher la liste des clients sous contrats");
		 reserve.setToolTipText("Afficher la liste des vehicules en réservation");
		 sortie1.setToolTipText("Afficher la liste des vehicules non disponible");
		 disponible.setToolTipText("Afficher la liste des vehicules disponible");
		 
		 this.toolBar.add(icone_contrat);
	    	this.toolBar.add(icone_reserva);
	    	this.toolBar.add(icone_facture);
		 this.icone_contrat.setBackground(fondBouton);
	    	this.icone_reserva.setBackground(fondBouton);
	    	this.icone_facture.setBackground(fondBouton);
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
		
	    	
	    	
	   	this.toolBar.add(change_onglet);
		 
	
		 this.change_onglet.setBackground(fondBouton);
	   	
			this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.add(connecte);
	    	this.toolBar.add(reservee);
	    	this.toolBar.add(facture1);
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.connecte.setBackground(fondBouton);
	    	this.reservee.setBackground(fondBouton);
	    	this.facture1.setBackground(fondBouton);
	    	this.disponible.setBackground(fondBouton);
	    	this.toolBar.add(disponible);
	    
	    	
	    	//Ajout des Listeners
	    	
	    	this.reserve.setBackground(fondBouton);
	    	this.toolBar.add(reserve);
	    	
	    	this.sortie1.setBackground(fondBouton);
	    	this.toolBar.add(sortie1);
	    	
	    	
	    	
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    	/*
	    	this.client.setBackground(fondBouton);
	    	this.toolBar.add(client);
	    	this.client_contrat.setBackground(fondBouton);
	    	this.toolBar.add(client_contrat);
	    	this.client_attente.setBackground(fondBouton);
	    	this.toolBar.add(client_attente);
	    //	this.retard.setBackground(fondBouton);
	    	//this.toolBar.add(retard);
	    	
	    */
	    	toolBar.setBackground(Color.white);
	    	menu.add(toolBar, BorderLayout.CENTER);
	    	menu.setPreferredSize(new Dimension(600, 50));
	    }

	 
	 
	 
	 // CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT 
	 // CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT CONTRAT 
	 
	 
	 

 	 synchronized static public  int nombre_vehicule(String requete)  {
 	 	// TODO Auto-generated method stub
 	 	Statement state;
 	 	int rowCount = 0;
 	 	try {
 	 		state = Connect.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

 	 	ResultSet res = state.executeQuery(requete);
 	 	res.last();
 	 	rowCount = res.getRow();                    
 	 	res.close();
 	 	state.close();
 	 	} catch (SQLException e) {
 	 		// TODO Auto-generated catch block
 	 		e.printStackTrace();
 	 	}
 	 	return rowCount;
 	 }
 	 /*
 	synchronized public void marques() throws RemoteException {
 		// TODO Auto-generated method stub
 		
 		try {
 			Location l = new Location(null, "Contrat : Informations Véhicule", true);
 			
 		} catch (MalformedURLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 	}
 	synchronized public void user(String requete) {
 		// TODO Auto-generated method stub
 	Liste_connecte c = new Liste_connecte(requete);
 		
 		
 		c.setVisible(true);
 	}*/
 	synchronized public static void vehicule(String requete)  {
 		// TODO Auto-generated method stub
 		
 		liste_voiture c = new liste_voiture("");
 		
 		
 		c.setVisible(true);
 	}
 	synchronized public void clients(String requete)  {
 		// TODO Auto-generated method stub
 		
 		liste_client c = new liste_client("");
 		
 		
 		c.setVisible(true);
 	}/*
 	synchronized public void user()  {
 		// TODO Auto-generated method stub
 		Liste_user c = new Liste_user();
 		c.setVisible(true);
 	}

*/
 	synchronized public void vehicule_tout()  {
 		// TODO Auto-generated method stub
 		liste_voiture c = new liste_voiture("");
 		c.setVisible(true);
 		
 	}
 	/*
 	synchronized public static void facture()  {
 		// TODO Auto-generated method stub
 		try {
			facture c = new facture();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
 		
 	}
 	synchronized public static void annuler_contra() {
 	// TODO Auto-generated method stub
 		try {
			annule_contrat c = new annule_contrat();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 	synchronized static public void contrat_list(String requete)  {
 		contrat_liste c = new contrat_liste(requete);
 		c.setVisible(true);
 		
 	}
 	synchronized static public void facture_list(String requete)  {
 		facture_liste c = new facture_liste(requete);
 		c.setVisible(true);
 		
 	}

	synchronized static public void reservation_list(String requete)  {
		reservation_liste c = new reservation_liste(requete);
 		c.setVisible(true);
 		
 	}
 	
	public void setListe_poste(JMenuItem liste_poste) {
		this.liste_poste = liste_poste;
	}




	public static JMenuItem getListe_poste() {
		return liste_poste;
	}
	*/
	 }
	

