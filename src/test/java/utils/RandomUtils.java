package utils;

import docs.RandonUtilsExample;

import static docs.RandonUtilsExample.getRandomEmail;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println("Random string of 10 letters: " + RandonUtilsExample.getRandomString(10));
        System.out.println("Random int between 1234 and 9999999 letters: " + RandonUtilsExample.getRandomInt
                (1234, 999999));
        System.out.println("Random email: " + getRandomEmail());
    }


    }

