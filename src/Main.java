import ecs100.UI;
import java.awt.*;
import java.awt.event.*;

public class Main{
    public void setupGUI(){
        UI.initialise();
        UI.addButton("start regret", this::start);
    }

    public void start() {
        cube_array array = new cube_array(6, 20, 20);
        array.redraw_grid();
        player steve = new player(80, 50, array);
        playercontrol key = new playercontrol();
        key.ArrowKeyListener(steve);
        UI.setKeyListener(key::keyPressed);
    }

    public void redraw(cube_array array){
        array.redraw_grid();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setupGUI();
    }


}