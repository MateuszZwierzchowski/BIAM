package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.example.CreateGraph.calculatePathLength;

public class Steepest {

    public static double swapAndCalculateLength(List<Integer> path, Double[][] distanceMatrix, int i, int j) {
        List<Integer> newPath = new ArrayList<>(path);
        java.util.Collections.swap(newPath, i, j);
        return calculatePathLength(newPath, distanceMatrix);
    }

    public static double calcSteepest(Double[][] distanceMatrix) {

        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < distanceMatrix.length; i++) {
            path.add(i);
        }

        Random rand = new Random();
        Collections.shuffle(path, rand);

        boolean improvement = true;
        while (improvement) {
            improvement = false;
            double currentPathLength = calculatePathLength(path, distanceMatrix);
            for (int i = 0; i < path.size() - 1; i++) {
                for (int j = i + 1; j < path.size(); j++) {
                    double potentialPathLength = swapAndCalculateLength(path, distanceMatrix, i, j);
                    if (potentialPathLength <= currentPathLength) {
                        //dodać licznik ==
                        //losowe wybieranie swapu zamiast zawsze ostatniego
                        java.util.Collections.swap(path, i, j);
                        currentPathLength = potentialPathLength;
                        improvement = true;
                    }
                }
            }
        }

        return calculatePathLength(path, distanceMatrix);
    }
}


