package core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

/**
 * The heads-up display.
 */
public class Hud {

    private Sprite leftTab;
    private Sprite rightTab;
    private Sprite instructionTab;
    private Player player;
    private int playerNum;
    private Font font;

    public Hud(int screenWidth, int screenHeight) throws IOException, FontFormatException {
        leftTab = new Sprite(Resources.getImage("/resources/images/hud-left.png"));
        rightTab = new Sprite(Resources.getImage("/resources/images/hud-right.png"));
        instructionTab = new Sprite(Resources.getImage("/resources/images/instructions.png"));
        rightTab.setX(screenWidth - rightTab.getWidth());
        instructionTab.setX((App.SCREEN_WIDTH / 2) - (instructionTab.getWidth() / 2));
        instructionTab.setY(App.SCREEN_HEIGHT - instructionTab.getHeight());
        font = Resources.getFont("/resources/fonts/kabel.ttf").deriveFont(18.0f);
    }

    public void setCurrPlayer(Player player, int playerNum) {
        this.player = player;
        this.playerNum = playerNum;
    }

    public void draw(Graphics g, ImageObserver observer) {
        leftTab.draw(g, observer);
        rightTab.draw(g, observer);
        instructionTab.draw(g, observer);

        // Get font information
        BufferedImage placeholder = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = placeholder.createGraphics();
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        g.setFont(font);
        g.setColor(player.getColor());
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        String playerIndicator = "Player " + playerNum;
        int width = fm.stringWidth(playerIndicator);
        int height = fm.getHeight();
        g.drawString(playerIndicator, leftTab.getX() + (leftTab.getWidth() / 2) - (width / 2),
                (leftTab.getHeight() / 2) + (height / 2));

        String money = "$" + player.get_money();

        width = fm.stringWidth(money);
        height = fm.getHeight();
        g.drawString(money, rightTab.getX() + (rightTab.getWidth() / 2) - (width / 2),
                (rightTab.getHeight() / 2) + (height / 2));

        String instr = "Instructions";
        width = fm.stringWidth(instr);
        height = fm.getHeight();
        g.setColor(Color.WHITE);
        g.drawString(instr, instructionTab.getX() + (instructionTab.getWidth() / 2) - (width / 2),
                instructionTab.getY() + (instructionTab.getHeight() / 2) + (height / 2));

        g2d.dispose();
    }

}
