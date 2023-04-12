import ecs100.UI;

import java.awt.*;

public class cube_array {
    public static double cube_size = 150;
    public double c_amount;
    public double c_X;
    public double c_Y;
    public cube_array(double amount, double X, double Y){
        this.c_amount = amount;
        this.c_X = X;
        this.c_Y = Y;
    }

    public void redraw_grid(){
        UI.clearGraphics();
        this.draw(c_amount, c_X, c_Y);
    }

    //double[] xPoints = {X, X, X+cube_size/2, X+cube_size/2, X+cube_size, X+cube_size/2, X, X+cube_size/2};
    //double[] yPoints = {Y+cube_size*0.25, Y+cube_size*0.75, Y+cube_size, Y+cube_size/2, Y+cube_size*0.25, Y, Y+cube_size*0.25, Y+cube_size/2};
    //xPoints = new double[]{X, X+cube_size/2, X+cube_size, X+cube_size/2, X+cube_size/2, X+cube_size, X+cube_size, X+cube_size/2};
    //yPoints = new double[]{Y+cube_size*0.25, Y, Y+cube_size*0.25, Y+cube_size/2, Y+cube_size, Y+cube_size*0.75, Y+cube_size*0.25, Y};
    public void draw(double amount, double startX, double startY) {
        double X = startX;
        double Y = startY;
        for (int i_cube_row = 1; i_cube_row <= amount*2; ++i_cube_row) {
            if (i_cube_row %2 == 0){
                X = X + cube_size/2;
            }
            for (int i_cube_col = 1; i_cube_col <= amount; ++i_cube_col) {
                double[] xPoints;
                double[] yPoints;
                if (i_cube_col == amount && i_cube_row % 2 == 0 && i_cube_row != amount*2) {
                    xPoints = new double[]{X, X+cube_size/2, X+cube_size, X+cube_size, X+cube_size, X+cube_size/2};
                    yPoints = new double[]{Y+cube_size*0.25, Y, Y+cube_size*0.25, Y+cube_size*0.75, Y+cube_size*0.25, Y+cube_size/2};
                }
                else if (i_cube_row == amount*2 && i_cube_col == 1){
                    xPoints = new double[]{X, X, X-cube_size/2, X, X + cube_size / 2, X + cube_size, X + cube_size, X + cube_size / 2, X + cube_size / 2, X + cube_size / 2, X, X + cube_size / 2, X + cube_size, X + cube_size / 2};
                    yPoints = new double[]{Y + (cube_size * 0.25), Y + cube_size * 0.75, Y+cube_size*0.5, Y+cube_size*0.75, Y + cube_size, Y + cube_size * 0.75, Y + cube_size * 0.25, Y + cube_size / 2, Y + cube_size, Y + cube_size / 2, Y + cube_size * 0.25, Y, Y + cube_size * 0.25, Y};
                }
                else if (i_cube_row == amount*2){
                    xPoints = new double[]{X, X, X + cube_size / 2, X + cube_size, X + cube_size, X + cube_size / 2, X + cube_size / 2, X + cube_size / 2, X, X + cube_size / 2, X + cube_size, X + cube_size / 2};
                    yPoints = new double[]{Y + (cube_size * 0.25), Y + cube_size * 0.75, Y + cube_size, Y + cube_size * 0.75, Y + cube_size * 0.25, Y + cube_size / 2, Y + cube_size, Y + cube_size / 2, Y + cube_size * 0.25, Y, Y + cube_size * 0.25, Y};
                }
                else if (i_cube_col == 1 && i_cube_row % 2 == 1){
                    xPoints = new double[]{X, X, X, X+cube_size/2, X+cube_size, X+cube_size/2};
                    yPoints = new double[]{Y+cube_size*0.25, Y+cube_size*0.75, Y+cube_size*0.25, Y+cube_size/2, Y+cube_size*0.25, Y};
                }
               /* else if (i_cube_row == 1){
                    xPoints = new double[]{X, X+cube_size/2, X+cube_size, X+cube_size/2, X-cube_size/2, X+cube_size/2};
                    yPoints = new double[]{Y+cube_size*0.25, Y+cube_size/2, Y+cube_size*0.25, Y, Y, Y};
                }*/
                else {
                    xPoints = new double[]{X, X+cube_size/2, X+cube_size, X+cube_size/2};
                    yPoints = new double[]{Y+cube_size*0.25, Y+cube_size/2, Y+cube_size*0.25, Y};
                }
                UI.setColor(Color.black);
                UI.drawPolygon(xPoints, yPoints, xPoints.length);
                X = X + cube_size;
            }
            Y = Y + cube_size*0.25;
            X = startX;
        }

    }

}
