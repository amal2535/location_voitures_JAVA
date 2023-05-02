import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Apropos extends JFrame{
	//private JOptionPane jop = new JOptionPane();
	private String str;
	ImageIcon img = new ImageIcon("images.jpg");
	JOptionPane jop1 = new JOptionPane(), jop2 = new JOptionPane();



    public Apropos(String title){
        super(title);
		
		str = "Mini-Projet réalisé par : \n";
		str += "\t \t \t \t \t \t \t \t \t \t \t \t \t \t"+"Mazen Sghair\n"; 
		str += "\t \t \t \t \t \t \t \t \t \t \t \t \t \t"+"Farah Riahi\n";
		str += "\t \t \t \t \t \t \t \t \t \t \t \t \t \t"+"Amal Maatoug\n\n\n";
		str += "Maitre de Mini-Projet : \n";
		str += "\t \t \t \t \t \t \t"+"Mourad Kmimech "+" & "+" Nihed Youssfi\n";
		JOptionPane.showMessageDialog( null, str,"A propos...", JOptionPane. INFORMATION_MESSAGE, img); 
		
		
	}
	
   public static void main(String[] args){

        Apropos a = new Apropos("Apropos de l'application");
		a.setDefaultCloseOperation(3);
		a.setSize(700,500);
		a.setVisible(true);

		

    }
}