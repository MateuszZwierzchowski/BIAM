package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.example.CreateGraph.calculatePathLength;

public class RandomWalk {

    public static double calcRandomWalk(Double[][] distanceMatrix, double time) {

        long startTime = System.nanoTime();

        int numberOfCities = distanceMatrix.length;
        List<Integer> currentPath = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < numberOfCities; i++) {
            currentPath.add(i);
        }

        Collections.shuffle(currentPath, rand);

        double currentPathLength = calculatePathLength(currentPath, distanceMatrix);


        while(System.nanoTime() - startTime < time) {

            List<Integer> newPath = new ArrayList<>(currentPath);

            randomSwap(newPath);

            double newPathLength = calculatePathLength(newPath, distanceMatrix);

            if (newPathLength < currentPathLength) {
                currentPath = newPath;
                currentPathLength = newPathLength;
            }

        }

        return currentPathLength;

    }

    public static void randomSwap(List<Integer> path) {
        Random rand = new Random();
        int index1 = rand.nextInt(path.size());
        int index2 = rand.nextInt(path.size());

        while (index1 == index2) {
            index2 = rand.nextInt(path.size());
        }
        Collections.swap(path, index1, index2);
    }

}
