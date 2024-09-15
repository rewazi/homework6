package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enum Month {
            Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь
        }

        int[][] myYear = new int[12][];
        myYear[0] = new int[31];
        myYear[1] = new int[28];
        myYear[2] = new int[31];
        myYear[3] = new int[30];
        myYear[4] = new int[31];
        myYear[5] = new int[30];
        myYear[6] = new int[31];
        myYear[7] = new int[31];
        myYear[8] = new int[30];
        myYear[9] = new int[31];
        myYear[10] = new int[30];
        myYear[11] = new int[31];


        Random random = new Random();
        for (int i = 0; i < myYear.length; i++) {
            for (int j = 0; j < myYear[i].length; j++) {
                if (i < 2 || i == 11) {
                    myYear[i][j] = random.nextInt(31) - 30;  // От -30 до 0
                } else if (i >= 2 && i <= 4) {
                    myYear[i][j] = random.nextInt(21) - 10;  // От -10 до 10
                } else if (i >= 5 && i <= 7) {
                    myYear[i][j] = random.nextInt(36) + 15;  // От 15 до 35
                } else {
                    myYear[i][j] = random.nextInt(21) - 5;  // От -5 до 15
                }
            }
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите месяц (от 1 до 12):");
        int month = scanner.nextInt() - 1;
        System.out.println("Введите день (от 1 до " + myYear[month].length + "):");
        int day = scanner.nextInt() - 1;

        System.out.println("Температура на " + (month + 1) + "-" + (day + 1) + ": " + myYear[month][day] + "°C");


        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        String hottestDay = "", coldestDay = "";

        for (int i = 0; i < myYear.length; i++) {
            for (int j = 0; j < myYear[i].length; j++) {
                if (myYear[i][j] > maxTemp) {
                    maxTemp = myYear[i][j];
                    hottestDay = (j + 1) + " " + Month.values()[i];
                }
                if (myYear[i][j] < minTemp) {
                    minTemp = myYear[i][j];
                    coldestDay = (j + 1) + " " + Month.values()[i];
                }
            }
        }

        System.out.println("Самая теплая погода была: " + hottestDay + ", температура: " + maxTemp + "°C");
        System.out.println("Самая холодная погода была: " + coldestDay + ", температура: " + minTemp + "°C");


        for (int i = 0; i < myYear.length; i++) {
            int sum = 0;
            for (int j = 0; j < myYear[i].length; j++) {
                sum += myYear[i][j];
            }
            double avgTemp = (double) sum / myYear[i].length;
            System.out.println("Средняя температура за " + Month.values()[i] + ": " + String.format("%.2f", avgTemp) + "°C");
        }

        scanner.close();
    }
}