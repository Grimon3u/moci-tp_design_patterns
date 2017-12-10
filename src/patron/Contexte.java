package patron;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Contexte extends Observable {
	
	private Map<String, Integer> tds;
	
	public Contexte() {
		this.tds = new HashMap<String, Integer>();
	}
	
	public Map<String, Integer> getTds() {
		return this.tds;
	}
	
	/**
	 * Fonction ajoutant une variable au contexte.
	 * @param var
	 * 		Le nom de la variable.
	 * @param val
	 * 		La valeur de la variable.
	 */
	public void add(String var, int val) {
		this.tds.put(var, val);
		setChanged();
		notifyObservers();
	}
	
}