package raster;


public class LineRasterizerTrivial extends LineRasterizer {

    public LineRasterizerTrivial(Raster raster) {
        super(raster);
    }

    @Override
    protected void drawLine(int x1, int y1, int x2, int y2) {
        float k = (float)(y2-y1)/(x2-x1);
        float q = y1-k*x1;

        if(x1<x2) {
            for (int x = x1; x < x2; x++) {
                int y = (int) ((k * x) + q);
                raster.setPixel(x, y, 0xffff00);
            }
        }
        if(x1>x2){
            for (int x = x2; x < x1; x++) {
                int y = (int) ((k * x) + q);
                raster.setPixel(x, y, 0xffff00);
            }
        }
    }

}