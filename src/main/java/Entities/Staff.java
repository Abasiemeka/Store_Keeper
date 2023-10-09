package Entities;

import Common.*;

public class Staff extends Person {
    private Roles role;

    public Staff(String name, String gender, Roles role) {
        this.setName(name);
        this.setGender(gender);
        this.role = role;
    }

}
