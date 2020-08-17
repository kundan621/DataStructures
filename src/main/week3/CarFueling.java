

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int fullsize=tank;
        int travel=0;
        int i=0;
        int minrefil=0;
        while(travel!=dist){
            if(i<stops.length) {
                if (stops[i] - travel <= tank) {
                    tank = tank - travel;
                    travel = stops[i++];
                    continue;
                } else {
                    tank = fullsize;
                    if (travel + tank > stops[i]) {
                        travel = stops[i++];
                        minrefil++;
                    } else {
                        minrefil = -1;
                        break;
                    }
                }
            }else{
                if(travel+tank<dist)
                    minrefil=-1;
                travel=dist;
            }
        }


        return minrefil;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
