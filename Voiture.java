
public class Voiture {
	 private String matricule ;// label  
     private String marque ;// combobox
     private String couleur ;// class 
     private String etat ; 
     private String date_achat ; // JCalendar
     private float prix ; // 100<p<1000
public Voiture() {}
 public Voiture (String mt ,String mr,String clr ,String d,float p,String disponible) {
     this.matricule = mt ;
     this.marque = mr ;
     this.couleur = clr ;
    // this.etat = e ;
     this.date_achat = d ;
     this.prix = p ;
     this.etat=disponible;
 }
 //getters
 
 public String getmat() 
 {	return matricule ;	 }
 public String getmar() 
 {  return marque ;	}
 public String getclr() 
 {	 return couleur ;  }
 /*public boolean gete()
  {	 return etat;  }*/
 public String getd()
  {  return date_achat;	}
 public float getprix()
  {	 return prix;  }

 //setters
 
 public void setmat(String m) { 
     matricule = m ;
     }
 
 public void setmar(String m) { 
     marque = m ;
     }
 
 public void setclr(String c) { 
     couleur = c ;
     }
 /*public void sete(boolean m) { 
     etat = m ;
     }*/
 
 public void setd (String d){	 
     date_achat = d ;
     }
 public void setprix(float m) { 
     prix = m ;
     }
 
 /*public int verifie_clr(String n) {
	 if(n=="noir")// || n=="blanc" || n=="rouge" || n=="vert" || n=="bleu" || n=="marron" || n=="gris" || n=="rose" || n=="jaune" || n=="violet" || n=="orange" || n=="beige")
		   return 1;
		 else
			 return 0;
 }
 */
 public int verifie_mat(String n) {
	   int k=0;
	   int l=n.length();
	   if(n.length()>2) {
	   for (int i=0;i<l;i++) {
	      if(Character.isLetter(n.charAt(i))==false)
	         k=1;	
	   }
	}
	   if(k==0 && !(n.isEmpty()) && n.length()<20) {
		   return 1;
		}
		else return 0;
		}
 public int verifie_clr(String n) {
	   int k=0;
	   int l=n.length();
	   if(n.length()>2) {
	   for (int i=0;i<l;i++) {
	      if(Character.isLetter(n.charAt(i))==false)
	         k=1;	
	   }
	}
	   if(k==0 && !(n.isEmpty()) && n.length()<20) {
		   return 1;
		}
		else return 0;
		}
 public int verifie_mar(String n) {
	   int k=0;
	   int l=n.length();
	   if(n.length()>2) {
	   for (int i=0;i<l;i++) {
	      if(Character.isLetter(n.charAt(i))==false)
	         k=1;	
	   }
	}
	   if(k==0 && !(n.isEmpty()) && n.length()<20) {
		   return 1;
		}
		else return 0;
		}

 /*public int verifie_mar(String n) {
	 
	 if(n=="bmw" )//|| n=="clio" || n=="audi" || n=="bugatti" || n=="dacia" || n=="ferrari" || n=="fiat" || n=="isuzu" || n=="jaguar" || n=="kia" || n=="maserati" || n=="peugeot" || n=="mercedes" || n=="toyota" || n=="volvo" || n=="zenvo")
	   return 1;
	 else
		 return 0;
 }
 */
 public int verifie_date(String n) {
	   int k=0;
	   if (n.length()==8)
	   {
	       for(int i=0; i<=n.length();i++){
	           if(!(Character.isDigit(n.charAt(i))))
	              k=1;
	   }
	   if(k==0)	return 1;
	   else return 0;
	      
	   }
	   else return 0;
	}
 public void change_etat(String a) {
	 etat=a;
 }
 public String get_etat() {
	 return etat;
 }
 
 
}