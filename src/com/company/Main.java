package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к первому файлу:");
        String file1 = scanner.nextLine();

        System.out.println("Введите путь ко второму файлу:");
        String file2 = scanner.nextLine();

        FileReader reader = new FileReader(file1);
        FileReader reader1 = new FileReader(file2);

        int current;
        String text = "";
        String text1 = "";
        int count = 0;
        while ((current = reader.read()) != -1) {
            text += (char) current;
        }
        while ((current = reader1.read()) != -1) {
            text1 += (char) current;
        }

        int length_max = Math.max(text.length(), text1.length());
        int length_min = Math.min(text.length(), text1.length());

        char text_m[] = text.toCharArray();
        char text1_m[] = text1.toCharArray();
        System.out.println("Отличающиеся символы:");
        for (int i = 0; i < length_min; i++) {
            if (text_m[i] != text1_m[i]) {
                if (count < 100) {
                    System.out.println(text_m[i] + " " + text1_m[i]);
                }
                count++;
            }
        }
        if (text.length() > text1.length()) {
            for (int i = length_min; i < length_max; i++) {
                if (count < 100) {
                    System.out.println("  " + text_m[i]);
                }
                count++;
            }
        }
        else {
            for (int i = length_min; i < length_max; i++) {
                if (count < 100) {
                    System.out.println("  " + text1_m[i]);
                }
                count++;
            }
        }
        if (count > 100) {
            System.out.println("Выведено только 100 различий");
        }
        System.out.println("Всего: " + count);
    }
}
