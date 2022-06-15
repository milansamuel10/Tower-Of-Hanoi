import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelFile extends JPanel implements KeyListener
{
    private GameFile game;

    private MyStack leftStack;
    private MyStack middleStack;
    private MyStack rightStack;

    private boolean leftPoleSelected;
    private boolean middlePoleSelected;
    private boolean rightPoleSelected;

    private int moveCount;

    public PanelFile(int panelWidth, int panelHeight, int numDisks)
    {
        super();

        setSize(panelWidth, panelHeight);

        addKeyListener(this);

        game = new GameFile(numDisks);

        leftStack = game.getLeftStack();
        middleStack = game.getMiddleStack();
        rightStack = game.getRightStack();

        leftPoleSelected = false;
        middlePoleSelected = false;
        rightPoleSelected = false;

        moveCount = 0;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(0, 248, getWidth(), 54);
        g.fillRect(103, 23, 14, 229);
        g.fillRect(323, 23, 14, 229);
        g.fillRect(543, 23, 14, 229);
        g.setColor(new Color(222, 184, 135));
        g.fillRect(1, 250, 658, 48);
        g.setColor(Color.GRAY);
        g.fillRect(105, 25, 10, 225);
        g.fillRect(325, 25, 10, 225);
        g.fillRect(545, 25, 10, 225);

        if(getPoleSelected() == 1)
        {
            g.setColor(Color.RED);
            g.fillRect(105, 25, 10, 225);
        }
        if(getPoleSelected() == 2)
        {
            g.setColor(Color.RED);
            g.fillRect(325, 25, 10, 225);
        }
        if(getPoleSelected() == 3)
        {
            g.setColor(Color.RED);
            g.fillRect(545, 25, 10, 225);
        }

        int diskHeight = (200/game.getNumberOfDisks());

        int xLeftStack = 0;
        int xMiddleStack = 0;
        int xRightStack = 0;

        int diskWidth = 0;

        int yChangingLeft = 0;
        int yChangingMiddle = 0;
        int yChangingRight = 0;

        for(int i = game.getNumberOfDisks(); i >= 1; i--)
        {
            if(i == 7)
            {
                g.setColor(new Color(102,51,0));

                xLeftStack = 5;
                xMiddleStack = 225;
                xRightStack = 445;

                diskWidth = 210;
            }
            else if(i == 6)
            {
                g.setColor(Color.GREEN);

                xLeftStack = 20;
                xMiddleStack = 240;
                xRightStack = 460;

                diskWidth = 180;
            }
            else if(i == 5)
            {
                g.setColor(new Color(128,0,128));

                xLeftStack = 35;
                xMiddleStack = 255;
                xRightStack = 475;

                diskWidth = 150;
            }
            else if(i == 4)
            {
                g.setColor(new Color(255,102,0));

                xLeftStack = 50;
                xMiddleStack = 270;
                xRightStack = 490;

                diskWidth = 120;
            }
            else if(i == 3)
            {
                g.setColor(Color.BLUE);

                xLeftStack = 65;
                xMiddleStack = 285;
                xRightStack = 505;

                diskWidth = 90;
            }
            else if(i == 2)
            {
                g.setColor(Color.YELLOW);

                xLeftStack = 80;
                xMiddleStack = 300;
                xRightStack = 520;

                diskWidth = 60;
            }
            else if(i == 1)
            {
                g.setColor(Color.RED);

                xLeftStack = 95;
                xMiddleStack = 315;
                xRightStack = 535;

                diskWidth = 30;
            }

            if(leftStack.contains(i))
            {
                g.fillRect(xLeftStack,(250 - (diskHeight + yChangingLeft*diskHeight)),diskWidth,diskHeight);
                g.setColor(Color.BLACK);
                g.drawRect(xLeftStack,(250 - (diskHeight + yChangingLeft*diskHeight)),diskWidth,diskHeight);

                yChangingLeft++;
            }
            else if(middleStack.contains(i))
            {
                g.fillRect(xMiddleStack,(250 - (diskHeight + yChangingMiddle*diskHeight)),diskWidth,diskHeight);
                g.setColor(Color.BLACK);
                g.drawRect(xMiddleStack,(250 - (diskHeight + yChangingMiddle*diskHeight)),diskWidth,diskHeight);

                yChangingMiddle++;
            }
            else if(rightStack.contains(i))
            {
                g.fillRect(xRightStack,(250 - (diskHeight + yChangingRight*diskHeight)),diskWidth,diskHeight);
                g.setColor(Color.BLACK);
                g.drawRect(xRightStack,(250 - (diskHeight + yChangingRight*diskHeight)),diskWidth,diskHeight);

                yChangingRight++;
            }
        }

        if(won())
        {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier New",Font.BOLD,20));
            String str = "\"You won in " + moveCount + " moves!\"";
            g.drawString(str,15,280);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New",Font.BOLD,20));
        String str = "TOWER OF HANOI™";
        g.drawString(str,470,290);
    }

    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if ((keyCode == 97 || keyCode == 49) && !won())
        {
            if(getPoleSelected() == 2 && !middleStack.empty())
            {
                if(move(middleStack,leftStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = true;
                    middlePoleSelected = false;
                    rightPoleSelected = false;
                }
            }
            else if(getPoleSelected() == 3 && !rightStack.empty())
            {
                if(move(rightStack,leftStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = true;
                    middlePoleSelected = false;
                    rightPoleSelected = false;
                }
            }
            else
            {
                leftPoleSelected = true;
                middlePoleSelected = false;
                rightPoleSelected = false;
            }
        }
        else if ((keyCode == 98 || keyCode == 50)  && !won())
        {
            if(getPoleSelected() == 1 && !leftStack.empty())
            {
                if(move(leftStack,middleStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = false;
                    middlePoleSelected = true;
                    rightPoleSelected = false;
                }
            }
            else if(getPoleSelected() == 3 && !rightStack.empty())
            {
                if(move(rightStack,middleStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = false;
                    middlePoleSelected = true;
                    rightPoleSelected = false;
                }
            }
            else
            {
                leftPoleSelected = false;
                middlePoleSelected = true;
                rightPoleSelected = false;
            }
        }
        else if ((keyCode == 99 || keyCode == 51)  && !won())
        {
            if(getPoleSelected() == 1 && !leftStack.empty())
            {
                if(move(leftStack,rightStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = true;
                }
            }
            else if(getPoleSelected() == 2 && !middleStack.empty())
            {
                if(move(middleStack,rightStack))
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = false;

                    repaint();
                }
                else
                {
                    leftPoleSelected = false;
                    middlePoleSelected = false;
                    rightPoleSelected = true;
                }
            }
            else
            {
                leftPoleSelected = false;
                middlePoleSelected = false;
                rightPoleSelected = true;
            }
        }
        repaint();
    }

    private boolean move(MyStack source, MyStack target)
    {
        if(target.size() == 0 || (int)(source.peek()) < (int)(target.peek()))
        {
            target.push(source.peek());
            source.pop();

            moveCount++;

            return true;
        }

        repaint();

        return false;
    }

    private int getPoleSelected()
    {
        if(leftPoleSelected)
            return 1;
        if(middlePoleSelected)
            return 2;
        if(rightPoleSelected)
            return 3;
        else
            return -1;
    }

    private boolean won()
    {
        boolean won = true;

        for(int n = game.getNumberOfDisks(); n >= 1; n--)
        {
            if(!(rightStack.contains(n)))
                won = false;
        }

        return won;
    }

    //Method below not used!
    public void keyReleased(KeyEvent e)
    {
    }
    //Method below not used!
    public void keyTyped(KeyEvent e)
    {
    }

    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}