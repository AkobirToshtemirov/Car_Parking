import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Parking the Car App!");
        System.out.print("Enter the numbers of rows of the parking area: ");
        try (Scanner sc = new Scanner(System.in)) {
            int row = sc.nextInt();

            System.out.print("Enter the numbers of columns of the parking area: ");
            int col = sc.nextInt();

            Car[][] spaces = new Car[row][col];

            Parking parking = new Parking(row, col);
            parking.viewParking(spaces);

            while (true) {
                System.out.println("""
                        1. ENTER_CAR = "1";
                        2. EXIT_CAR = "2";
                        3. FREE_SPACES_COUNT = "3";
                        4. FULL_SPACES_COUNT = "4";
                        5. VIEW_PARKING = "5";
                        6. EXIT = "6";""");
                System.out.print("Choose one of the options above: ");
                String command = sc.next();
                switch (command) {
                    case "1" -> parking.enterCar();
                    case "2" -> parking.exitCar();
                    case "3" -> parking.freePlaces();
                    case "4" -> parking.fullPlaces(parking);
                    case "5" -> parking.viewParking(spaces);
                    case "6" -> {
                        System.out.println("OK, parking is done!");
                        return;
                    }
                    default -> System.out.println("Wrong value is added! Try again!");
                }
            }
        }
    }
}