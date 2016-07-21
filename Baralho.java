package cardgame;

import java.util.ArrayList;

public class Baralho {
	private ArrayList<Integer> baralho = new ArrayList<Integer>(50);
	
	public Baralho() {
		embaralhar();
	}
	
	public void embaralhar() {
		baralho.clear();
		while(baralho.size() < 50) {
			int numero = (int)Math.round(Math.random() * 50);
			if(!baralho.contains(new Integer(numero))) {
				baralho.add(new Integer(numero));
			}
		}
	}
	
	public String toString() {
		String strBaralho = "";
		for(int i = 0; i < baralho.size(); i++) {
			strBaralho += "[" + baralho.get(i) + "]";
			if(i > 0 && i%10 == 0) {
				strBaralho+= "\n";
			}
		}
		return strBaralho;
	}
	
	public Integer getCarta() {
		return baralho.remove(baralho.size()-1);
	}

}