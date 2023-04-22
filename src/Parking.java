import java.util.Scanner;

import static java.lang.System.in;

public class Parking {
    private static final Scanner sc = new Scanner(in);

    private final Car[][] spaces;

    public Parking(int row, int col) {
        spaces = new Car[row][col];
    }

    public void enterCar() {
        Car car = createCar();
        enterCar(car);
    }

    private void enterCar(Car car){
        while(true) {
            viewParking(spaces);
            System.out.print("Enter row number: ");
            int row = Integer.parseInt(sc.nextLine());
            System.out.print("Enter col number: ");
            int col = Integer.parseInt(sc.nextLine());

            if(spaces[row][col] == null){
                spaces[row][col] = car;
                viewParking(spaces);
                return;
            } else{
                System.out.println("This place is already taken by somebody. Please choose another space!");
            }
        }
    }

    public void exitCar(){
        System.out.print("Enter the row number: ");
        int row = sc.nextInt();

        System.out.print("Enter the column number: ");
        int col = sc.nextInt();

        if(spaces[row][col] != null) {
            spaces[row][col] = null;
            viewParking(spaces);
            System.out.println("Car is exited from parking area!");
        } else
            System.out.println("There is no car in this parking space.");

    }
    public void freePlaces(){
        int count = 0;
        for(Car[] space : spaces)
            for(Car car : space)
                if(car == null)
                    count++;

        viewParking(spaces);
        System.out.println("Free places available: " + count);
    }
    public void fullPlaces(Parking parking){
        viewParking(spaces);
        System.out.println("Full Spaces in the parking area: " + parking.spaces.length * parking.spaces[0].length);
    }

    private Car createCar(){
        System.out.println("Choose car type (Copy and paste car): ");
        System.out.print("1) \uD83D\uDE97 ");
        System.out.print("2) \uD83D\uDE95 ");
        System.out.print("3) \uD83D\uDE9C ");
        System.out.print("4) \uD83D\uDE9B ");
        System.out.print("5) \uD83D\uDE9A ");
        System.out.print("6) \uD83C\uDFCD ");
        System.out.print("7) \uD83D\uDEFA");
        System.out.print("8) \uD83C\uDFCE ");
        System.out.print("Enter the number of the car: ");

        String carType = sc.nextLine();
        String resCar = "";
        switch (carType) {
            case "1" -> resCar = " \uD83D\uDE97 ";
            case "2" -> resCar = " \uD83D\uDE95 ";
            case "3" -> resCar = " \uD83D\uDE9C ";
            case "4" -> resCar = " \uD83D\uDE9B ";
            case "5" -> resCar = " \uD83D\uDE9A ";
            case "6" -> resCar = " \uD83C\uDFCD ";
            case "7" -> resCar = " \uD83D\uDEFA ";
            case "8" -> resCar = " \uD83C\uDFCE ";
            default -> System.out.println("Wrong value is chosen. Try again!");
        }

        return new Car(resCar);
    }

    public void viewParking(Car[][] spaces) {
        for(Car[] space : spaces) {
            for(Car car : space){
                if(car == null)
                    System.out.print(" ✅ ");
                else
                    System.out.print(car.getType());
            }
            System.out.println();
        }
    }
}
