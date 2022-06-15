public class GameFile
{
    MyStack<Integer> leftStack;
    MyStack<Integer> middleStack;
    MyStack<Integer> rightStack;

    private int numberOfDisks;

    public GameFile(int numDisks)
    {
        leftStack = new MyStack<Integer>();
        middleStack = new MyStack<Integer>();
        rightStack = new MyStack<Integer>();

        numberOfDisks = numDisks;

        for(int i = numberOfDisks; i >= 1; i--)
        {
            leftStack.push(i);
        }
    }

    public int getNumberOfDisks()
    {
        return numberOfDisks;
    }

    public MyStack getLeftStack()
    {
        return leftStack;
    }

    public MyStack getMiddleStack()
    {
        return middleStack;
    }

    public MyStack getRightStack()
    {
        return rightStack;
    }
}