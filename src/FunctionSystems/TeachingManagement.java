package FunctionSystems;

import Entity.Lecturer;
import Entity.Subject;
import Entity.SubjectTeaching;
import Entity.Teachingcontrol;
import RunSystem.Main;

import java.lang.management.ManagementFactory;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;



public class TeachingManagement {

    public void createTeachingForLecturer() {
        if (LecturerManagement.isEmptyLecturer() || SubjectManagement.isEmptySubject()) {
            System.out.println("cần nhập vào thông tin giảng viên và môn học");
            return;
        }

        System.out.println("Nhập số giảng viên muốn giảng dạy");
        int numberOfLecturer = 0;

        do{
            try{
                numberOfLecturer = new Scanner(System.in).nextInt();
                if(numberOfLecturer > 0){
                    break;
                }
                System.out.println("số nhập vào phải lớn hơn 0");
            }catch (Exception e){
                System.out.println("Dữ liệu nhập vào phải là số nguyên");
            }

        }while(true);


        for (int i = 0; i < numberOfLecturer; i++) {
            Lecturer lecturer = inputLecturerById(i);
            System.out.println("Giảng viên viên vừa chọn là : " + lecturer);

            if(getTotalLessonOfLecturer(lecturer) >= 200){
                System.out.println("Số lớp của giảng viên này đã vượt quá số lượng, hãy phân công cho giảng viên khác ");
                continue;
            }

            System.out.println("Nhập số môn cho giảng viên muốn dạy");
            int numberSubject = new Scanner(System.in).nextInt();
            SubjectTeaching [] subjectTeachings = new SubjectTeaching[numberSubject];
            createSubjectTeaching(subjectTeachings, numberSubject, lecturer);
            // save
            Teachingcontrol teachingcontrol = new Teachingcontrol(lecturer, subjectTeachings);
            addToTeaching(teachingcontrol);

        }

    }
    private void createSubjectTeaching(SubjectTeaching [] subjectTeachings, int subjectNumber, Lecturer lecturer){

        for(int i = 0 ; i < subjectNumber; i++){
            Subject subject = inputSubjectById(i, lecturer);
            int numberOfClass = inputNumberOfClass(subject, i, lecturer);
            SubjectTeaching subjectTeaching = new SubjectTeaching(subject, numberOfClass);
            addSubjectTeachingToArray(subjectTeachings, subjectTeaching );
        }
    }

    public void addToTeaching(Teachingcontrol teachingcontrol){
        for(int i = 0; i < Main.teachingcontrols.length; i++){
            if(Main.teachingcontrols[i] == null){
                Main.teachingcontrols[i] = teachingcontrol;
            }
        }
    }

    private void addSubjectTeachingToArray(SubjectTeaching [] subjectTeachings, SubjectTeaching subjectTeaching){
        for (int i = 0; i< subjectTeachings.length; i++){
            if (subjectTeachings[i] == null){
                subjectTeachings[i] = subjectTeaching;
                break;
            }
        }
    }

    private int inputNumberOfClass(Subject subject, int index, Lecturer lecturer){
        System.out.println("Nhập vào số lớp của môn " + subject.getNameSubject() + " mà giảng viên muốn dạy");
        int classQuantity = 0;
        do {
            try{
                classQuantity = new Scanner(System.in).nextInt();
                if (classQuantity > 0 && classQuantity <= 3){
                    int totalLessonTeaching = getTotalLessonOfLecturer(lecturer);
                    totalLessonTeaching += subject.getTotalLesson() * classQuantity;
                    if(totalLessonTeaching > 200){
                        System.out.println(" Nếu giảng viên đăng ký số lớp giảng dạy là " + classQuantity + " thì sẽ vượt quá tổng số tiết của giảng viên đó, cần giảm số lớp đăng ký");
                        continue;
                    }
                    break;
                }
                System.out.println("Tổng số lớp bạn vừa nhập ko đúng điều kiện");

            }catch (Exception e){
                System.out.println("Số lớp nhập vào phải là số nguyên");
            }

        }while (true);
        return classQuantity;

    }
    public int getTotalLessonOfLecturer(Lecturer lecturer) {
        Teachingcontrol teachingcontrol = findTeachingStatement(lecturer.getId());
        if (teachingcontrol == null) {
            return 0;
        }
        return teachingcontrol.getCurrentTeachingSubjectClass();
    }

    public Lecturer inputLecturerById(int index) {
        System.out.println("Nhập vào id giảng viên thứ" + (index + 1));
        int idLecturer = new Scanner(System.in).nextInt();
        for (int i = 0; i < Main.lecturers.length; i++) {
            if (Main.lecturers[i] != null && Main.lecturers[i].getId() == idLecturer )
            {
                return Main.lecturers[i];
            }

        }
        System.out.println("Không có giảng viên trong hệ thống");
        return null;
    }

    public Subject inputSubjectById(int index, Lecturer lecturer){
        System.out.println("Nhập thông tin cho môn học thứ " + (index + 1));
        int idSubject = new Scanner(System.in).nextInt();
        for(int i = 0; i < Main.subjects.length; i++){
            if(Main.subjects[i] != null && Main.subjects[i].getId() == idSubject){
                return Main.subjects[i];

            }
        }
        System.out.println("Khoong cos môn học nào trong hệ thống");
        return null;
    }

    public Teachingcontrol findTeachingStatement(int getIdTeacher) {
        for (int i = 0; i < Main.teachingcontrols.length; i++) {
            if (Main.teachingcontrols[i] != null && Main.teachingcontrols[i].getLecturer().getId() == getIdTeacher) {
                return Main.teachingcontrols[i];
            }
        }
        return null;

    }

    public void showTeaching(){
        for (int i = 0; i < Main.teachingcontrols.length; i++){
            if(Main.teachingcontrols[i] != null){
                System.out.println(Main.teachingcontrols[i]);
            }
        }
    }
    public void sortTeachingByName(){
        for(int i = 0; i < Main.teachingcontrols.length - 1; i++){
            if(Main.teachingcontrols[i] == null){
                continue;
            }
           for (int j = i + 1; j < Main.teachingcontrols.length; j++){
               if(Main.teachingcontrols[j] == null){
                   continue;
               }
                if(Main.teachingcontrols[i].getLecturer().getFullName().compareTo(Main.teachingcontrols[j].getLecturer().getFullName()) > 0){
                    Teachingcontrol teachingcontrol = Main.teachingcontrols[i];
                    Main.teachingcontrols[i] = Main.teachingcontrols[j];
                    Main.teachingcontrols[j] = teachingcontrol;
                }
           }
        }
    }

    public void sortByLessonOfSubject(){


        for(int i = 0 ; i < Main.subjectTeachings.length - 1; i++)
        {

           for(int j = i + 1; j < Main.subjectTeachings.length; i++ ){
               if(Main.subjectTeachings[i].getTotalLessonOfSubject() < Main.subjectTeachings[j].getTotalLessonOfSubject() ){
                   SubjectTeaching subjectTeaching = Main.subjectTeachings[i];
                   Main.subjectTeachings[i] = Main.subjectTeachings[j];
                   Main.subjectTeachings[j] = subjectTeaching;
               }
           }
        }
    }

    public void wageLecture(){

        for(int i = 0; i < Main.teachingcontrols.length; i++){
            if(Main.teachingcontrols[i] == null){
                continue;
            }
            System.out.println("Tiền công của giảng viên " + Main.teachingcontrols[i].getLecturer().getFullName() + " là: " +   Main.teachingcontrols[i].countLessonCost());
        }
    }


}
