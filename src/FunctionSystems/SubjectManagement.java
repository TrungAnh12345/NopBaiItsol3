package FunctionSystems;

import Ability.InsertInfo;
import Entity.Subject;
import RunSystem.Main;

import java.util.Scanner;

public class SubjectManagement implements InsertInfo {


    public void addSubject(Subject subject){
        for(int  i = 0;i < Main.subjects.length; i++){
            if(Main.subjects[i] == null){
                Main.subjects[i] = subject;
                return;
            }
        }

    }


    public static boolean isEmptySubject(){
        for (int i =0 ; i <  Main.subjects.length; i++){
            if(Main.subjects[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập số môn học muốn thêm");
        int numberSubject = new Scanner(System.in).nextInt();
        for(int i = 0; i < numberSubject ; i++){
            Subject subject = new Subject();
            if(Main.subjects[i] == null){
                subject.inputInfoSubject();
                addSubject(subject);
            }
        }
    }

    @Override
    public void showInfo() {
        for(int i = 0; i <  Main.subjects.length;i++){
            if(Main.subjects[i] == null){
                continue;

            }
            System.out.println(Main.subjects[i].toString());
        }
    }




}
