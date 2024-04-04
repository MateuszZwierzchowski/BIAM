package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.example.CreateGraph.calculatePathLength;

public class RandomSearch {

    public static double calcRandomSearch(Double[][] distanceMatrix, double time) {

        long startTime = System.nanoTime();

        int numberOfCities = distanceMatrix.length;
        double bestPathLength = Double.MAX_VALUE;
        Random rand = new Random();


        while(System.nanoTime() - startTime < time) {

            List<Integer> currentPath = new ArrayList<>();

            for (int i = 0; i < numberOfCities; i++) {
                currentPath.add(i);
            }

            Collections.shuffle(currentPath, rand);

            double currentPathLength = calculatePathLength(currentPath, distanceMatrix);

            if (currentPathLength < bestPathLength) {
                bestPathLength = currentPathLength;
            }

        }

        return bestPathLength;

    }

}
