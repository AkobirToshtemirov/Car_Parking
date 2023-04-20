import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(2, 5);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Enter car \n" +
                    "2. Exit car \n" +
                    "3. Free places count \n" +
                    "4. Full places count \n" +
                    "5. View parking \n" +
                    "6. Exit");
            String command = sc.next();
            switch (command) {
                case "1" -> parking.enterCar();
                case "2" -> parking.exitCar();
                case "3" -> parking.freePlaces();
                case "4" -> parking.fullPlaces();
                case "5" -> parking.viewParking();
                case "6" -> {
                    return;
                }
                default -> System.out.println("Wrong value is added! Try again!");
            }
        }
    }
}