package fr.umontpellier.iut.commun.data;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImageLoaderTest {

    @Test
    public void test_img_loading(){
        Image img = ImageLoader.getImage("groupe1/dauphin.png");

        /*ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("raw/groupe1/dauphin.png");
        InputStream is = classloader.getResourceAsStream("raw/groupe1/dauphin.png");

        System.out.println(url.getFile());*/

        assertNotNull(img);
    }

}