package tdd;

import java.util.Scanner;

public class GeopoliticalZone {

    private String ourState;


    public String getOurState() {
        return ourState;
    }

    public void setOurState(String ourState) {
        this.ourState = ourState;
    }
    public State changeStateToSouthWest(String stateName) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        switch (name.toLowerCase()) {
            case "Benue":
            case "FCT":
            case "Kogi":
            case "Kwara":
            case "Nassarawa":
            case "Niger":
            case "Plateau":
                return State.NorthCentral;
            case "Adamawa":
            case "Bauch":
            case "Borno":
            case "Gombe":
            case "Taraba":
            case "Yobe":
                return State.NORTHEAST;
            case "Kaduna":
            case "Katsina":
            case "Kano":
            case "Kebbi":
            case "Sokoto":
            case "Jigawa":
            case "Zamfar":
                return State.NORTHWEST;
            case "Abia":
            case "Anambra":
            case "Ebonyi":
            case "Enugu":
            case "Imo":
                return State.SOUTHEAST;
            case "Akwa Ibom":
            case "Bayelsa":
            case "Cross River":
            case "Delta":
            case "Edo":
            case "Rivers":
                return State.SOUTHSOUTH;
            case "Ekiti":
            case "Lagos":
            case "Osun":
            case "Ondo":
            case "Ogun":
            case "Oyo":
                return State.SOUTHWEST;
            default:
                return State.UNKNOWN;
        }

    }
}

