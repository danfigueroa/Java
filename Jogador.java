package cardgame;

import java.util.ArrayList;

public class Jogador {
	private ArrayList<Integer> mao = new ArrayList<Integer>(3);
	private int numeroJogador;

	public Jogador(int numeroJogador) {
		this.numeroJogador = numeroJogador;
	}

	public void setMao(Integer carta1, Integer carta2, Integer carta3, Integer carta4) {
		mao.add(carta1);
		mao.add(carta2);
		mao.add(carta3);
                mao.add(carta4);
	}

	public String toString() {
		String strMao = "";
		for (int i = 0; i < mao.size(); i++) {
			strMao += "[" + mao.get(i) + "]";
			if (i > 0 && i % 10 == 0) {
				strMao += "\n";
			}
		}
		return strMao;
	}

	public void setNumeroJogador(int numero) {
		numeroJogador = numero;
	}

	public int getNumeroJogador() {
		return numeroJogador;
	}

	public int getPesoMao() {
		int pesoMao = 0;
		for (int i = 0; i < 3; i++) {
			pesoMao += (int) mao.get(i);
		}

		return pesoMao;
	}

	public void limpaMao() {
		mao.clear();
	}

}
