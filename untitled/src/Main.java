import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> results = new ArrayList<>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double num1 = getPositiveDouble(scanner);

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = getOperator(scanner);

            System.out.print("두 번째 숫자를 입력하세요: ");
            double num2 = getPositiveDouble(scanner);

            double result = performCalculation(num1, num2, operator);
            results.add(result);

            System.out.println("결과: " + result);
            System.out.println("저장된 결과 개수: " + results.size());

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "remove":
                    if (!results.isEmpty()) {
                        results.remove(0);
                        System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("저장된 결과가 없습니다.");
                    }
                    break;
                case "inquiry":
                    System.out.println("저장된 결과:");
                    for (double r : results) {
                        System.out.println(r);
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    public static double getPositiveDouble(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            double value = Double.parseDouble(input);
            if (value >= 0) {
                return value;
            } else {
                System.out.println("양의 정수를 입력해주세요.");
            }
        }
    }

    public static char getOperator(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (isValidOperator(op)) {
                    return op;
                } else {
                    System.out.println("사칙연산 기호(+, -, *, /)를 입력해주세요.");
                }
            } else {
                System.out.println("사칙연산 기호를 한 개만 입력해주세요.");
            }
        }
    }

    public static boolean isValidOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    public static double performCalculation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                }
            default:
                System.out.println("지원하지 않는 연산자입니다.");
                return 0;
        }
    }
}
