package ru.sberbank.jd.webinar02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFileReader {

    public static void main(String[] args)  {

        try (FileReader reader = new FileReader("1.txt")) {

            List<String> list = new ArrayList<>();

            int read;

            while ((read = reader.read()) != -1) {
                list.add("" + read + ", " + (char) read);
            }

            for (String s : list) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally");
        }

    }

}
