package Entities;

import java.io.*;
import java.util.ArrayList;

public class Dorm {
    private int number;
    private Block block;
    private ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
    public static ArrayList<Dorm> loadAllFromFile() throws FileNotFoundException , IOException, ClassNotFoundException {
        File dormFile = new File("dorms.bin");
        ArrayList<Dorm> dorms= new ArrayList<>();
        FileInputStream inDormFile = new FileInputStream(dormFile);
        ObjectInputStream inputStream = new ObjectInputStream(inDormFile);
        try{
            while(true){
                dorms.add((Dorm)inputStream.readObject());
            }
        }catch(EOFException exc){}
        inputStream.close();
        inDormFile.close();
        return dorms;
    }
    public static void saveAllToFile(ArrayList<Dorm> dorms) throws IOException {
        File file = new File("dorms.bin");
        if (file.exists() && file.isFile())
        {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream toDormFile = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(toDormFile);

        for(Dorm dorm : dorms){
                outputStream.writeObject(dorm);
        };
        outputStream.close();
        toDormFile.close();
    }
}
