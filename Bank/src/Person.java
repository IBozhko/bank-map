import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by johnny on 12.06.17.
 */
public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private String address;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) throws IOException{
        if (age<18) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Too young to work/have bank account, enter other age:");
            setAge(Integer.parseInt(br.readLine()));
            br.close();
        }
        else
            this.age = age;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
