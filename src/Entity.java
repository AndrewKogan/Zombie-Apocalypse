import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Entity {
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
    private boolean attacked;
    private boolean movedRight;
    private boolean movedLeft;
    private int attackInverseFrameRate;
    private int runInverseFrameRate;
    private int idleInverseFrameRate;
    private File fileName;

    public Entity(GamePanel gp, int attackInverseFrameRate, int runInverseFrameRate, int idleInverseFrameRate, File fileName, int spriteWidth, int spriteHeight){
        this.gp = gp;
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
        this.fileName = fileName;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        setDefaultValues();
    }

    public BufferedImage[][] getSpriteImage(){
        try {
            spriteSheet = ImageIO.read(fileName);

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
        return sprites;
    }
    public void setDefaultValues(){}
    public void update(){}
    public void draw(Graphics2D g2){}
}
