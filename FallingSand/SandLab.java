package FallingSand;

import java.awt.*;
import java.util.*;

public class SandLab
{
    public static void main(String[] args)
    {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int FIRE = 4;
    public static final int STEAM = 5;
    //do not add any more fields
    private int[][] grid;
    private SandDisplay display;

    public SandLab(int numRows, int numCols)
    {
        String[] names;
        names = new String[6];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[FIRE] = "Fire";
        names[STEAM] = "Steam";
        display = new SandDisplay("Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool)
    {
        grid[row][col] = tool;
    }

    //copies each element of grid into the display
    public void updateDisplay()
    {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == EMPTY)
                    display.setColor(i, j, Color.BLACK);
                if(grid[i][j] == METAL)
                    display.setColor(i, j, Color.GRAY);
                if(grid[i][j] == SAND)
                    display.setColor(i, j, Color.YELLOW);
                if(grid[i][j] == WATER)
                    display.setColor(i, j, Color.BLUE);
                if(grid[i][j] == FIRE)
                    display.setColor(i, j, Color.RED);
                if(grid[i][j] == STEAM)
                    display.setColor(i, j, Color.LIGHT_GRAY);
            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        Random rand = new Random();
        int x = rand.nextInt(grid.length);
        int y = rand.nextInt(grid[0].length);
        //sand
        if(grid[x][y] == SAND){
            if(x + 1 < grid.length && grid[x+1][y] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x+1][y] = SAND;
            }
            else if(x +1 < grid.length && grid[x+1][y] == WATER)
            {
                grid[x][y] = WATER;
                grid[x+1][y] = SAND;
            }
        }
        //water
        int z = rand.nextInt(3);
        if(grid[x][y] == WATER){
            //down
            if(z == 0 && x + 1 < grid.length && grid[x+1][y] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x+1][y] = WATER;
            }
            //left
            if(z == 1 && y - 1 > 0 && grid[x][y-1] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x][y-1] = WATER;
            }
            //right
            if(z == 2 && y + 1 < grid[0].length && grid[x][y+1] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x][y+1] = WATER;
            }

            // //turn to steam
            // //left
            // if(grid[x][y-1] == FIRE){
                // grid[x][y] = STEAM;
                // grid[x][y-1] = STEAM;
            // }
            // //right
            // if(grid[x][y+1] == FIRE ){//&& y+1 < grid[0].length){
                // grid[x][y] = STEAM;
                // grid[x][y+1] = STEAM;
            // }
        }
        //fire
        if(grid[x][y] == FIRE){
            if(x - 1 > 0 && grid[x-1][y] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x-1][y] = FIRE;
            }
            else if(x +1 < grid.length && grid[x+1][y] == WATER)
            {
                grid[x][y] = WATER;
                grid[x-1][y] = STEAM;
            }
        }
        //steam
        if(grid[x][y] == STEAM){
            if(x - 1 > 0 && grid[x-1][y] == EMPTY){
                grid[x][y] = EMPTY;
                grid[x-1][y] = STEAM;
            }
        }
    }

    //do not modify
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}

