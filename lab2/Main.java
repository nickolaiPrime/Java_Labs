import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<City> allCities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Лабораторная работа №2, Вариант 2 ===");
            System.out.println("1. Задание 1.2: Человек");
            System.out.println("2. Задание 1.3: Имена");
            System.out.println("3. Задание 2.2: Человек с именем (PersonWithName)");
            System.out.println("4. Задание 3.3: Города");
            System.out.println("5. Задание 4.8: Создаем Города");
            System.out.println("6. Задание 5.5: Дроби");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");
            int choice = readInt(scanner);
            switch (choice) {
                case 1 -> task1_2(scanner);
                case 2 -> task1_3(scanner);
                case 3 -> task2_2(scanner);
                case 4 -> task3_3(scanner);
                case 5 -> task4_8(scanner);
                case 6 -> task5_5(scanner);
                case 0 -> { scanner.close(); return; }
                default -> System.out.println("Неверный пункт.");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int v = scanner.nextInt();
                scanner.nextLine();
                return v;
            }
            System.out.print("Ошибка ввода. Введите целое число: ");
            scanner.nextLine();
        }
    }

    private static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String readOptionalString(Scanner scanner, String prompt) {
        System.out.print(prompt + " (Enter — пропустить): ");
        return scanner.nextLine().trim();
    }

    private static boolean yes(Scanner scanner, String prompt) {
        System.out.print(prompt + " (да/нет): ");
        String ans = scanner.nextLine().trim().toLowerCase();
        return ans.equals("да") || ans.equals("yes") || ans.equals("y");
    }

    private static void task1_2(Scanner scanner) {
        System.out.println("\n--- Задание 1.2: Человек ---");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Клеопатра", 152));
        people.add(new Person("Пушкин", 167));
        people.add(new Person("Владимир", 189));

        for (Person p : people) System.out.println(p);

        while (yes(scanner, "\nДобавить своего человека?")) {
            String name = readString(scanner, "Имя: ");
            System.out.print("Рост: ");
            int h = readInt(scanner);
            Person p = new Person(name, h);
            people.add(p);
            System.out.println("Добавлено: " + p);
        }

        System.out.println("\nИтог:");
        for (Person p : people) System.out.println(p);
    }

    private static void task1_3(Scanner scanner) {
        System.out.println("\n--- Задание 1.3: Имена ---");
        List<Name> names = new ArrayList<>();
        names.add(new Name("Клеопатра"));
        names.add(new Name("Пушкин", "Александр", "Сергеевич"));
        names.add(new Name("Маяковский", "Владимир"));

        for (Name n : names) System.out.println(n);

        while (yes(scanner, "\nДобавить своё имя?")) {
            String surname = readOptionalString(scanner, "Фамилия");
            String first   = readOptionalString(scanner, "Личное имя");
            String patr    = readOptionalString(scanner, "Отчество");

            if (first.isEmpty()) {
                System.out.println("Личное имя обязательно!");
                continue;
            }
            Name n = new Name(surname, first, patr);
            names.add(n);
            System.out.println("Добавлено: " + n);
        }

        System.out.println("\nИтог:");
        for (Name n : names) System.out.println(n);
    }

    private static void task2_2(Scanner scanner) {
        System.out.println("\n--- Задание 2.2: PersonWithName ---");
        List<PersonWithName> people = new ArrayList<>();
        people.add(new PersonWithName(new Name("Клеопатра"), 152));
        people.add(new PersonWithName(new Name("Пушкин", "Александр", "Сергеевич"), 167));
        people.add(new PersonWithName(new Name("Маяковский", "Владимир"), 189));

        for (PersonWithName p : people) System.out.println(p);

        while (yes(scanner, "\nДобавить человека с именем?")) {
            String surname = readOptionalString(scanner, "Фамилия");
            String first   = readOptionalString(scanner, "Личное имя");
            String patr    = readOptionalString(scanner, "Отчество");

            if (first.isEmpty()) {
                System.out.println("Личное имя обязательно!");
                continue;
            }
            Name name = new Name(surname, first, patr);

            System.out.print("Рост: ");
            int h = readInt(scanner);
            PersonWithName p = new PersonWithName(name, h);
            people.add(p);
            System.out.println("Добавлено: " + p);
        }

        System.out.println("\nИтог:");
        for (PersonWithName p : people) System.out.println(p);
    }

    private static void task3_3(Scanner scanner) {
        System.out.println("\n--- Задание 3.3: Города ---");
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        a.addPath(b, 5);  a.addPath(f, 1);  a.addPath(d, 6);
        b.addPath(c, 3);
        c.addPath(d, 4);
        d.addPath(e, 2);
        e.addPath(f, 2);
        f.addPath(b, 1);

        allCities.clear();
        allCities.add(a); allCities.add(b); allCities.add(c);
        allCities.add(d); allCities.add(e); allCities.add(f);

        for (City city : allCities) System.out.println(city);

        if (yes(scanner, "\nДобавить новый город?")) {
            String cityName = readString(scanner, "Название города: ");
            City newCity = new City(cityName);

            while (yes(scanner, "Добавить путь из " + cityName + "?")) {
                System.out.println("Куда?");
                for (int i = 0; i < allCities.size(); i++) {
                    System.out.println((i + 1) + ". " + allCities.get(i).getName());
                }
                System.out.print("Номер: ");
                int idx = readInt(scanner) - 1;
                if (idx < 0 || idx >= allCities.size()) {
                    System.out.println("Неверный номер.");
                    continue;
                }
                int cost;
                while (true) {
                    System.out.print("Стоимость (не может быть отрицательной): ");
                    cost = readInt(scanner);
                    if (cost >= 0) break;
                    System.out.println("Отрицательная стоимость запрещена. Попробуйте снова.");
                }
                newCity.addPath(allCities.get(idx), cost);
            }
            allCities.add(newCity);
            System.out.println("Добавлено: " + newCity);
        }

        System.out.println("\nИтог:");
        for (City city : allCities) System.out.println(city);
    }

    private static void task4_8(Scanner scanner) {
        System.out.println("\n--- Задание 4.8: Создаем Города ---");

        City moscow = new City("Москва");
        System.out.println("Только с названием: " + moscow);

        List<Path> paths = new ArrayList<>();
        paths.add(new Path(new City("СПб"), 500));
        City tver = new City("Тверь", paths);
        System.out.println("С набором путей:  " + tver);

        if (yes(scanner, "\nСоздать свой город?")) {
            String name = readString(scanner, "Название: ");
            if (yes(scanner, "Задать пути?")) {
                List<Path> userPaths = new ArrayList<>();
                List<City> sample = new ArrayList<>();
                sample.add(new City("СПб"));
                sample.add(new City("Москва"));
                sample.add(new City("Казань"));
                System.out.println("Доступные города для пути:");
                for (int i = 0; i < sample.size(); i++) {
                    System.out.println((i + 1) + ". " + sample.get(i).getName());
                }
                while (true) {
                    System.out.print("Номер (0 — закончить): ");
                    int idx = readInt(scanner) - 1;
                    if (idx == -1) break;
                    if (idx < 0 || idx >= sample.size()) {
                        System.out.println("Неверный номер.");
                        continue;
                    }
                    int cost;
                    while (true) {
                        System.out.print("Стоимость (не может быть отрицательной): ");
                        cost = readInt(scanner);
                        if (cost >= 0) break;
                        System.out.println("Отрицательная стоимость запрещена. Попробуйте снова.");
                    }
                    userPaths.add(new Path(sample.get(idx), cost));
                }
                City user = new City(name, userPaths);
                System.out.println("Создано: " + user);
            } else {
                City user = new City(name);
                System.out.println("Создано: " + user);
            }
        }
    }

    private static void task5_5(Scanner scanner) {
        System.out.println("\n--- Задание 5.5: Дроби ---");

        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
        System.out.println(f1 + " + 5 = " + f1.sum(5));
        System.out.println(f1 + " - 5 = " + f1.minus(5));
        System.out.println(f1 + " * 5 = " + f1.multiply(5));
        System.out.println(f1 + " / 5 = " + f1.div(5));
        System.out.println("f1.sum(f2).div(f3).minus(5) = " + f1.sum(f2).div(f3).minus(5));

        System.out.println("\nСвои дроби:");
        Fraction u1 = readFraction(scanner, "Первая");
        Fraction u2 = readFraction(scanner, "Вторая");

        System.out.println("u1 = " + u1 + ", u2 = " + u2);
        System.out.println(u1 + " + " + u2 + " = " + u1.sum(u2));
        System.out.println(u1 + " - " + u2 + " = " + u1.minus(u2));
        System.out.println(u1 + " * " + u2 + " = " + u1.multiply(u2));
        System.out.println(u1 + " / " + u2 + " = " + u1.div(u2));
    }

    private static Fraction readFraction(Scanner scanner, String label) {
        while (true) {
            System.out.println(label + " дробь:");
            System.out.print("  Числитель: ");
            int num = readInt(scanner);
            System.out.print("  Знаменатель (не 0): ");
            int den = readInt(scanner);
            if (den == 0) {
                System.out.println("  Знаменатель не может быть нулем!");
                continue;
            }
            return new Fraction(num, den);
        }
    }
}