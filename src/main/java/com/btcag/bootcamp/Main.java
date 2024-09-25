package com.btcag.bootcamp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //System.out.println(immerPositiv(-5));

        //System.out.println(quadratischeGleichungen(2, 2.5, 1));

        //System.out.println(schaltJahre(2024));

        //System.out.println(sort(new int[]{5, 13, 6, 20, 11, 2}));

        //System.out.println(fibonacci(20));

        //System.out.println(
        //        tuermeVonHanoi(4, new byte[]{1, 2, 3, 4}, new byte[]{0, 0, 0, 0}, new byte[]{0, 0, 0, 0}));

        VierGewinnt.start();
    }

    private static String tuermeVonHanoi(int n, byte[] start, byte[] ablage, byte[] ziel) {
        if (n == 1) {
            move(start, ziel);
            return "";
        } else {
            tuermeVonHanoi(n - 1, start, ziel, ablage);

            move(start, ziel);
            printTowers(start, ablage, ziel);

            tuermeVonHanoi(n - 1, ablage, start, ziel);

            return "Endergebnis: " + arrayToString(ziel);
        }
    }

    private static void move(byte[] von, byte[] zu) {
        for (int i = 0; i < von.length; i++) {
            if (von[i] != 0) {
                for (int j = zu.length - 1; j >= 0; j--) {
                    if (zu[j] == 0) {
                        zu[j] = von[i];
                        von[i] = 0;
                        return;
                    }
                }
            }
        }
    }

    private static void printTowers(byte[] start, byte[] ablage, byte[] ziel) {
        System.out.println("Start: " + arrayToString(start));
        System.out.println("Ablage: " + arrayToString(ablage));
        System.out.println("Ziel: " + arrayToString(ziel));
        System.out.println("----------");
    }

    private static String arrayToString(byte[] input) {
        String result = "";
        for (byte i: input) {
            result += i;
        }
        return result;
    }

    private static long fibonacci(int limit) {
        if (limit < 2) return 1;
        else return fibonacci(limit - 1) + fibonacci(limit - 2);
    }

    private static String sort(int[] input) {
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 0; i < input.length; i++) {
                if (i < input.length - 1 && input[i] > input[i + 1]) {
                    int temp = input[i + 1];
                    input[i + 1] = input[i];
                    input[i] = temp;
                    notSorted = true;
                }
            }
        }

        String result = "";

        for (int i : input) {
            result += i + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    private static boolean schaltJahre(int currentYear) {
        return currentYear % 4 == 0 && !(currentYear % 100 == 0 && currentYear % 400 != 0) ? true : false;
    }

    private static byte quadratischeGleichungen(double a, double b, double c) {
        double discriminate = Math.sqrt(b * b - 4 * a * c);//mir ist bewusst, dass die Math Klasse illegal ist
        double nullEins = (-b + discriminate) / 2 * a;//ich sehe allerdings keine alternative
        double nullZwei = (-b - discriminate) / 2 * a;
        if (nullEins == nullEins || nullZwei == nullZwei) {
            if (nullEins == nullEins && nullZwei == nullZwei) return 2;
            return 1;
        } else return 0;
    }

    private static int immerPositiv(int input) {
        return input < 0 ? -input : input;
    }
}