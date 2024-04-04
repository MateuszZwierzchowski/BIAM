package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateGraph {

    public static ArrayList<City> loadTSPFile(String filePath) {
        ArrayList<City> cities = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("NODE_COORD_SECTION")) {
                    while (scanner.hasNext()) {
                        if(scanner.hasNextInt()) {
                            int id = scanner.nextInt();
                            int x = scanner.nextInt();
                            int y = scanner.nextInt();
                            cities.add(new City(id, x, y));
                        } else {
                            scanner.next();
                        }

                    }
                    break;
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("An error occurred while loading the TSP file.");
            e.printStackTrace();
            return null;
        }
        return cities;
    }

    public static Double[][] calculateDistanceMatrix(ArrayList<City> cities) {
        int size = cities.size();
        Double[][] distanceMatrix = new Double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    distanceMatrix[i][j] = 0.0;
                } else {
                    City city1 = cities.get(i);
                    City city2 = cities.get(j);
                    distanceMatrix[i][j] = city1.distanceTo(city2);
                }

            }

        }
        return distanceMatrix;
    }

    public static double calculatePathLength(List<Integer> path, Double[][] distanceMatrix) {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            length += distanceMatrix[path.get(i)][path.get(i + 1)];
        }

        length += distanceMatrix[path.get(path.size() - 1)][path.get(0)];
        return length;
    }

}
