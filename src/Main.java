import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        double x = 0;
        double y = 0;

        try {
            n = Integer.parseInt(JOptionPane.showInputDialog("Введите размер массивов (n):"));
            x = Double.parseDouble(JOptionPane.showInputDialog("Введите минимальное значение диапазона (x):"));
            y = Double.parseDouble(JOptionPane.showInputDialog("Введите максимальное значение диапазона (y):"));

            if (n <= 0 || x > y) {
                throw new IllegalArgumentException("Некорректные данные. Размер массива должен быть положительным, а x должен быть меньше или равен y.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Некорректные данные. Пожалуйста, введите числовые значения.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double[] array1 = new double[n];
        double[] array2 = new double[n];
        double[] sumArray = new double[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array1[i] = x + (y - x) * random.nextDouble();
            array2[i] = x + (y - x) * random.nextDouble();
            sumArray[i] = array1[i] + array2[i];
        }

        StringBuilder result = new StringBuilder();
        result.append("Массив 1: ");
        for (double v : array1) {
            result.append(String.format("%.2f ", v));
        }
        result.append("\nМассив 2: ");
        for (double v : array2) {
            result.append(String.format("%.2f ", v));
        }
        result.append("\nСуммарный массив: ");
        for (double v : sumArray) {
            result.append(String.format("%.2f ", v));
        }

        JOptionPane.showMessageDialog(null, result.toString(), "Результат", JOptionPane.INFORMATION_MESSAGE);
    }
}