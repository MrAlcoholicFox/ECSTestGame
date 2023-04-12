import ecs100.UI;

public class player {

    public static String sprite_right = "image/dude_right.png";
    public static String sprite_left = "image/dude_left.png";
    public static String sprite_up = "image/dude_up.png";
    public static String sprite_down = "image/dude_down.png";
    public static double player_size = 60;
    public static double player_step = 20;
    public double playerX;
    public double playerY;
    private final cube_array current_array;
    public player(double startX, double startY, cube_array current_array){
        this.current_array = current_array;
        this.playerX = startX;
        this.playerY = startY;
        this.player_init(startX, startY);
    }

    private void player_init(double X, double Y){
        this.draw_player("right", X, Y);
    }

    private void draw_player(String direction, double currentX, double currentY){
        switch (direction) {
            case "left" -> UI.drawImage(sprite_left, currentX, currentY, player_size, player_size);
            case "right" -> UI.drawImage(sprite_right, currentX, currentY, player_size, player_size);
            case "up" -> UI.drawImage(sprite_up, currentX, currentY, player_size, player_size);
            case "down" -> UI.drawImage(sprite_down, currentX, currentY, player_size, player_size);
        }
    }

    public void move_right(){
        current_array.redraw_grid();
        draw_player("right", playerX + player_step, playerY);
        this.playerX = playerX + player_step;
    }
    public void move_left(){
        current_array.redraw_grid();
        draw_player("left", playerX - player_step, playerY);
        this.playerX = playerX - player_step;
    }

    public void move_up(){
        current_array.redraw_grid();
        draw_player("up", playerX, playerY-player_step);
        this.playerY = playerY - player_step;
    }

    public void move_down(){
        current_array.redraw_grid();
        draw_player("down", playerX, playerY+player_step);
        this.playerY = playerY + player_step;
    }

    public double getX(){
        return this.playerX;
    }

    public double getY(){
        return this.playerY;
    }
}
