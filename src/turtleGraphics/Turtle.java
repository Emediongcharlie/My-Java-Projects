package turtleGraphics;

public class Turtle {

    Direction direction;
    private Boolean newDirection;
    Position position;

    public boolean penIsUp() {
        return true;
    }

    public boolean penIsDown() {
        return true;
    }

    public Direction turtleAtEast() {
        direction = Direction.EAST;
        return direction;
    }

    public Direction turtleTurnedToTheSouth() {
        direction = Direction.SOUTH;
        return direction;
    }

    public Direction turtleTurnedToTheWest() {
        direction = Direction.WEST;
        return direction;
    }

    public Direction turtleTurnedLeftToTheNorth() {
        direction = Direction.NORTH;
        return direction;
    }

    public void changeDir(){
        if(turtleAtEast() == Direction.WEST) direction = Direction.NORTH;
        if(turtleAtEast() == Direction.SOUTH) direction  = Direction.WEST;
        if(turtleAtEast() == Direction.EAST) direction  = Direction.SOUTH;
    }

    public Direction turtleTurnedLeftToTheWest() {
        direction = Direction.WEST;
        return direction;
    }

    public Position moveForward(int numberOfSteps) {
//        if(position.column == position.column - 1){return position;}
        if(position.row == position.row - 1){return position;}
        return position;
    }
}
