package homework904;
public class ColaMain {

    public static void main(String[] args) {
        Machine Machine = new Machine(6);

        System.out.println("Queue befor:" + Machine.getQueueByCola());
        System.out.println("Queue after :" + Machine.giveCola());

    }

}