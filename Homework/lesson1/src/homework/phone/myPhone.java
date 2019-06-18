package homework.phone;

public class myPhone {
    public static void main(String[] args) {

        Network net = new Network("Mobile");
        Phone phoneOne = new Phone("0671234567");
        Phone phoneTwo = new Phone("0671111111");
        Phone phoneThree = new Phone("0671111112");

        phoneOne.call( "0671234567");
        phoneOne.registerToNet(net);

        phoneTwo.call("0671111112");
        phoneTwo.registerToNet(net);

        phoneOne.call("0671111111");

        phoneTwo.call("0671111112");
    }
}
