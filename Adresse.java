public class Adresse {
    private int num_rue;
	private String nom_rue;
	private int code_pos;
	

	public Adresse(){}
	public Adresse(String n,int r,int c)
	{
		nom_rue=n;
		num_rue=r;
		code_pos=c;
	}
	
	/*Getteur*/
	
	public int get_num() {	return num_rue;	 }
	public String get_nom() {  return nom_rue;	}
	public int get_code() {	 return code_pos;  }
	
	/*Setteur*/
	
	public void set_num(int n) throws exception {	
		if (0<=n && n<10000)
		num_rue=n;
		else throw new exception ("Numéro de rue invalide!");
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
	if(k==0 && !(n.isEmpty())) {
		nom_rue=n;
	}
	else throw new exception("Nom de rue invalide!");
	}
	public void set_code(int n) throws exception {	 
	  if(n>0)
		code_pos=n;
	  else throw new exception("Code postal invalide!");  
	}
	
	/*Verifier*/
	
	public int verifie_num(int n) {
		if (0<=n && n<10000) return 1;
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
	public int verifie_code(int n) {
		if (0<=n && n<10000) return 1;
		else return 0;
	}
} 
