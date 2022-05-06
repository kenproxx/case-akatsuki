package person;

public class People {
    private String name;
    private int age;
    private int village;

    public People() {
    }

    public People(String name, int age, int village) {
        this.name = name;
        this.age = age;
        this.village = village;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }
    public String village() {
        if (getVillage() == 1) {
            return "Konoha";
        } else if (getVillage() == 2) {
            return "Kiri";
        }else if (getVillage() == 3) {
            return "Suna";
        }else if (getVillage() == 4) {
            return "Iwa";
        }
        return "Kumo";
    }
    @Override
    public String toString() {
        return "name = " + getName()  +
                ", age = " + age +
                ", village = " + village();
    }
}
