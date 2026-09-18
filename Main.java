import java.util.Scanner;

public class Main {

    public boolean isUpperCase(char x){
        return Character.isUpperCase(x) && (x >= 'A' && x <= 'Z');
    }

    public boolean isInRange(int a, int b, int num){
        if(a < b){
            return num >= a && num <= b;
        }
        else{
            return num <= a && num >= b;
        }
    }

    public boolean isDivisor(int a, int b){
        return a % b == 0 || b % a == 0;
    }

    public boolean isEqual(int a, int b, int c){
        return a == b && b == c;
    }

    public int lastNumSum(int a, int b){
        return a%10 + b%10;
    }

    public boolean sum3(int x, int y, int z){
        return x+y == z || x+z == y || y+z == x;
    }

    public int sum2(int x, int y){
        if(x + y >= 10 || x + y <= 19){
            return 20;
        }
        else{
            return x+y;
        }
    }

    public String age(int x){
        String result = "";
        if(x%10 == 1 && x != 11) return result + x + " год";
        if((x%10 == 2 || x%10 == 3 || x%10 == 4) && (x != 12 && x != 13 && x != 14)) return result + x + " года";
        else return result + x + " лет";
    }

    public String day(int x){
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

    public void printDays(int x){
        for (int i = x; i < 7; i++) {
            System.out.println(day(i));
        }
    }

    public int inputInt(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            //System.out.print("Введите целое число: ");
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }
            else{
                System.out.println("Ошибка ввода.");
            }
            scanner.nextLine();
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберете задачу (1-20): ");
        int choice = main.inputInt();

        switch(choice){
            case 1:{
                    System.out.println("Введите символ:");
                    char x = scanner.next().charAt(0);
                    System.out.println(main.isUpperCase(x));
                    break;
            }
            case 2:{
                System.out.println("Введите последовательно целые значения для a,b,num: ");
                int a = main.inputInt();
                int b = main.inputInt();
                int num = main.inputInt();
                System.out.println(main.isInRange(a, b, num));
                break;
            }
            case 3:{
                System.out.println("Введите последовательно целые значения для a,b: ");
                int a = main.inputInt();
                int b = main.inputInt();
                System.out.println(main.isDivisor(a, b));
                break;
            }
            case 4:{
                System.out.println("Введите последовательно целые значения для a,b,c: ");
                int a = main.inputInt();
                int b = main.inputInt();
                int c = main.inputInt();
                System.out.println(main.isEqual(a, b, c));
                break;
            }
            case 5:{
                System.out.println("Введите целое число a:");
                int a = main.inputInt();
                for (int i = 0; i < 4; i++) {
                    System.out.println("Введите целое число b:");
                    int b = main.inputInt();
                    a = main.lastNumSum(a, b);
                    System.out.println(a);
                }
                break;
            }
            case 6:{
                System.out.println("Введите последовательно целые значения для x,y,z: ");
                int x = main.inputInt();
                int y = main.inputInt();
                int z = main.inputInt();
                System.out.println(main.sum3(x, y, z));
                break;
            }
            case 7:{
                System.out.println("Введите последовательно целые значения для x,y: ");
                int x = main.inputInt();
                int y = main.inputInt();
                System.out.println(main.sum2(x,y));
                break;
            }
            case 8:{
                System.out.println("Введите целое число x:");
                int x = main.inputInt();
                System.out.println(main.age(x));
                break;
            }
            case 9:{
                System.out.println("Введите целое число x:");
                int x = main.inputInt();
                System.out.println(main.day(x));
            }
            case 10:{
                System.out.println("Введите целое число x:");
                int x = main.inputInt();
                main.printDays(x);
            }
            case 11:{}
            case 12:{}
            case 13:{}
            case 14:{}
            case 15:{}
            case 16:{}
            case 17:{}
            case 18:{}
            case 19:{}
            case 20:{}
            default:{
                System.out.println("Неверное значение.");
            }
        }
    }
}