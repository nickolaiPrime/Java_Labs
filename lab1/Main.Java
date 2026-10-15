import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public boolean isUpperCase(char x) {
        return Character.isUpperCase(x) && (x >= 'A' && x <= 'Z');
    }

    public boolean isInRange(int a, int b, int num) {
        if (a < b) {
            return num >= a && num <= b;
        } else {
            return num <= a && num >= b;
        }
    }

    public boolean isDivisor(int a, int b) {
        if (a == 0 || b == 0) return false;
        return a % b == 0 || b % a == 0;
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    public int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }

    public boolean sum3(int x, int y, int z) {
        return x + y == z || x + z == y || y + z == x;
    }

    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        } else {
            return sum;
        }
    }

    public String age(int x) {
        if (x % 100 >= 11 && x % 100 <= 14) return x + " лет";
        if (x % 10 == 1) return x + " год";
        if (x % 10 >= 2 && x % 10 <= 4) return x + " года";
        return x + " лет";
    }

    public String day(int x) {
        return switch (x) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "это не день недели";
        };
    }

    public void printDays(String x) {
        x = x.toLowerCase();
        int dayNum = switch (x) {
            case "понедельник" -> 1;
            case "вторник" -> 2;
            case "среда" -> 3;
            case "четверг" -> 4;
            case "пятница" -> 5;
            case "суббота" -> 6;
            case "воскресенье" -> 7;
            default -> 0;
        };

        if (dayNum == 0) {
            System.out.println("это не день недели");
            return;
        }

        for (int i = dayNum; i <= 7; i++) {
            System.out.println(day(i));
        }
    }

    public boolean equalNum(int x) {
        x = Math.abs(x);
        int lastDigit = x % 10;
        x /= 10;
        while (x > 0) {
            if (x % 10 != lastDigit) return false;
            x /= 10;
        }
        return true;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void guessGame(Scanner scanner) {
        Random rand = new Random();
        int target = rand.nextInt(10);
        int attempts = 0;

        System.out.println("Введите число от 0 до 9:");
        while (true) {
            int guess = inputInt(scanner);
            attempts++;
            if (guess == target) {
                System.out.println("Вы угадали!");
                System.out.println("Вы отгадали число за " + attempts + " попытки/попыток");
                break;
            } else {
                System.out.println("Вы не угадали, введите число от 0 до 9:");
            }
        }
    }

    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int[] reverseBack(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return res;
    }

    public int[] concat(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) res[i] = arr1[i];
        for (int i = 0; i < arr2.length; i++) res[arr1.length + i] = arr2[i];
        return res;
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) count++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) res[idx++] = i;
        }
        return res;
    }

    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num >= 0) count++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (int num : arr) {
            if (num >= 0) res[idx++] = num;
        }
        return res;
    }

    public int inputInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            } else {
                System.out.println("Ошибка ввода. Введите целое число:");
                scanner.nextLine();
            }
        }
    }

    public int[] inputArray(Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int size;
        while (true) {
            size = inputInt(scanner);
            if (size >= 0) break;
            System.out.println("Размер не может быть отрицательным.");
        }
        int[] arr = new int[size];
        if (size > 0) {
            System.out.println("Введите " + size + " элементов массива:");
            for (int i = 0; i < size; i++) {
                arr[i] = inputInt(scanner);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать! Вариант №2.");
        while (true) {
            System.out.println("\nВыберете задачу (1-20) или 0 для выхода: ");
            System.out.println("Задание 1: 1 (1.6), 2 (1.7), 3 (1.8), 4 (1.9), 5 (1.10)");
            System.out.println("Задание 2: 6 (2.6), 7 (2.7), 8 (2.8), 9 (2.9), 10 (2.10)");
            System.out.println("Задание 3: 11 (3.6), 12 (3.7), 13 (3.8), 14 (3.9), 15 (3.10)");
            System.out.println("Задание 4: 16 (4.6), 17 (4.7), 18 (4.8), 19 (4.9), 20 (4.10)");
            System.out.print("Ваш выбор: ");

            int choice = main.inputInt(scanner);
            if (choice == 0) {
                System.out.println("Выход...");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("Задача 1.6: Большая буква");
                    System.out.println("Введите символ:");
                    char x = scanner.nextLine().charAt(0);
                    System.out.println("Результат: " + main.isUpperCase(x));
                }
                case 2 -> {
                    System.out.println("Задача 1.7: Диапазон");
                    System.out.println("Введите a, b, num:");
                    int a = main.inputInt(scanner);
                    int b = main.inputInt(scanner);
                    int num = main.inputInt(scanner);
                    System.out.println("Результат: " + main.isInRange(a, b, num));
                }
                case 3 -> {
                    System.out.println("Задача 1.8: Делитель");
                    System.out.println("Введите a, b:");
                    int a = main.inputInt(scanner);
                    int b = main.inputInt(scanner);
                    System.out.println("Результат: " + main.isDivisor(a, b));
                }
                case 4 -> {
                    System.out.println("Задача 1.9: Равенство");
                    System.out.println("Введите a, b, c:");
                    int a = main.inputInt(scanner);
                    int b = main.inputInt(scanner);
                    int c = main.inputInt(scanner);
                    System.out.println("Результат: " + main.isEqual(a, b, c));
                }
                case 5 -> {
                    System.out.println("Задача 1.10: Многократный вызов");
                    System.out.println("Введите первое число:");
                    int currentSum = main.inputInt(scanner);
                    for (int i = 0; i < 4; i++) {
                        System.out.println("Введите следующее число:");
                        int nextNum = main.inputInt(scanner);
                        currentSum = main.lastNumSum(currentSum, nextNum);
                        System.out.println("Промежуточный результат: " + currentSum);
                    }
                    System.out.println("Итоговый результат: " + currentSum);
                }
                case 6 -> {
                    System.out.println("Задача 2.6: Тройная сумма");
                    System.out.println("Введите x, y, z:");
                    int x = main.inputInt(scanner);
                    int y = main.inputInt(scanner);
                    int z = main.inputInt(scanner);
                    System.out.println("Результат: " + main.sum3(x, y, z));
                }
                case 7 -> {
                    System.out.println("Задача 2.7: Двойная сумма");
                    System.out.println("Введите x, y:");
                    int x = main.inputInt(scanner);
                    int y = main.inputInt(scanner);
                    System.out.println("Результат: " + main.sum2(x, y));
                }
                case 8 -> {
                    System.out.println("Задача 2.8: Возраст");
                    System.out.println("Введите возраст:");
                    int x = main.inputInt(scanner);
                    System.out.println("Результат: " + main.age(x));
                }
                case 9 -> {
                    System.out.println("Задача 2.9: День недели");
                    System.out.println("Введите номер дня (1-7):");
                    int x = main.inputInt(scanner);
                    System.out.println("Результат: " + main.day(x));
                }
                case 10 -> {
                    System.out.println("Задача 2.10: Вывод дней недели");
                    System.out.println("Введите день недели (например, 'понедельник'):");
                    String x = scanner.nextLine();
                    main.printDays(x);
                }
                case 11 -> {
                    System.out.println("Задача 3.6: Одинаковость");
                    System.out.println("Введите число x:");
                    int x = main.inputInt(scanner);
                    System.out.println("Результат: " + main.equalNum(x));
                }
                case 12 -> {
                    System.out.println("Задача 3.7: Квадрат");
                    System.out.println("Введите число x:");
                    int x = main.inputInt(scanner);
                    main.square(x);
                }
                case 13 -> {
                    System.out.println("Задача 3.8: Левый треугольник");
                    System.out.println("Введите число x:");
                    int x = main.inputInt(scanner);
                    main.leftTriangle(x);
                }
                case 14 -> {
                    System.out.println("Задача 3.9: Правый треугольник");
                    System.out.println("Введите число x:");
                    int x = main.inputInt(scanner);
                    main.rightTriangle(x);
                }
                case 15 -> {
                    System.out.println("Задача 3.10: Угадайка");
                    main.guessGame(scanner);
                }
                case 16 -> {
                    System.out.println("Задача 4.6: Реверс");
                    int[] arr = main.inputArray(scanner);
                    main.reverse(arr);
                    System.out.println("Результат: " + Arrays.toString(arr));
                }
                case 17 -> {
                    System.out.println("Задача 4.7: Возвратный реверс");
                    int[] arr = main.inputArray(scanner);
                    int[] res = main.reverseBack(arr);
                    System.out.println("Результат: " + Arrays.toString(res));
                }
                case 18 -> {
                    System.out.println("Задача 4.8: Объединение");
                    System.out.println("Массив 1:");
                    int[] arr1 = main.inputArray(scanner);
                    System.out.println("Массив 2:");
                    int[] arr2 = main.inputArray(scanner);
                    int[] res = main.concat(arr1, arr2);
                    System.out.println("Результат: " + Arrays.toString(res));
                }
                case 19 -> {
                    System.out.println("Задача 4.9: Все вхождения");
                    int[] arr = main.inputArray(scanner);
                    System.out.println("Введите искомое число x:");
                    int x = main.inputInt(scanner);
                    int[] res = main.findAll(arr, x);
                    System.out.println("Индексы вхождений: " + Arrays.toString(res));
                }
                case 20 -> {
                    System.out.println("Задача 4.10: Удалить негатив");
                    int[] arr = main.inputArray(scanner);
                    int[] res = main.deleteNegative(arr);
                    System.out.println("Результат: " + Arrays.toString(res));
                }
                default -> System.out.println("Неверное значение.");
            }
        }
        scanner.close();
    }
}
