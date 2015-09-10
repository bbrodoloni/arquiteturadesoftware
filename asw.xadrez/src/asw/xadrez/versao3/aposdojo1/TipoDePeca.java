package asw.xadrez.versao3.aposdojo1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

enum TipoDePeca {
	TORRE(52,7,75,85), CAVALO(121,5,75,85), BISPO(182,4,75,85), RAINHA(242,10,75,85), REI(305,5,75,85), PEAO(0,20,60,75),NULO(1,1,1,1);

	private BufferedImage figuraPreta, figuraBranca, spriteP, spriteB;
	private String caminhoImagemOnline = "http://imageshack.com/a/img905/2052/QLIrCB.png";
	private String caminhoImagemLocal = "chess.png";
	private int alturaPixel = 87;

	public BufferedImage getBufferedImageP() {
		return figuraPreta;
	}

	public BufferedImage getBufferedImageB() {
		return figuraBranca;
	}

	private TipoDePeca(int x, int y, int largura, int altura) {
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.carregarImagem(new URL(caminhoImagemOnline)); //imagem online
			//spriteSheet = loader.carregarImagem(caminhoImagemLocal); //imagem local
		} catch (IOException e) {
			e.printStackTrace();
		}

		SpriteSheet ss = new SpriteSheet(spriteSheet);

		spriteP = ss.recortarImagem(x, y, largura, altura);
		spriteB = ss.recortarImagem(x, y+alturaPixel, largura, altura); // pixel que inicia a linha de baixo do sprite sheet
		this.figuraPreta = spriteP;
		this.figuraBranca = spriteB;
	}
}