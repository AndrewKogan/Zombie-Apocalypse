import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Player {
    private KeyInputs keyH;
    private MouseInputs mouseH;
    private GamePanel gp;
    private int x;
    private int y;
    private int speed;
    BufferedImage spriteSheet;
    BufferedImage[][] sprites = new BufferedImage[1][1];
    private int selectedRow = 0;
    private int selectedColumn = 0;

    public Player(KeyInputs keyH, MouseInputs mouseH, GamePanel gp){
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    public void getPlayerImage(){
        try {
            spriteSheet = ImageIO.read(new File("Img\\Terrible Knight\\atlas.png"));

            int spriteWidth = 96;
            int spriteHeight = 128;
            int rows = spriteSheet.getHeight() / spriteHeight;
            int cols = spriteSheet.getWidth() / spriteWidth;

            sprites = new BufferedImage[rows][cols];

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    sprites[row][col] = spriteSheet.getSubimage(col * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed){
            y-=speed;
        }
        if(keyH.downPressed){
            y+=speed;
        }
        if(keyH.rightPressed){
            x+=speed;
        }
        if(keyH.leftPressed){
            x-=speed;
        }
    }
    public void draw(Graphics2D g2){

        g2.drawImage(sprites[selectedRow][selectedColumn],x,y, null);
    }
}
