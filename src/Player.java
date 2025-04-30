import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Player extends Entity{
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
    private int idleFrame;
    private int attackFrame;
    private int frameCount;
    private boolean lockMovement;

    public Player(KeyInputs keyH, MouseInputs mouseH, GamePanel gp){
        super(gp,4,5,12,new File("Img\\Terrible Knight\\atlas.png"),128,96);
        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;
        spriteHeight=96;
        spriteWidth=128;
        selectedRow = 0;
        selectedColumn = 0;
        widthModifier = 0;
        heightModifier = 0;
        widthScaler = 2;
        heightScaler = 2;
        runFrame = 0;
        idleFrame = 0;
        frameCount = 0;
        attackFrame = 0;
        lockMovement = false;
        sprites=getSpriteImage();
    }

    @Override
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    @Override
    public void update(){
        frameCount++;
        if(frameCount%4==0) {
            if (attackFrame == 5) {
                attackFrame = 0;
                lockMovement = false;
            } else if (attackFrame != 0) {
                attackFrame++;
                selectedColumn = attackFrame;
            }
        }
        if(!lockMovement) {
            if (keyH.upPressed) {
                y -= speed;
            }
            if (keyH.downPressed) {
                y += speed;
            }
            if (!(keyH.rightPressed && keyH.leftPressed)) {
                if (keyH.rightPressed) {
                    x += speed;
                    widthModifier = 0;
                    widthScaler = 2;
                    selectedRow = 7;
                    selectedColumn = runFrame;
                    if (frameCount % 5 == 0) {
                        if (runFrame == 11) {
                            runFrame = 0;
                        } else {
                            runFrame++;
                        }
                    }
                }
                if (keyH.leftPressed) {
                    x -= speed;
                    widthModifier = 2 * spriteWidth;
                    widthScaler = -2;
                    selectedRow = 7;
                    selectedColumn = runFrame;
                    if (frameCount % 5 == 0) {
                        if (runFrame == 11) {
                            runFrame = 0;
                        } else {
                            runFrame++;
                        }
                    }
                }
            }
            if (!(keyH.leftPressed || keyH.rightPressed) || (keyH.leftPressed && keyH.rightPressed)) {
                selectedRow = 0;
                selectedColumn = idleFrame;
                if (frameCount % 12 == 0) {
                    if (idleFrame == 3) {
                        idleFrame = 0;
                    } else {
                        idleFrame++;
                    }
                }
            }
            if(mouseH.leftClick){
                selectedRow = 8;
                selectedColumn = attackFrame;
                attackFrame++;
                lockMovement = true;
                mouseH.leftClick=false;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2){
        g2.drawImage(sprites[selectedRow][selectedColumn],x + widthModifier,y + heightModifier, spriteWidth * widthScaler, spriteHeight * heightScaler,null);
    }
}
