package asw.xadrez.versao3.aposdojo1;

import javax.swing.ImageIcon;

public class Peca {
	private TipoDePeca tipoDePeca;
	private Cor corDaPeca;

	public Peca(TipoDePeca tipoDePeca, Cor corDaPeca) {
		super();
		this.tipoDePeca = tipoDePeca;
		this.corDaPeca = corDaPeca;
	}

	public Cor getCor(){
		return corDaPeca;
	}

	public ImageIcon getPecaPreta() {
		return new ImageIcon(tipoDePeca.getBufferedImageP());
	}

	public ImageIcon getPecaBranca() {
		return new ImageIcon(tipoDePeca.getBufferedImageB());
	}
}