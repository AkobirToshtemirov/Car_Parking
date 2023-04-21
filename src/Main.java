import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Parking the Car App!");
        System.out.print("Enter the numbers of rows of the parking area: ");

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        System.out.print("Enter the numbers of columns of the parking area: ");
        int col = sc.nextInt();

        Parking parking = new Parking(row, col);

        while(true){
            System.out.println("1. Enter car \n" +
                    "2. Exit car \n" +
                    "3. Free places count \n" +
                    "4. Full places count \n" +
                    "5. View parking \n" +
                    "6. Exit");
            System.out.print("Choose one of the options above: ");
            String command = sc.next();
            switch (command) {
                case "1" -> parking.enterCar();
                case "2" -> parking.exitCar();
                case "3" -> parking.freePlaces();
                case "4" -> parking.fullPlaces(parking);
                case "5" -> parking.viewParking();
                case "6" -> {
                    System.out.println("OK, parking is done!");
                    return;
                }
                default -> System.out.println("Wrong value is added! Try again!");
            }
        }
    }
}