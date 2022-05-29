package FunctionSystems;

import Ability.InsertInfo;
import Entity.Lecturer;
import RunSystem.Main;

import java.util.Scanner;

public class LecturerManagement implements InsertInfo {
    public void addLecturer(Lecturer lecturer){
        for(int i = 0; i < Main.lecturers.length; i++){
            if(Main.lecturers[i] == null){
                Main.lecturers[i] = lecturer;
                return;
            }
        }
    }

    public void show(){


    }
    public static boolean isEmptyLecturer(){
        for (int i = 0;  i< Main.lecturers.length; i++){
            if(Main.lecturers[i] != null){
                return false;
            }
        }
        return true;
    }


    @Override
    public void inputInfo() {

        System.out.println("Nhập số lượng giảng viên muốn thêm");
        int nubmerLecturer = new Scanner(System.in).nextInt();
        for (int i = 0; i < nubmerLecturer; i++){
            Lecturer lecturer = new Lecturer();
            lecturer.input();
            addLecturer(lecturer);
        }
    }

    @Override
    public void showInfo() {
        for (int i = 0; i < Main.lecturers.length; i++){
            if(Main.lecturers[i] == null)
            {
                continue;
            }
            System.out.println(Main.lecturers[i]);
        }
    }


}
