package statistiques;


import model.bdd.GestionnaireBDD;
import personne.Personne;
import model.stock.MaterielStock;

public class Statistiques{
	private GestionnaireBDD stock;
	private Personne plusGrosEmp;
	private MaterielStock plusDeFoisEmp;
	private MaterielStock plusDeFoisPanne;

	public Statistiques(GestionnaireBDD stock){
		this.stock = stock;
		plusGrosEmp = null;
		plusDeFoisEmp = null;
		plusDeFoisPanne = null;
	}

	public void majStat(){
		emprunteur();
		materiel();
	}

	public void emprunteur(){
		int max = 0;		
		for (int i = 0; i<stock.comptes.size(); i++){
			if (stock.comptes.get(i).getEmprunt()>max){
				max = stock.comptes.get(i).getEmprunt();
				plusGrosEmp = stock.comptes.get(i)
			}
		} 
	}

	public void materiel(){
		int maxEmprunt = 0;
		int maxPanne = 0;
		for (int i = 0; i<stock.stocks.size(); i++){
			if (stock.stocks.get(i).getEmprunt()>maxEmprunt){
				maxEmprunt = stock.stocks.get(i).getEmprunt();
				plusDeFoisEmp = stock.stocks.get(i);
			}
			if (stock.stocks.get(i).getPanne()>maxPanne){
				maxPanne = stock.stocks.get(i).getPanne();
				plusDeFoisPanne = stock.stocks.get(i);
			}
		}
	}

	public String toString(){
		String texte = "";
		if (plusGrosEmp == null){
			texte += "Aucun utilisateur n'a encore emprunté de matériel\n";
		}
		else texte += "Le plus gros emprunteur est : "+plusGrosEmp+" avec "+plusGrosEmp.getEmprunt()+" emprunt(s)\n";
		if (plusDeFoisEmp == null){
			texte += "Aucun matériel n'a encore été emprunté\n";
		}
		else texte += "Le matériel le plus emprunté est : "+plusDeFoisEmp+" avec "+plusDeFoisEmp.getEmprunt()+" emprunt(s)\n";
		if (plusDeFoisPanne == null){
			texte += "Aucun matériel n'a encore été en panne\n";
		}
		else texte += "Le matériel le plus souvent en panne est : "+plusDeFoisPanne+" avec "+plusDeFoisPanne.getPanne()+" panne(s)\n";
		return texte;
	}

	public String plusGrosEmp(){
		String texte = "";
		if (plusGrosEmp == null){
			texte += "Aucun utilisateur n'a encore emprunté de matériel\n";
		}
		else texte += "Le plus gros emprunteur est : "+plusGrosEmp+" avec "+plusGrosEmp.getEmprunt()+" emprunt(s)\n";
		return texte;
	}

	public String plusDeFoisEmp(){
		String texte = "";
		if (plusDeFoisEmp == null){
			texte += "Aucun matériel n'a encore été emprunté\n";
		}
		else texte += "Le matériel le plus emprunté est : "+plusDeFoisEmp+" avec "+plusDeFoisEmp.getEmprunt()+" emprunt(s)\n";
		return texte;
	}

	public String plusDeFoisPanne(){
		String texte = "";
		if (plusDeFoisPanne == null){
			texte += "Aucun matériel n'a encore été en panne\n";
		}
		else texte += "Le matériel le plus souvent en panne est : "+plusDeFoisPanne+" avec "+plusDeFoisPanne.getPanne()+" panne(s)\n";
		return texte;
	}
>>>>>>> edec35b814fe3f9076c6dbbffc1b559eb5609f14
}