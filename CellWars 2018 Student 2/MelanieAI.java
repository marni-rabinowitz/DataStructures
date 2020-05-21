
/**
 * Write a description of class MelanieAI here.
 *
 * @author Melanie Silver
 * @version (a version number or a date)
 */
public class MelanieAI extends CellAI
{
    GridFunctions gF = new GridFunctions();
    @Override
    public String getAIName() {
        // TODO Auto-generated method stub
        return "SporkAI";
    }

    @Override
    public Location select(Grid grid) {
        //Checks for cells that have 3 neighbors and do not contain my AI
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(gF.getNeighbors(r, c, grid) == 3 && grid.getCell(r, c) != getID())
                    return new Location(r, c);
            }
        }
        //Checks for cells that have 2 neighbors and do not contain any AI
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(grid.getCell(r, c) != -1 && gF.getNeighbors(r, c, grid) == 2 && grid.getCell(r, c) != getID())
                    return new Location(r, c);
            }
        }
        //Checks for cells that have 3 neighbors and do not contain any AI
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(grid.getCell(r, c) != -1 && gF.getNeighbors(r, c, grid) == 3 && grid.getCell(r, c) != getID())
                    return new Location(r, c);
            }
        }
        //Checks for cells that have 1 neighbor and do not contain any AI
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(grid.getCell(r, c) != -1 && gF.getNeighbors(r, c, grid) == 1 && grid.getCell(r, c) != getID())
                    return new Location(r, c);
            }
        }
        //checks for cells that have 2 neighbors and do not contain my AI
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(gF.getNeighbors(r, c, grid) == 2 && grid.getCell(r, c) != getID())
                    return new Location(r, c);
            }
        }
        //checks for squares and tries to extend them
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(gF.getNeighbors(r, c, grid) == 3 && grid.getCell(r,c ) != getID())
                    if((gF.getNeighbors(r+1, c, grid) == 3) && (gF.getNeighbors(r, c+1, grid) == 3) && (gF.getNeighbors(r+1, c+1, grid) == 3))
                        return new Location (r-1, c-1);
            }
        }
        //checks for spaces that have my AI as their most common neighbor that doesn't have 3 neighbors
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(grid.getCell(r, c) != -1 && gF.mostCommonNeighbor(r, c, grid) == getID() && gF.getNeighbors(r, c, grid) != 3)
                    return new Location(r, c);
            }
        }
        //checks for cells that are mine and form a square to then extend the square
        for(int r = 0; r < grid.getRows(); r++){
            for(int c = 0; c < grid.getCols(); c++){
                if(gF.getNeighbors(r, c, grid) == 3 && grid.getCell(r, c) == getID()){
                    if((gF.getNeighbors(r+1, c, grid) == 3 && grid.getCell(r+1, c) == getID()) && (gF.getNeighbors(r, c+1, grid) == 3 && grid.getCell(r, c+1) == getID()) && (gF.getNeighbors(r+1, c+1, grid) == 3 && grid.getCell(r+1, c+1) == getID()))
                        return new Location (r-1, c-1);
                }
            }
        }
        //if all else fails return the bottom right corner
        //return new Location((int)(Math.random()*grid.getRows()), (int)(Math.random()*grid.getCols()));
        return new Location(grid.getRows()-1, grid.getCols()-1);
    }
}
