package com.example.wakeInterval;

import java.util.Arrays;
import java.util.Random;

public class WakelockInterval {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int sample = 1000000;
        int count;
        WakelockInterval robot = new WakelockInterval();
        for (int m = 1; m <= 10; m++) {
            for (int n = 1; n <= m; n++) {
                count = 0;
                for (int i = 0; i < sample; i++) {
                    if (robot.judge(n, m) == true) {
                        count++;
                    }
                }
                System.out.println("When m=" + m + " and n=" + n + ",the probability that there exist one spacing large than 1 is：" + count * 1.0 / sample);
            }
        }
    }

    private boolean judge(int n, int m) {
        int points = 10000 * n;//The length of circle
        int unit = 10000;
        Random r = new Random();
        int[] array = new int[m+1];
        // generate m-1 random points
        for (int i = 0; i < m ; i++) {
            array[i] = r.nextInt(points);
        }
        Arrays.sort(array);
        for (int i = 0; i < m -1 ; i++) {
            if (array[i + 1] - array[i] >= unit) {
                return true;
            }
        }

        if (points - array[m-1] + array[0] >= unit) {
            return true;
        }

        return false;
    }

}
