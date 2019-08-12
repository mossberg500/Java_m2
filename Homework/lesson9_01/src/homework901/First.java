package homework901;

import java.util.ArrayList;
import java.util.List;

public class First {
    private List<Integer> list;

    public First(List<Integer> list) {
        super();
        this.list = list;
    }

    public First() {
        super();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void modifiedList(){
        List<Integer> modifyList = new ArrayList<>();
    

        addToList();
        System.out.println("Before modified " + list);
        modifyList = list.subList(2, list.size() - 1);
        list.retainAll(modifyList);
        System.out.println("After modified " + list);
    }
    private void addToList(){
        list = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i+=2 ){
            list.add(i*5);
        }

    }

    @Override
    public String toString() {
        return "First{" +
                "list=" + list +
                '}';
    }
}
