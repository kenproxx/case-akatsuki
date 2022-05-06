package person;

public class Member extends People{
    private int level;
    private String skill;
    private String domestic;

    public Member() {
    }

    public Member(int level, String skill, String domestic) {
        this.level = level;
        this.skill = skill;
        this.domestic = domestic;
    }

    public Member(String name, int age, int village, String domestic, int level, String skill) {
        super(name, age, village);
        this.level = level;
        this.skill = skill;
        this.domestic = domestic;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDomestic() {
        return domestic;
    }

    public void setDomestic(String domestic) {
        this.domestic = domestic;
    }



    public String level() {
        if (getLevel() == 1) {
            return "Gennin";
        } else if (getLevel() == 2) {
            return "Chunin";
        }
        return "Jounin";
    }

    @Override
    public String toString() {
        return "Akatsuki{" + super.toString() +
                ", domestic = " + domestic  +
                ", level = " + level() +
                ", skill = " + skill  + '}';
    }
}
