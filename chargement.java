import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;



public class chargement extends JWindow{
	private Thread t;
	private JProgressBar bar;
	private static JButton launch ;


	
	public chargement(){
		
		setSize(490, 370);
		setLocationRelativeTo(null);
		
		
		
		t = new Thread(new Traitement());
		bar  = new JProgressBar();
		bar.setMaximum(300);
		bar .setMinimum(0);
		bar.setStringPainted(true);
		bar.setBackground(Color.white);
		
		
		
	
				t = new Thread(new Traitement());
				t.start();
				
				
			
		
			
		
		
		
		
		JPanel pan = new JPanel();
		JLabel img = new JLabel(new ImageIcon("images/chargement.jpg"));
		img.setVerticalAlignment(JLabel.CENTER);
		img.setHorizontalAlignment(JLabel.CENTER);
		
		pan.setBorder(BorderFactory.createLineBorder(Color.blue));
		pan.add(img);
		getContentPane().add(pan, BorderLayout.NORTH);
		getContentPane().add(bar, BorderLayout.CENTER);
		getContentPane().add(new JLabel("Chargement en cours veuillez patientez un instant..."), BorderLayout.SOUTH);
	
	}
	


class Traitement implements Runnable{

	public void run(){
		
		
		for(int val = 0; val <= 300; val++){
			bar.setValue(val);
			try {
				t.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	setVisible(false);
	}	
}


}