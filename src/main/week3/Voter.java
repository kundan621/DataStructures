package main.week3;

import java.util.Scanner;

public class Voter {
    public static void main(String[] args) {
        System.out.println("Enter number of inputs");
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        char[] charArray=new char[number];
        System.out.println("Enter characters");
        Scanner sc1=new Scanner(System.in);
        for(int i=0;i<number;i++){
            charArray[i]=sc1.next().charAt(0);
        }

        int j=0;
        int gapIndex[]=new int[charArray.length];
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='-')
                gapIndex[j++]=i;
        }
        for(int k=0;k<gapIndex.length;k++){
            int currentIndex=gapIndex[k];

            if(currentIndex!=0)
            {

                //find last consecutive gap index

                int p = getLastConsecutiveIndexOfGapIndex(gapIndex, k);
                int lastConsecutiveIndex=gapIndex[p];
          //      System.out.println(gapIndex[k]+"   "+lastConsecutiveIndex);

                while(lastConsecutiveIndex>currentIndex) {
                    if (charArray[currentIndex - 1] == 'B' && charArray[lastConsecutiveIndex + 1] == 'A') {
                        charArray[currentIndex] = 'B';
                        charArray[lastConsecutiveIndex] = 'A';
                        gapIndex[p] = 0;

                        currentIndex++;
                        lastConsecutiveIndex--;



                    }
                    if(charArray[currentIndex-1]=='-'||charArray[currentIndex-1]=='A'||(lastConsecutiveIndex!=charArray.length-1 && charArray[lastConsecutiveIndex+1]=='B'))
                        break;
                }

            }
        }
        System.out.println();
        int countA=0;
                int countB=0;
        for(char c:charArray){
            if(c=='A')
                countA++;
            else if(c=='B')
                countB++;
        }
        if(countA>countB)
            System.out.println("A wins");
        else if(countB>countA)
            System.out.println("B wins");
        else
            System.out.println("coalition government");

    }
    //finds the last consecutive index of -
    private static int getLastConsecutiveIndexOfGapIndex(int[] gapIndex, int k) {
        int  p=k;
        while(gapIndex[p+1]==gapIndex[p]+1){
            ++p;
        }
        return p;
    }
}
