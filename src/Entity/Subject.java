package Entity;

import java.util.Scanner;

public class Subject {
    public static int AUTO_ID = 100;

    private int id;
    private String nameSubject;
    private int totalLesson;
    private int theoryLesson;

    public Subject() {
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", totalLesson=" + totalLesson +
                ", theoryLesson=" + theoryLesson +
                ", lessonCost=" + lessonCost +
                '}';
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public float getLessonCost() {
        return lessonCost;
    }

    public void setLessonCost(float lessonCost) {
        this.lessonCost = lessonCost;
    }

    private float lessonCost;

    public Subject(int id, String nameSubject, int totalLesson, int theoryLesson, float lessonCost) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.totalLesson = totalLesson;
        this.theoryLesson = theoryLesson;
        this.lessonCost = lessonCost;
    }

    public void inputInfoSubject(){
        this.id = AUTO_ID++;
        System.out.println("Nhập tên môn học");
        this.nameSubject = new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết: ");
        int tempTotalLesson = -1;
        do {
            try {
                tempTotalLesson = new Scanner(System.in).nextInt();
                if (tempTotalLesson > 0) {
                    this.totalLesson = tempTotalLesson;
                    break;
                }
                System.out.print("Tổng số tiết phải là số nguyên, vui lòng nhập lại: ");
            } catch (Exception ex) {
                System.out.print("Tổng số tiết phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        System.out.println("Nhập số tiết lý thuyết");
        this.theoryLesson = new Scanner(System.in).nextInt();

        System.out.println("Nhập vào chi phí giảng dạy");
        this.lessonCost = new Scanner(System.in).nextFloat();
    }


}
