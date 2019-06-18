package homework.phone;

import java.util.Arrays;

public class Network {
    private String name;
    private Phone[] phones = new Phone[0];

    public Network(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public boolean addPhone(Phone phone) {

        if (getPhoneIntoNet(phone) != -1) {
            System.out.println(" Phone " + phone.getNumber()+ " is registered in net  "+ name);
            return false;
        }
        Phone[] temp = new Phone[phones.length+1];
        System.arraycopy(phones,0,temp,0,phones.length);
        temp[temp.length-1] = phone;
        phones = temp;
        System.out.println(" registration " + phone.getNumber() + " was successful ");
        return  true;
    }

    //Ищем телефон в Net
    private int getPhoneIntoNet(Phone phone) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getNumber() == phone.getNumber()) {
                return i;
            }
        }
        return -1;
    }

    //Ищем номер в Net
    public Phone getPhoneByNumber(String number) {

        for (Phone x : phones) {
            if (x.getNumber() == number) {
                return x;
            }
        }
        System.out.println( number + " is not registered in net" + name);
        return null;

    }
}
