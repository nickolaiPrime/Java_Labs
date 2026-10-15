import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Path> paths;

    public City(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public City(String name, List<Path> paths) {
        this.name = name;
        this.paths = new ArrayList<>();
        for (Path p : paths) {
            addPath(p.getCity(), p.getCost());
        }
    }

    public String getName() {
        return name;
    }

    public void addPath(City city, int cost) {
        if (city == null) {
            System.out.println("Нельзя добавить путь в null-город.");
            return;
        }
        if (city == this) {
            System.out.println("Нельзя добавить путь в сам себя (" + name + ").");
            return;
        }
        for (Path p : paths) {
            if (p.getCity().getName().equals(city.getName())) {
                System.out.println("Путь из " + name + " в " + city.getName()
                        + " уже существует. Второй путь запрещён.");
                return;
            }
        }
        paths.add(new Path(city, cost));
    }

    @Override
    public String toString() {
        if (paths.isEmpty()) return name;
        StringBuilder sb = new StringBuilder(name).append(": ");
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i));
            if (i < paths.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }
}