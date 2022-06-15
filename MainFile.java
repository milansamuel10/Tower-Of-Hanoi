import java.util.Scanner;

public class MainFile
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Playing with keys '1', '2', and '3'. Enter the number of disks you would like to play with (3 to 7): ");
        int numberOfDisks = keyboard.nextInt();

        while(numberOfDisks < 3 || numberOfDisks > 7)
        {
            System.out.print("Enter the number of disks you would like to play with (3 to 7): ");
            numberOfDisks = keyboard.nextInt();
        }

        System.out.println();

        new FrameFile("Tower of Hanoi by Milan Saju Samuel", 660, 300, numberOfDisks);
    }
}