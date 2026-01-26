package Patterns.Builder;

public class ManualClass {
    private String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    private String type;

    public ManualClass(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

