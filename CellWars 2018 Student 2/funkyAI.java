public class funkyAI extends CellAI {

    @Override
    public String getAIName() {
        // TODO Auto-generated method stub
        return "Mr Bing Bing AI";
    }

    /**
     * my strategy is to multiply my cells and increase my cell count as much as possible. 
     * I do this by first puttin a cell down where I am the most common neighbor
     * and if that doesnt work, I put a cell down when there are 7 neighbors around the cell
     * I decided on 7 neighbors by trial and error and 7 seemed to multiply my cells the most
     */
    @Override
    public Location select(Grid grid) {
        // TODO Auto-generated method stub
        //return new Location((int)(Math.random()*grid.getRows()), (int)(Math.random()*grid.getCols()));
        //         int row = (int)(Math.random()*grid.getRows());
        //         int col = (int)(Math.random()*grid.getCols());
        GridFunctions gridfunctions = new GridFunctions();

        for(int r = 0; r < grid.getCols(); r++) {
            for(int c = 0; c < grid.getRows(); c++) {
                //                 if(grid.getCell(r, c) == -1)
                // 				return new Location(r, c);
                //                 if(gridfunctions.mostCommonNeighbor(r,c,grid) != getID())
                //                 {
                //                     //                     if(gridfunctions.getNeighbors(r,c,grid) >4)
                //                     return new Location(r, c);
                //                 }
                //                 else if(gridfunctions.getNeighbors(r,c,grid) ==7)
                //                 {
                //                     return new Location(r,c);
                //                 }
                if(grid.getCell(r,c) != -1 && gridfunctions.getNeighbors(r,c,grid) <=4 && grid.getCell(r,c) != getID()) 
                {
                    //                     if(gridfunctions.getNeighbors(r,c,grid) >=4)
                    return new Location(r, c);
                }
                else if(grid.getCell(r,c) != getID() && gridfunctions.getNeighbors(r,c,grid) ==7)
                {
                    return new Location(r,c);
                }
                //2 works
                //                  if(gridfunctions.mostCommonNeighbor(r,c,grid) != getID())
                //                 {
                //                     return new Location(r, c);
                //                 }
                //                 if(gridfunctions.getNeighbors(r,c,grid) != getID())
                //                 {
                //                     return new Location(r, c);
                //                 }
                //                 if(grid.getCell(row, col) == -1)
                //                     return new Location(row, col);
            }
        }
        for(int r = 0; r < grid.getRows(); r++) {
            for(int c = 0; c < grid.getCols(); c++) {
                if(grid.getCell(r,c) != -1 && gridfunctions.mostCommonNeighbor(r,c,grid) == getID() && gridfunctions.getNeighbors(r,c,grid) <=4)
                {
                    return new Location(r, c);
                }
                //                 else if(gridfunctions.getNeighbors(r,c,grid) <=7)
                //                 {
                //                     return new Location(r,c);
                //                 }
                // return new Location(row, col);
                //&& gridfunctions.mostCommonNeighbor(r,c,grid) == getId
            }
        }
        //return new Location(0,0);
        // return new Location((int)(Math.random()*grid.getRows()), (int)(Math.random()*grid.getCols()));
        return new Location(grid.getRows()-1, grid.getCols()-1);
    }///puts a cell when i am the most common neighbor to grow my amount of cells
}
/**
 *   /**
 * Makes an r-pentomino centered on the given location.

public static void makePentomino(ActorWorld world, int x, int y) {
Grid<Actor> grid = world.getGrid();
ArrayList<Location> locs = new ArrayList<Location>();
locs.add(new Location(x-1, y));
locs.add(new Location(x-1, y+1));
locs.add(new Location(x,   y-1));
locs.add(new Location(x,   y));
locs.add(new Location(x+1, y));

for (Location loc: locs) {
LifeRock rock = (LifeRock) grid.get(loc);
rock.setAlive();
}	 
 */

/**
 *  00
 * 00
 *  0
 * 
 */

/**
 * 
 */