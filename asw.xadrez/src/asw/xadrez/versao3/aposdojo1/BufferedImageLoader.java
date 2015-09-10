package asw.xadrez.versao3.aposdojo1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class BufferedImageLoader {

	///* imagem online
	public BufferedImage carregarImagem(URL caminhoImagem) throws IOException {
		URL url = caminhoImagem;
		BufferedImage imagem = ImageIO.read(url);
		return imagem;
	}
	//*/

	/* imagem local
	public BufferedImage carregarImagem(String caminhoImagem) throws IOException {
		URL url = getClass().getResource(caminhoImagem);
		BufferedImage imagem = ImageIO.read(url);
		return imagem;
	}
	*/
}
