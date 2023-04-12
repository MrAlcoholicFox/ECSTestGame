import java.awt.event.*;
import java.util.Objects;

public class playercontrol/* implements KeyListener*/{

    private player player_char;

    public void ArrowKeyListener(player player_char){
        this.player_char = player_char;
    }

    public void keyPressed(String s) {
        switch (s) {
            case "Up" -> player_char.move_up();
            case "Down" -> player_char.move_down();
            case "Left" -> player_char.move_left();
            case "Right" -> player_char.move_right();
        }
    }
}
