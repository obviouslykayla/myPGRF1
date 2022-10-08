package raster;

import java.awt.*;

public interface Raster {
    void setPixel(int x, int y, int color);
    int getPixel(int x, int y);

    void clear();

}
