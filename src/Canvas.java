import model.Line;
import raster.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Canvas {
    private final JFrame frame;
    private final JPanel panel;

    private final Raster raster;
    private final LineRasterizer lineRasterizer;

    public Canvas(int width, int height)
    {
        frame = new JFrame();

        frame.setLayout(new BorderLayout());
        frame.setTitle("PGRF1");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        raster = new RasterBufferedImage(width, height);
        lineRasterizer= new LineRasterizerTrivial(raster);//LineRasterizerGraphics(raster);

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(((RasterBufferedImage)raster).getImg(), 0,0, null);
            }
        };
        panel.setPreferredSize(new Dimension(width, height));

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                super.mouseDragged(mouseEvent);
                raster.clear();

                Line line = new Line(width/2, height/2, mouseEvent.getX(), mouseEvent.getY());
                lineRasterizer.rasterize(line);

                panel.repaint();
            }
        });


        }
    }
