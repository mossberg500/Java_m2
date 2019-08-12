package homework904;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class Machine {

    private Deque<Human> dequeByCola;
    private int quantity;

    public Machine() {

    }

    public Machine(int quantity) {
        this.quantity = quantity;
        dequeByCola = new ArrayDeque<>();
        dequeByCola.addLast(new Human("Sheldon"));
        dequeByCola.addLast(new Human("Leonard"));
        dequeByCola.addLast(new Human("Volovitc"));
        dequeByCola.addLast(new Human("Kutrapalli"));
        dequeByCola.addLast(new Human("Penny"));
    }

    public Deque<Human> getDequeByCola() {
        return dequeByCola;
    }

    public Deque<Human> giveCola() {
        int counter = 0;
        while (counter < quantity) {
            Human client = dequeByCola.pollFirst();
            if (null != client) {
                try {
                    Human newClient = (Human) client.clone();
                    dequeByCola.addLast(client);
                    dequeByCola.addLast(newClient);
                    counter++;
                } catch (CloneNotSupportedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return dequeByCola;
    }


    public class Human implements Cloneable {

        private String name;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }



        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Humen{" + "name=" + name + '}';
        }



    }
}
