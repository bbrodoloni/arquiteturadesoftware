package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Main extends JFrame {

	static final Color COR_CASA_SELECIONADA = new Color(79,123,215);
	static final Color COR_CASA_NAO_SELECIONADA_B = new Color(180,147,100);
	static final Color COR_CASA_NAO_SELECIONADA_P = new Color(149,95,33);

	private static final int LARGURA_EM_PIXELS = 600;
	private static final int ALTURA_EM_PIXELS = 600;

	static final Icon CASA_VAZIA = null;

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();

		JFrame janela = criarJanela();

		MouseAdapter tratadorCliques = new TratadorCliques();

		preencherJanelaComCasas(tabuleiro, janela, tratadorCliques);

		exibirJanela(janela);

	}

	private static JFrame criarJanela() {
		JFrame janela = new JFrame("Xadrez");
		janela.setLayout(new GridLayout(Constantes.NUMERO_LINHAS_TABULEIRO, Constantes.NUMERO_COLUNAS_TABULEIRO));
		janela.setSize(LARGURA_EM_PIXELS, ALTURA_EM_PIXELS);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return janela;
	}

	private static void preencherJanelaComCasas(Tabuleiro tabuleiro, JFrame janela, MouseAdapter tratadorCliques) {
		for (int i = 0; i < Constantes.NUMERO_LINHAS_TABULEIRO; ++i) {
			for (int j = 0; j < Constantes.NUMERO_COLUNAS_TABULEIRO; ++j) {
				Peca peca = tabuleiro.getPeca(i, j);
				JLabel label;
				label = new JLabel(peca.getCor() == Cor.BRANCO ? peca.getPecaBranca() : peca.getPecaPreta());
				label.setForeground(peca.getCor() == Cor.INDEFINIDO ? Color.yellow:peca.getCor() == Cor.PRETO ? Color.BLACK : Color.WHITE);
				label.setBackground((i+j)%2 == 0 ? COR_CASA_NAO_SELECIONADA_B : COR_CASA_NAO_SELECIONADA_P);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setOpaque(true);
				label.addMouseListener(tratadorCliques);
				janela.add(label);
			}
		}
	}

	private static void exibirJanela(JFrame janela) {
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}	
}