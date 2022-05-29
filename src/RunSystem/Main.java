package RunSystem;

import Entity.Lecturer;
import Entity.Subject;
import Entity.SubjectTeaching;
import Entity.Teachingcontrol;
import FunctionSystems.LecturerManagement;
import FunctionSystems.SubjectManagement;
import FunctionSystems.TeachingManagement;
import constant.Level;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static Lecturer [] lecturers = new Lecturer[200];
    public static Subject []  subjects = new Subject[200];
    public static Teachingcontrol[] teachingcontrols = new Teachingcontrol[200];

    public static SubjectTeaching [] subjectTeachings = new SubjectTeaching[200];


    public static void main(String[] args) {


        LecturerManagement lecturerManagement = new LecturerManagement();
        SubjectManagement subjectManagement = new SubjectManagement();
        TeachingManagement teachingManagement = new TeachingManagement();
        boolean isContinue = true;
        do {
            int pick = 0;
            System.out.println("Nhapaj cac chức năng bên dưới");
            System.out.println("1: Nhập thông tin giảng viên");
            System.out.println("2: Hiển thị thông tin giảng viên");
            System.out.println("3: Nhập thông tin môn học");
            System.out.println("4: HIển thị thông tin môn học");
            System.out.println("5: Kê khai giảng dạy cho giảng viên");
            System.out.println("6: Sắp xếp theo họ tên giảng viên");
            System.out.println("7: Sắp xếp theo tiết dạy của giảng viên mỗi môn");
            System.out.println("8: Tính tiền công cho mỗi giảng viên");
            System.out.println("9: Thoát chương trình");
            pick = new Scanner(System.in).nextInt();
            switch (pick){
                case 1:
                    lecturerManagement.inputInfo();
                    break;
                case 2: lecturerManagement.showInfo();
                break;

                case 3: subjectManagement.inputInfo();
                break;


                case 4: subjectManagement.showInfo();
                break;
                case 5: teachingManagement.createTeachingForLecturer();
                break;
                case 6: teachingManagement.sortTeachingByName();
                break;
                case 7: teachingManagement.sortByLessonOfSubject();
                break;
                case 8: teachingManagement.wageLecture();
                break;
                case 9: isContinue = false;
                break;


            }
        }while (isContinue);
    }
}
