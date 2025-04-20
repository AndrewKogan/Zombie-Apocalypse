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
    BufferedImage[][] sprites;
    private int selectedRow;
    private int selectedColumn;
    private int spriteWidth;
    private int spriteHeight;
    private int widthModifier;
    private int heightModifier;
    private int widthScaler;
    private int heightScaler;
    private int runFrame;

    public Player(KeyInputs keyH, MouseInputs mouseH, GamePanel gp){
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        selectedRow = 0;
        selectedColumn = 0;
        widthModifier = 0;
        heightModifier = 0;
        widthScaler = 1;
        heightScaler = 1;
        runFrame = 0;
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

            spriteWidth = 128;
            spriteHeight = 96;
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
            widthModifier = 0;
            widthScaler = 1;
            selectedRow = 7;
            selectedColumn = runFrame;
            if(runFrame == 11){
                runFrame = 0;
            }
            else {
                runFrame++;
            }
        }
        if(keyH.leftPressed){
            x-=speed;
            widthModifier = spriteWidth;
            widthScaler = -1;
            selectedRow = 7;
            selectedColumn = runFrame;
            if(runFrame == 11){
                runFrame = 0;
            }
            else {
                runFrame++;
            }
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(sprites[selectedRow][selectedColumn],x + widthModifier,y + heightModifier, spriteWidth * widthScaler, spriteHeight * heightScaler,null);
    }
}
