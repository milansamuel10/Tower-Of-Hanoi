import java.awt.*;
import javax.swing.*;

public class FrameFile extends JFrame
{
    public FrameFile(String frameName, int panelWidth, int panelHeight, int numDisks)
    {
        super(frameName);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setResizable(false);

        pack();

        PanelFile p = new PanelFile(panelWidth, panelHeight, numDisks);

        Insets frameInsets = getInsets();

        int frameWidth = panelWidth
                + (frameInsets.left + frameInsets.right);
        int frameHeight = panelHeight
                + (frameInsets.top + frameInsets.bottom);

        setPreferredSize(new Dimension(frameWidth, frameHeight));

        setLayout(null);

        add(p);

        pack();

        setVisible(true);
    }
}