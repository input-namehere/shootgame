import java.util.Scanner;

public class Enemy {
    private int x; // x-coordinate
    private int y; // y-coordinate
    private String direction; // current direction

    public Enemy(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveForward(int steps) {
        // Update coordinates based on the current direction
        switch (direction) {
            case "north":
                y += steps;
                break;
            case "south":
                y -= steps;
                break;
            case "east":
                x += steps;
                break;
            case "west":
                x -= steps;
                break;
        }
    }

    public void moveBackward(int steps) {
        // Update coordinates based on the opposite direction
        switch (direction) {
            case "north":
                y -= steps;
                break;
            case "south":
                y += steps;
                break;
            case "east":
                x -= steps;
                break;
            case "west":
                x += steps;
                break;
        }
    }

    public void turn(String directionChange) {
        // Update the direction based on the turn command
        if (directionChange.equals("left")) {
            switch (direction) {
                case "north":
                    direction = "west";
                    break;
                case "south":
                    direction = "east";
                    break;
                case "east":
                    direction = "north";
                    break;
                case "west":
                    direction = "south";
                    break;
            }
        } else if (directionChange.equals("right")) {
            switch (direction) {
                case "north":
                    direction = "east";
                    break;
                case "south":
                    direction = "west";
                    break;
                case "east":
                    direction = "south";
                    break;
                case "west":
                    direction = "north";
                    break;
            }
        }
    }

    public String getOrientation() {
        return direction;
    }

    public static void main(String[] args) {
        Enemy enemy = new Enemy(0, 0, "north");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            if (command.startsWith("forward")) {
                int steps = Integer.parseInt(command.split(" ")[1]);
                enemy.moveForward(steps);
            } else if (command.startsWith("back")) {
                int steps = Integer.parseInt(command.split(" ")[1]);
                enemy.moveBackward(steps);
            } else if (command.equals("turn left")) {
                enemy.turn("left");
            } else if (command.equals("turn right")) {
                enemy.turn("right");
            } else if (command.equals("orientation")) {
                System.out.println("Current direction: " + enemy.getOrientation());
            }

            System.out.println("Current position: (" + enemy.x + ", " + enemy.y + ")");
        }
    }
}
