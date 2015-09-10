package asw.xadrez.versao3.aposdojo1;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

final class TratadorCliques extends MouseAdapter {
	private JLabel casaOrigem;
	private Color corCasa;

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel casaClicada = (JLabel) e.getSource();

		if (nenhumaCasaSelecionada()) {
			if (casaClicada.getIcon().equals(Main.CASA_VAZIA)) return;
			selecionarCasa(casaClicada);
		} else {
			if ((casaClicada != casaOrigem) && (casaClicada.getForeground() == Color.yellow)) moverPeca(casaClicada);
			if (casaClicada == casaOrigem) deselecionarCasa(casaClicada);
		}
	}
	private void deselecionarCasa(JLabel casaClicada){
		casaOrigem = null;
	}
	private boolean nenhumaCasaSelecionada() {
		return casaOrigem == null;
	}

	private void selecionarCasa(JLabel casaClicada) {
		if (casaClicada.getBackground() == Main.COR_CASA_SELECIONADA){
			casaClicada.setBackground(corCasa);
			deselecionarCasa(casaClicada);
		}else if (casaClicada.getForeground() != Color.yellow)
		{
			corCasa = casaClicada.getBackground();
			casaClicada.setBackground(Main.COR_CASA_SELECIONADA);
			casaOrigem = casaClicada;
		}

	}

	private void moverPeca(JLabel casaDestino) {
		if (casaDestino.getBackground()== Main.COR_CASA_SELECIONADA){
			casaDestino.setBackground(corCasa);
		}
		casaDestino.setIcon(casaOrigem.getIcon());
		casaDestino.setForeground(Color.white);
		casaOrigem.setForeground(Color.yellow);
		casaOrigem.setIcon(Main.CASA_VAZIA);
		casaOrigem.setBackground(corCasa);
		casaOrigem = null;
	}
}