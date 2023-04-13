//Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
// который запишет эту строку в простой текстовый файл, обработайте исключения.

package task;

import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void writeInFile() {
        String str = bildString();
        String str1 = bildString();
        System.out.println("links: " + str == str1);
        System.out.println("strings: " + str1.equals(str));
        try(FileWriter in = new FileWriter("test.txt")) {
            in.append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String bildString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append("TEST");
        }
        return builder.toString();
//        return "TEST".repeat(100); // короткая запись
    }
}
