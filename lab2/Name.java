public class Name {
    private String surname;
    private String firstName;
    private String patronymic;

    public Name(String firstName) {
        this(null, firstName, null);
    }

    public Name(String surname, String firstName) {
        this(surname, firstName, null);
    }

    public Name(String surname, String firstName, String patronymic) {
        this.surname = (surname == null || surname.isEmpty()) ? null : surname;
        this.firstName = (firstName == null || firstName.isEmpty()) ? null : firstName;
        this.patronymic = (patronymic == null || patronymic.isEmpty()) ? null : patronymic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (surname != null) sb.append(surname).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (patronymic != null) sb.append(patronymic);
        return sb.toString().trim();
    }
}