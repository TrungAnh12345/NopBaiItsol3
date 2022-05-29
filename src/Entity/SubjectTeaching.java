package Entity;

import RunSystem.Main;

public class SubjectTeaching {

    private Subject subject;
    private int classQuantity;
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClassQuantity() {
        return classQuantity;
    }

    public void setClassQuantity(int classQuantity) {
        this.classQuantity = classQuantity;
    }



    public SubjectTeaching(Subject subject, int classQuantity) {
        this.subject = subject;
        this.classQuantity = classQuantity;
    }

    public SubjectTeaching(Subject subject) {
        this.subject = subject;
    }

    public SubjectTeaching() {

    }

    public int  getTotalLessonOfSubject(){
        int totalLesson = 0;
        for(int i = 0; i < Main.subjectTeachings.length; i++){
            totalLesson += Main.subjectTeachings[i].getSubject().getTotalLesson() * classQuantity;
        }

        return totalLesson;

    }




}
