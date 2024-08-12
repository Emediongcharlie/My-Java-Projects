package tdd;

import java.util.Scanner;

public class GeopoliticalZoneCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter state: ");
        String state = sc.nextLine();

        GeopoliticalZone zone = new GeopoliticalZone();
        System.out.println("The state is " + state + " and the zone is " + zone.toString());


    }
}
