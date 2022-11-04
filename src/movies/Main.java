package movies;

import movies.HorrorMovie;
import movies.Movie;
import movies.OrderLine;
import movies.SciFiMovie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> avatarCast = new ArrayList<>();
        avatarCast.add("Actor1");
        avatarCast.add("Actor2");
        Movie avatar = new SciFiMovie("Avatar", 2009, 8.8, avatarCast, 4);

        List<String> itCast = new ArrayList<>(Arrays.asList("Actor1", "Actor2"));
        Movie it = new HorrorMovie("IT", 1980, 7.2, itCast, 7, 2);

        OrderLine orderLine1 = new OrderLine(avatar, 3);
        OrderLine orderLine2 = new OrderLine(it, 4);

        System.out.println(orderLine1.calculatePrice());
        System.out.println(orderLine2.calculatePrice());
    }
}