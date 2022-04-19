import java.util.Scanner;

public class Elevator {

    private int currentFloor = 1;
    private int maxFloor;
    private int minFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }
    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }
    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Ошибка!");
        } else if (floor > currentFloor) {
            for (currentFloor = getCurrentFloor(); currentFloor < floor; moveUp())
                System.out.println(currentFloor);
            if (currentFloor == floor) {
                System.out.println(floor + " Этаж. Выходите");
            }
        } else if (floor < currentFloor) {
            for (currentFloor = getCurrentFloor(); currentFloor > floor; moveDown())
                System.out.println(currentFloor);
            if (currentFloor == floor) {
                System.out.println(floor + " Этаж. Выходите");
            }
        }
    }
    public static void main(String[] args) {

        Elevator elevator = new Elevator(-3, 26);

        while (true) {
            System.out.println("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
    }
}