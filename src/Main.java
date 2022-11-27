public class Main {
    public static void main(String[] args) {

        SeaBoard s = new SeaBoard();

        s.shoot(9,6, "h");
        s.shoot(9,7, "h");
        s.shoot(9,8, "h");
        s.shoot(9,9, "d");

        s.getField();
        s.getField();
        s.getField();


    }
}