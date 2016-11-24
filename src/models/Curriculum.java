package models;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Curriculum {

    private int curriculumID;
    private String school;
    private String education;
    private int semester;

    public Curriculum(int curriculumID, String school, String education, int semester) {
        this.curriculumID = curriculumID;
        this.school = school;
        this.education = education;
        this.semester = semester;
    }

    public int getCurriculumID() {
        return curriculumID;
    }

    public void setCurriculumID(int curriculumID) {
        this.curriculumID = curriculumID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
