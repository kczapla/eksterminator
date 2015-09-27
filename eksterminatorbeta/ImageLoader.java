/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eksterminatorbeta;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author perun
 * Pobiera obraz ze źródła
 */
public class ImageLoader {
    BufferedImage image;
    /**
     * 
     * @param sciezka pobiera sciezke dostepu w ktorej znajdują sie zasoby
     * @return zwraca pobrany obraz
     * @throws IOException w przypadku kiedy sciezka byla by pusta
     */
    public BufferedImage LoadImage (String sciezka) throws IOException{
        image = ImageIO.read(getClass().getResource(sciezka));
        return image;
    }
}
