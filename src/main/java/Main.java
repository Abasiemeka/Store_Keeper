import Common.Person;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        //p.dateOfBirth = new Date(1986, Calendar.NOVEMBER, 4); learn dates in java
        System.out.println(p.getDateOfBirth());
        System.out.println(p.getAge());
    }
}
