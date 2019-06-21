package homework3;

public class MyException extends Exception {


    @Override
    public String getMessage() {
        return "Not to add more then 10 students" + '\n';
    }
}
