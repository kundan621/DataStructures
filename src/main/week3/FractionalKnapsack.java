package main.week3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
       ItemValue[] itemValues=new ItemValue[weights.length];

        for(int i=0;i<weights.length;i++){
            itemValues[i]=new ItemValue(values[i],weights[i],i);
        }

        Arrays.sort(itemValues,(v1,v2)->

        v2.vbw.compareTo(v1.vbw)

        );

        for (ItemValue itemValue: itemValues) {
            if(capacity-(int)itemValue.weight>0){
                value=value+itemValue.value;
                capacity= (int) (capacity -itemValue.weight);
            }else{
                double fraction = ((double)capacity/(double)itemValue.weight);
                value += (itemValue.value*fraction);
                capacity = (int)(capacity - (itemValue.weight*fraction));
                System.out.println(capacity);
                break;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}

class ItemValue{
    double value;
    double weight;
    double index;
    Double vbw;

    public ItemValue(int value, int weight, int index) {
        this.value = value;
        this.weight = weight;
        this.index = index;
        this.vbw = this.value/this.weight;
    }
}
