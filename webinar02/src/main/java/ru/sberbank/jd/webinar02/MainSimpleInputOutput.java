package ru.sberbank.jd.webinar02;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSimpleInputOutput {

    public static void main(String[] args) {
        PrintStream out = System.out;
        out.println("Hello");

        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            list.add(s);
        }

        for (String s : list) {
            System.out.println(s);
        }

    }

}
