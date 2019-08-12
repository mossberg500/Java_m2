package homework904;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Machine {

    private Deque<Human> queueByCola;
    private int quantity;

    public Machine() {

    }

    public Machine(int quantity) {
        this.quantity = quantity;
        queueByCola = new ArrayDeque<>();
        queueByCola.addLast(new Human("Sheldon"));
        queueByCola.addLast(new Human("Leonard"));
        queueByCola.addLast(new Human("Volovitc"));
        queueByCola.addLast(new Human("Kutrapalli"));
        queueByCola.addLast(new Human("Penny"));
    }

    public Queue<Human> getQueueByCola() {
        return queueByCola;
    }

    public Deque<Human> giveCola() {
        int counter = 0;
        while (counter < quantity) {
            Human client = queueByCola.pollFirst();
            if (null != client) {
                try {
                    Human newClient = (Human) client.clone();
                    queueByCola.addLast(client);
                    queueByCola.addLast(newClient);
                    counter++;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Machine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return queueByCola;
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
