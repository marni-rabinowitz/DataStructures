PROJECT TITLE: Traveling Salesperson Problem
PURPOSE OF PROJECT: Implement two greedy heuristics in the attempt to find
an optimal solution to the Traveling Salesperson Problem
DATE: 10/18/2017
AUTHOR:Matt Schwartz and Melanie Silver
ALGORITHM DESCRIPTIONS: 
    insertNearest()
        This method inserts a point next to the point that is closest to the point you are adding by checking which point is 
    closest to the added point
    Big ): N^3
    insertSmallest()
        This inserts a point at every spot possible and calculates the total distance of all of those lists and finds the smallest distance
    Big O: N^2