
public class Location_info{

    private int num;
    private String nom; 
    private String cin ; 
    private String mat ;
    private String date;
    private int duree;
    private static double prix_par_jour=48;
    private double montant;
    Clients []clients;
    Voiture []voitures;
    int i=0,j=0;

public Location_info(){}
public Location_info(int num,String nom,String cin,String mat,String d,int duree,double montant)
{
   this.num=num;
   this.nom=nom;
   this.cin=cin;
   this.mat=mat;
   this.date=d;
   this.duree=duree;
   this.montant=montant; 
   clients=new Clients[20];
   voitures=new Voiture[20];

}
public int getNum() {
   return num;
}
public void setNum(int n) throws exception {	 
   if((n>20000000 && n<30000000)|| (n>40000000 && n<60000000)|| (n>70000000 && n<80000000)|| (n>90000000 && n<100000000))
     num=n;
   else throw new exception("Phone number invalide!");  
}

public String getNom() {
   return nom;
}
public void setNom(String n) throws exception{
   int k=0;
    if(n.length()>2) {
        int l=n.length();
        for (int i=0;i<l;i++) {
            if(Character.isLetter(n.charAt(i))==false)
                k=1;	
            }
        }
    if(k==0 && !(n.isEmpty()) && n.length()<20) {
        nom=n;
    }
    else throw new exception("Nom invalide!");
}
public String  getcin() {
   return cin;
}
public void setcin(String n) throws exception{
   int k=0;
    if(n.length()>2) {
        int l=n.length();
        for (int i=0;i<l;i++) {
            if(Character.isDigit(n.charAt(i))==false)
                k=1;	
            }
        }
    if(k==0 && !(n.isEmpty()) && n.length()<20) {
        cin=n;
    }
    else throw new exception("cin invalide!");
}
public String getmat() {
   return mat;
}
public void setmat(String n) throws exception{
   int k=0;
    if(n.length()>2) {
        int l=n.length();
        for (int i=0;i<l;i++) {
            if(Character.isLetter(n.charAt(i))==false)
                k=1;	
            }
        }
    if(k==0 && !(n.isEmpty()) && n.length()<20) {
        mat=n;
    }
    else throw new exception("Matricule invalide!");    
}
public String getD() {
   return date;
}
public void setD(String d) {
   this.date =d;
}
public int getduree() {
   return duree;
}
public void setduree(int duree) {
   this.duree=duree;    
}

public double montant()
 {
    return (prix_par_jour* duree);
 }

public int verifie_cin(String n) {
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

public int verifie_nom(String n) {
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

public int verifie_num(int n) {
   if((n>20000000 && n<30000000)|| (n>40000000 && n<60000000)|| (n>70000000 && n<80000000)|| (n<90000000 && n<100000000))
      return 1;
   else return 0;
}
public int verifie_duree(int n) {
   if(n<=31)
      return 1;
   else return 0;
}
public int verifie_montant(double n){
   if(n==montant())
      return 1;
   else return 0;
}
public void ajoute_voiture(Voiture a) {
	voitures[i]=a;
	i++;
}
public void ajoute_client(Clients a) {
	clients[j]=a;
	j++;
}
public void supprimer_voiture(Voiture a) {
	for(int k=0;k<i;k++)
		{if(voitures[k] != null && voitures[k].getmat()==a.getmat())
			{	voitures[i] = null;
				break;
				}
		} 
			
}
public void supprimer_client(Clients a) {
	
	for(int k=0;k<j;k++)
	{if(clients[k] != null && clients[k].get_cin()==a.get_cin())
		{	clients[i] = null;
			break;
			}
	} 
	;
}
}