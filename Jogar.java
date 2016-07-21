package cardgame;

import javax.swing.JOptionPane;

public class Jogar {

	public static void main(String[] args) {

		int numeroJogadores = Integer
				.parseInt(JOptionPane
						.showInputDialog("Entre com o numero de jogadores (x > 5 e x < 10):"));

		while (numeroJogadores > 10 || numeroJogadores < 5) {
			try {
				numeroJogadores = Integer
						.parseInt(JOptionPane
								.showInputDialog("Entre com o numero de jogadores (x > 5 e x < 10):"));
			} catch (NumberFormatException ex) {
				numeroJogadores = Integer
						.parseInt(JOptionPane
								.showInputDialog("Entrada inválida! Entre com o numero de jogadores (x > 5 e x < 10):"));
			}
		}

		Jogo jogo = new Jogo(numeroJogadores);

		while (!jogo.existeVencedor()) {
			JOptionPane.showMessageDialog(null, jogo.novaRodada());
		}

		JOptionPane.showMessageDialog(null,
				"Vencedor: Jogador " + jogo.getVencedor().getNumeroJogador());
	}
}
