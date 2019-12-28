package Entities;

import java.io.*;
import java.util.ArrayList;

public class Proctor extends Employee{
    private Block block;

    public Proctor(String firstName, String lastName, int age, String gender, double salary, String employeeId) {
        super(firstName, lastName, age, gender, salary, employeeId);
    }

    public Proctor(String firstName, String lastName, int age, String gender, double salary, String employeeId, Block block) {
        super(firstName, lastName, age, gender, salary, employeeId);
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public static ArrayList<Proctor> loadAllFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File proctorFile = new File("proctors.bin");
        ArrayList<Proctor> proctors= new ArrayList<>();
        FileInputStream inDormFile = new FileInputStream(proctorFile);
        ObjectInputStream inputStream = new ObjectInputStream(inDormFile);
        try{
            while(true){
                proctors.add((Proctor)inputStream.readObject());
            }
        }catch(EOFException exc){}
        inputStream.close();
        inDormFile.close();
        return proctors;
    }
    public static void saveAllToFile(ArrayList<Proctor> proctors) throws IOException {
        File file = new File("proctors.bin");
        if (file.exists() && file.isFile())
        {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream toDormFile = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(toDormFile);

        for(Proctor proctor : proctors){
            outputStream.writeObject(proctor);
        };
        outputStream.close();
        toDormFile.close();
    }
}
