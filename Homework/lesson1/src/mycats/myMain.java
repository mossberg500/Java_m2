package mycats;

public class myMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("siberian", "black", "Mursik", 6, 11, true);
        Cat cat2 = new Cat("abyssinian cat", "grey", "Markiz", 5, 6.5, true);
        Cat cat3 = new Cat("bengal cat", "red", "Sally", 7, 4.5, false);

        System.out.println(cat1.eatsMeat(true));
        cat1.setPlayful(true);
        System.out.println(cat1.play());
        System.out.println(cat1);

        System.out.println(cat2.eatsMeat(true));
        cat1.setPlayful(false);
        System.out.println(cat2.play());
        System.out.println(cat2);

        System.out.println(cat3.eatsMeat(false));
        cat1.setPlayful(true);
        System.out.println(cat3.play());
        System.out.println(cat3);
    }
}
