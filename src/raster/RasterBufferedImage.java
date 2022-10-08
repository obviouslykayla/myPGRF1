package raster;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RasterBufferedImage implements Raster {

    private final BufferedImage img;

    public RasterBufferedImage(final int width, final int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void clear() {
        Graphics g = img.getGraphics();
        g.setColor(new Color(0x00));
        g.fillRect(0, 0, img.getWidth()-1, img.getHeight()-1);
    }

    @Override
    public void setPixel(int x, int y, int color) {
        img.setRGB(x, y, 0xffff00);
    }

    /*
        @Override
        public void setPixel(int x, int y, int color) {
            img.setRGB(10, 10, 0xff0000);
        }

    */
    @Override
    public int getPixel(int x, int y) {
        return 0;
    }

    public BufferedImage getImg() {
        return img;
    }
}