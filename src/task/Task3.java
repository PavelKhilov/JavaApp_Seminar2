// Напишите метод, который вернет содержимое текущей папки в виде массива строк.
// Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции.
// В случае возникновения исключения, оно должно записаться в лог-файл.

package task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task3 {
    private static final Logger LOG = Log.log(Task3.class.getName());
    public static void write (String path) {
        try(FileWriter in = new FileWriter("task3.txt")) {
            String[] data = getFileInFolder(path);
            for (String datum : data) {
                in.append(datum);
            }
            LOG.log(Level.INFO, "Files names is recorded! :)");
//            throw new IOException("Error");
        } catch (IOException e) {
            LOG.log(Level.INFO, e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static String[] getFileInFolder(String path) {
        File dir = new File(path);
        String[] result = null; // = new String[0];
        File[] files;
        if (dir.isDirectory()) {
            files = dir.listFiles();
            if (files != null) {
                result = new String[files.length];
                for (int i = 0; i < result.length; i++) {
                    String name = files[i].getName();
                    if (files[i].isFile()) {
                        System.out.println("\tFile - " + name);
                    } else {
                        System.out.println("Directory - " + name);
                    }
                    result[i] = name;
                }
            }
        } else {
            System.out.println(dir.getName() + " not a directory");
        }
        return result;
    }
}
