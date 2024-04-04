package org.example;
import java.util.ArrayList;

import static org.example.CreateGraph.calculateDistanceMatrix;
import static org.example.CreateGraph.loadTSPFile;
import static org.example.Greedy.calcGreedy;
import static org.example.ImprovedNearestNeighbor.calcImprovedNN;
import static org.example.RandomSearch.calcRandomSearch;
import static org.example.RandomWalk.calcRandomWalk;
import static org.example.Steepest.calcSteepest;


public class Main {

    public static void main(String[] args) {
        ArrayList<City> cities = loadTSPFile("./pr76.tsp");
        if (cities == null) {
            throw new RuntimeException("No data");
        }

        Double[][] distanceMatrix = calculateDistanceMatrix(cities);

        //System.out.println(calcRandomSearch(distanceMatrix, 10000000000.0));

        //System.out.println(calcRandomWalk(distanceMatrix, 10000000000.0));

        //System.out.println(calcGreedy(distanceMatrix));

        //System.out.println(calcSteepest(distanceMatrix));

        System.out.println(calcImprovedNN(distanceMatrix));

    }
}
