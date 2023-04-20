import java.util.Scanner;

public class Parking {
    private static Scanner sc = new Scanner(System.in);

    private Car[][] spaces;

    public Parking(int row, int col) {
        spaces = new Car[row][col];
    }

    public void enterCar() {
        Car car = createCar();
        enterCar(car);
    }

    private void enterCar(Car car){
        while(true) {
            viewParking();
            System.out.print("Enter row number: ");
            int row = Integer.parseInt(sc.nextLine());
            System.out.print("Enter col number: ");
            int col = Integer.parseInt(sc.nextLine());

            if(spaces[row][col] == null){
                spaces[row][col] = car;
                return;
            } else{
                System.out.println("This place is already taken by somebody. Please choose another space!");
            }
        }
    }

    public void exitCar(){}
    public void freePlaces(){}
    public void fullPlaces(){}

    private Car createCar(){
        System.out.println("Choose car type (Copy and paste car): ");
        System.out.print("1) \uD83D\uDE97 ");
        System.out.print("2) \uD83D\uDE95 ");
        System.out.print("3) \uD83D\uDE9C ");
        System.out.println("4) \uD83D\uDE9B ");
        System.out.print("Enter the number of the car: ");

        String carType = sc.nextLine();
        Car car = new Car(carType);
        return car;
    }

    public void viewParking() {
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
