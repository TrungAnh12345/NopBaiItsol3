package Entity;

import java.util.Scanner;

public abstract class  Person {
    private String fullName;
    private String address;
    private int phone;

    public Person(String fullName, String address, int phone) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void input(){
        System.out.println("Nhập họ tên");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên SĐT: ");
        this.phone = new Scanner(System.in).nextInt();
    }


}
