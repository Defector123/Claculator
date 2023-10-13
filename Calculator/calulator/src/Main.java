import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Введите операцию (+, -, *, /) и два числа через пробел (или 'q' для выхода):");
            String input = scan.nextLine();

            if (input.equals("q")) {
                System.out.println("Программа завершена.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Ошибка: введите операцию и два числа через пробел!");
                continue;
            }

            String operatorInput = parts[1];
            if (!"+-*/".contains(operatorInput) || operatorInput.length() != 1) {
                System.out.println("Ошибка: неверная операция!");
                continue;
            }

            double number1, number2;
            try {
                number1 = Double.parseDouble(parts[0]);
                number2 = Double.parseDouble(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числовые значения!");
                continue;
            }

            double result = 0;

            switch (operatorInput.charAt(0)) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        System.out.println("Ошибка: деление на ноль!");
                        continue;
                    }
                    break;
            }

            System.out.println("Результат: " + result);
        }
    }
}
