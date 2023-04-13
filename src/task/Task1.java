//Дано четное число N (>0) и символы c1 и c2.
// Написать метод, который вернет строку длины N,
// которая состоит из чередующихся символов c1 и c2, начиная с c1.

package task;

public class Task1 {
    public static String printString(int n, char a, char b) {
        StringBuilder str  = new StringBuilder();
        for (int i = 0; i < n/2; i++) {
            str.append(a);
            str.append(b);
        }
        if (n % 2 != 0) {
            str.append(a);
        }
        return str.toString();
    }
}
