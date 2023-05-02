
public class Clients {
	private String cin;
	private String code_permis;
	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	private String email;
	private int phoneNum;
	private int code_pos;
	
	private String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	public Clients(String c,String permis,String n,String p ,int a, String ad,String m,int t,int code) {
		cin=c;
		code_permis=permis;
		nom=n;
		prenom=p;
		age=a;
		adresse=ad;
		email=m;
		phoneNum=t;
		code_pos=code;
	}
	public Clients() {
		
	}
	
	/*Getteur*/
	
	public String get_cin() {	return cin;	   }
	public String get_permis() {	return code_permis;	   }
	public String get_nom() {	return nom;	   }
	public String get_prenom() {  return prenom;	}
	public int get_age() {	 return age;  }
	public String get_adresse() {	 return adresse;  }
	public String get_email() {  return email;	}
	public int get_phone() {	 return phoneNum;  }
	public int get_code() {	 return code_pos;  }

	/*Setteur*/
	
	public void set_cin(String n) throws exception {
		int k=0;
		if (n.length()==8)
		{
			 for(int i=0; i<n.length();i++){
		        if(!(Character.isDigit(n.charAt(i))))
		        	k=1;
		}
		if(k==0)	cin=n;
		else throw new exception ("CIN invalide!");
		}
		else throw new exception ("CIN doit être composer de 8 chiffres!");
	}
	
	public void set_permis(String n) throws exception {
		int k=0;
		if (n.length()==10)
		{
			 for(int i=0; i<n.length();i++){
		        if(!(Character.isDigit(n.charAt(i))))
		        	k=1;
		}
		if(k==0)	code_permis=n;
		else throw new exception ("Numéro de permis invalide!");
		}
		else throw new exception ("Numéro de permis doit être composer de 10 chiffres!");
	}
	
	public void set_nom(String n) throws exception { 
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
		else throw new exception("Nom de rue invalide!");
		}
	
	public void set_prenom(String n) throws exception { 
		int k=0;
		if(n.length()>2) {
			int l=n.length();
			for (int i=0;i<l;i++) {
				if(Character.isLetter(n.charAt(i))==false)
					k=1;	
				}
			}
		if(k==0 && !(n.isEmpty()) && n.length() <20) {
			prenom=n;
		}
		else throw new exception("Prenom de rue invalide!");
		}
	
	public void set_age(int n) throws exception {	 
		  if(n>18 && n<80)
			age=n;
		  else throw new exception("Age invalide!");  
		}
	
	public void set_email(String n) throws exception {
		if(n.matches(regex))
			email=n;
		else throw new exception("Email invalide!");
	}
	
	public void set_phone(int n) throws exception {	 
		  if((n>20000000 && n<30000000)|| (n>40000000 && n<60000000)|| (n>70000000 && n<80000000)|| (n<90000000 && n<100000000))
			age=n;
		  else throw new exception("Phone number invalide!");  
		}
	
	public void set_code(int n) throws exception {	 
		  if(n>0)
			code_pos=n;
		  else throw new exception("Code postal invalide!");  
		}
	
	/*Verifier*/
	
	public int verifie_cin(String n) {
		int k=0;
		if (n.length()==8)
		{
			 for(int i=0; i<n.length();i++){
		        if(!(Character.isDigit(n.charAt(i))))
		        	k=1;
		}
		if(k==0)	return 1;
		else return 0;
			
		}
		else return 0;
	}
	
	public int verifie_age(int n) {
		if (0<=n && n<10000) return 1;
		else return 0;
	}
	
	public int verifie_permis(String n)  {
		int k=0;
		if (n.length()==10)
		{
			 for(int i=0; i<n.length();i++){
		        if(!(Character.isDigit(n.charAt(i))))
		        	k=1;
		}
		if(k==0)	return 1;
		else return 0;
					
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
	
	public int verifie_prenom(String n) {
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
	
	public int verifie_email(String n) {
		if(n.matches(regex))
			return 1;
		else return 0;
	}
	public int verifie_phone(int n) {
		if((n>20000000 && n<30000000)|| (n>40000000 && n<60000000)|| (n>70000000 && n<80000000)|| (n>90000000 && n<100000000))
			return 1;
		else return 0;
	}
	
	public int verifie_code(int n) {
		if (0<=n && n<10000) return 1;
		else return 0;
	}
}
