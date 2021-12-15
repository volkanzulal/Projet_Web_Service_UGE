package fr.uge.psw.banqueService;

public class Banque {
	double solde;

	public void depotDe(double montant) {
		solde += montant;
	}

	public boolean retraitDe(double montant) {
		if(solde >= montant) {
			solde -= montant;
			return true;
		}
		return false;
	}

	public double valeurDuSolde() {
		return solde;
	}
}
