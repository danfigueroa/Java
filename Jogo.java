package cardgame;

import java.util.ArrayList;

public class Jogo {
	private Baralho baralho;
	private int numeroJogadores;
	private ArrayList<Jogador> jogadores;
	private boolean existeVencedor;
	private Jogador vencedor;

	Jogo(int numeroJogadores) {
		baralho = new Baralho();
		this.numeroJogadores = numeroJogadores;
		jogadores = new ArrayList<Jogador>(numeroJogadores);

		for (int i = 0; i < numeroJogadores; i++) {
			jogadores.add(new Jogador(i + 1));
		}
		existeVencedor = false;
	}

	public String novaRodada() {
		String rodada = "----NOVA RODADA!!!---\n\n" + "Baralho: \n"
				+ baralho.toString() + "\n\n";

		int menorPeso = 0;

		for (int i = 0; i < numeroJogadores; i++) {
			jogadores.get(i).setMao(baralho.getCarta(), baralho.getCarta(),
					baralho.getCarta(), baralho.getCarta());

			if (jogadores.get(i).getPesoMao() < jogadores.get(menorPeso)
					.getPesoMao()) {
				menorPeso = i;
			}

			rodada += "Jogador " + jogadores.get(i).getNumeroJogador() + ": "
					+ jogadores.get(i) + " - Peso da Mão: "
					+ jogadores.get(i).getPesoMao() + "\n";
		}
		baralho.embaralhar();
		rodada += "\n\nEliminado: Jogador "
				+ jogadores.remove(menorPeso).getNumeroJogador();
		numeroJogadores--;

		for (int i = 0; i < numeroJogadores; i++) {
			jogadores.get(i).limpaMao();
		}

		if (jogadores.size() == 1) {
			existeVencedor = true;
			vencedor = jogadores.get(0);
		}

		return rodada;
	}

	public boolean existeVencedor() {
		return existeVencedor;
	}

	public Jogador getVencedor() {
		return vencedor;
	}
}
