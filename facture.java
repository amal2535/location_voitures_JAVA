import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class facture extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelPrixTotal;
    private javax.swing.JLabel labelSignature;
    private javax.swing.JLabel labelTest;
    private javax.swing.JSpinner spinnerQte;
    private javax.swing.JTable table1;
    private javax.swing.JTextField textArticle;
    private javax.swing.JTextField textIndiceSupprimer;
    private javax.swing.JTextField textPrixU;
    DefaultTableModel m;
    double prixTotalFacture =0;
    public facture(String titre) {
    	super(titre);
    	setContentPane(new JLabel(new ImageIcon("C:\\Users\\amal\\eclipse-workspace\\java_location\\lib\\v.jpg.jpg")));
        this.setLocationRelativeTo(null);
        initComponents();
        m = new DefaultTableModel(null,new String[]{"Matricule de voiture","Quantité","PrixU","Prix Total location"});
        table1.setModel(m);
        labelPrixTotal.setText(prixTotalFacture+"");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      	setSize(900,600);
      	setVisible(true);
    }

    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textArticle = new javax.swing.JTextField();
        spinnerQte = new javax.swing.JSpinner();
        textPrixU = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelPrixTotal = new javax.swing.JLabel();
        labelTest = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        textIndiceSupprimer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelSignature = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255,127,0));
        jLabel1.setText("Matricule de voiture :");

        jLabel2.setFont(new java.awt.Font("", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255,127,0));
        jLabel2.setText("Quantite:");

        jLabel3.setFont(new java.awt.Font("", 3, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255,127,0));
        jLabel3.setText("Prix Unitaire (en dinars):");

        textArticle.setForeground(new java.awt.Color(255,127,0));
        textArticle.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        spinnerQte.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        textPrixU.setForeground(new java.awt.Color(255,127,0));
        textPrixU.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255,127,0));
        jLabel5.setText("Date de la facture:");

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jLabel6.setFont(new java.awt.Font("", 3, 13)); 
        jLabel6.setForeground(new java.awt.Color(255,127,0));
        jLabel6.setText("Fait à Tunis le");

        jLabel7.setFont(new java.awt.Font("", 3, 13)); 
        jLabel7.setForeground(new java.awt.Color(255,127,0));
        jLabel7.setText("Prix total à payer :");

        jLabel8.setFont(new java.awt.Font("", 3, 13)); 
        jLabel8.setForeground(new java.awt.Color(255,127,0));
        jLabel8.setText(" (Dinars)");

        labelPrixTotal.setFont(new java.awt.Font("", 3, 13));
        labelPrixTotal.setForeground(new java.awt.Color(255,127,0));
        labelPrixTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrixTotal.setText("0");
        labelPrixTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelTest.setFont(new java.awt.Font("", 3, 13));
        labelTest.setForeground(new java.awt.Color(255,127,0));
        labelTest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTest.setText("...");
        labelTest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Ligne à supprimer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinnerQte, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPrixU, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelTest, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelPrixTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jButton2)
                                                    .addComponent(textIndiceSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4))
                                                .addGap(90, 90, 90)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addComponent(jButton1)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))))))));
                    
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(textArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerQte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrixU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textIndiceSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(labelPrixTotal)
                    .addComponent(labelTest))
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING))));
                    
                   

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if( !textArticle.getText().equals("") ){
                String mat = textArticle.getText();
                int qte = (Integer)spinnerQte.getValue();
                double prixU = Double.parseDouble(textPrixU.getText());
                double prixTotalArticle = qte*prixU;
                // ajouter les 4 valeurs dans la table
                m.addRow(new Object[]{ mat , qte , prixU , prixTotalArticle});
                // vider les champs de saisie
                textArticle.setText("");
                textPrixU.setText("");
                spinnerQte.setValue(1);
                //mettre à jour le prix total de la facture
                prixTotalFacture= prixTotalFacture + prixTotalArticle;
                labelPrixTotal.setText(prixTotalFacture+"");
            }
            else{
                JOptionPane.showMessageDialog(this,"Veuillez saisir la matricule de voiture !");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erreur de saisie du prix Unitaire !");
        }
        
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // 1er cas : suppression par saisie 
        String LigneSasie = textIndiceSupprimer.getText();
        if(!LigneSasie.equals("")){ // tester si indice existe            
            int indice = Integer.parseInt(LigneSasie)-1;
            if(indice>=0 && indice<table1.getRowCount()){ // tester si indice valide
                double prixSupprime = (Double)table1.getValueAt(indice , 3);
                prixTotalFacture = prixTotalFacture - prixSupprime;
                labelPrixTotal.setText(prixTotalFacture+"");
                m.removeRow(indice);
            }
            else{ // indice invalide
                textIndiceSupprimer.setText(""); // ignorer l indice spécifié
            }            
        }
        // 2eme cas : suppression par selection
        int [] indices = table1.getSelectedRows();
        if(indices.length!=0){
            for (int i = indices.length-1; i >=0 ; i--) {
                int indice = indices[i];
                double prixSupprime = (Double)table1.getValueAt(indice , 3);
                prixTotalFacture = prixTotalFacture - prixSupprime;
                labelPrixTotal.setText(prixTotalFacture+"");
                m.removeRow(indice);
            }}
    }

   

   
}  
