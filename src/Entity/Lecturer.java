package Entity;

import constant.Level;

import java.util.Scanner;

public class Lecturer extends  Person {
    public static int AUTO_id = 100;
    private int id;
    Level lecturerLevel;

    public static int getAUTO_id() {
        return AUTO_id;
    }

    public static void setAUTO_id(int AUTO_id) {
        Lecturer.AUTO_id = AUTO_id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + "Lecturer{" +
                "id=" + id +
                ", lecturerLevel=" + lecturerLevel +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public Level getLecturerLevel() {
        return lecturerLevel;
    }

    public void setLecturerLevel(Level lecturerLevel) {
        this.lecturerLevel = lecturerLevel;
    }



    public Lecturer() {

    }



    @Override
    public void input() {
        super.input();
        id = AUTO_id ++;
        System.out.println("Nhập trình độ");
        int level = 0;

            try{
                level = new Scanner(System.in).nextInt();
                if(level < 0 || level > 3){
                    System.out.println("Số nhập vào không hợp lệ");
                }

            }catch (Exception e){
                System.out.println("Số nhập vào phải là số nguyên");
            }

            switch (level){
                case 1:
                    lecturerLevel = Level.GS_TS;
                    break;
                case 2:
                    lecturerLevel = Level.PGS_TS;
                    break;
                case 3:
                    lecturerLevel = Level.GVC;
                    break;
            }

    }
    public int compareTo(Lecturer lecturer){
        if(this.id > lecturer.getId()){
            return 1;
        }else if(this.id < lecturer.getId()){
            return -1;
        }
        return 0;
    }





}
