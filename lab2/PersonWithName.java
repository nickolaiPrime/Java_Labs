public class PersonWithName {
    private Name name;
    private int height;

    public PersonWithName(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    public Name getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}