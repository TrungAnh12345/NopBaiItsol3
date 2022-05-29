package Entity;

import FunctionSystems.SubjectManagement;
import RunSystem.Main;

public class Teachingcontrol {
    Lecturer lecturer;
    SubjectTeaching [] subjectTeachings ;

    public Teachingcontrol(Lecturer lecturer, SubjectTeaching[] subjectTeachings) {
        this.lecturer = lecturer;
        this.subjectTeachings = subjectTeachings;
    }

    public Teachingcontrol() {
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public SubjectTeaching[] getSubjectTeachings() {
        return subjectTeachings;
    }

    public void setSubjectTeachings(SubjectTeaching[] subjectTeachings) {
        this.subjectTeachings = subjectTeachings;
    }


    public int getCurrentTeachingSubjectClass(){
        int countCurrentLesson = 0;
       for(int i = 0; i < Main.subjects.length; i++){
           Subject subject = subjectTeachings[i].getSubject();
           countCurrentLesson += subjectTeachings[i].getClassQuantity() * subject.getTotalLesson();
       }
       return countCurrentLesson;
    }

    public Subject findSubjectById(int idSubject){
        for(int i = 0; i  < Main.subjects.length; i++){
            if(Main.subjects[i].getId() == idSubject){
                return Main.subjects[i];
            }
        }
        return null;
    }


    public float countLessonCost(){
        int practiceLesson = 0;
        float theoryCost = 0;
        float practiceLessonCost = 0;
        float allLessonCost = 0;
        for(int i =  0; i < Main.subjectTeachings.length; i++){
            if(Main.subjectTeachings[i] == null){
                continue;
            }
            practiceLesson = subjectTeachings[i].getSubject().getTotalLesson() - subjectTeachings[i].getSubject().getTheoryLesson();
            theoryCost = (float) subjectTeachings[i].getSubject().getLessonCost() * subjectTeachings[i].getSubject().getTheoryLesson();
            practiceLessonCost = (float)(practiceLesson * theoryCost * 0.7f);
            allLessonCost = theoryCost + practiceLessonCost;
        }
        return allLessonCost;
    }



}
