package Entities;

import java.util.ArrayList;

public class Block {
    private int number;
    private ArrayList<Dorm> dorms;
    private Department department;

    public Block(int number, ArrayList<Dorm> dorms , Department department) {
        this.number = number;
        this.dorms = dorms;
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Dorm> getDorms() {
        return dorms;
    }

    public Dorm getDorm(int dormNumber){
        Dorm dorm = new Dorm();
        for(Dorm dm:this.getDorms()) {
            if (dm.getNumber() == dormNumber) {
                dorm = dm;
            }
        }
        return dorm;
    }

    public void setDorms(ArrayList<Dorm> dorms) {
        this.dorms = dorms;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
