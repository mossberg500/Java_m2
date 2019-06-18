package homework.phone;

public class Phone {
    private Network net;
    private String number;

    public Phone() {
        super();
    }

    public Phone(Network net, String number) {
        super();
        this.net = net;
        this.number = number;
    }
    public Phone(String number) {
        super();
        this.net = null;
        this.number = number;
    }


    public String getNumber() {
        if(Phone.class == null)
            return "";
        return number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "net=" + net +
                ", number='" + number + '\'' +
                '}';
    }

    public  void registerToNet(Network net) {
        this.net = net;
        System.out.println(" Номер " + this.number + " зарегистрирован в сети "+ this.net.getName());
        if(!this.net.addPhone(this))
            this.net = null;
    }

    public void call(String number) {
        if (this.net == null) {
            System.out.println("Abonent " + number + " Network is unavailable!");
            return;
        }
        Phone correctPhone = this.net.getPhoneByNumber(number);
        System.out.println(" Звоним с " + this.getNumber() + " на номер " + number);
        if (correctPhone != null) {
            correctPhone.incomingCall();
        }
        else {
            System.out.println(" Abonent " + number + " not available ");
        }

    }

    private void incomingCall() {

        System.out.println(this.number + " D-z-z-z-z-z-z-z-z ");

    }
}
