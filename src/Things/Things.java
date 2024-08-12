package Things;

public class Things {
    private String name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String sound;
    private String color;

    public Things(String name, String sound, String color) {
        this.name = name;
        this.sound = sound;
        this.color = color;
    }

    public void animalCanMove() {

    }
}
