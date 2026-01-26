package Patterns.Builder;

public class ManualClassBuilder {
    private String name;
    private String type;

    public ManualClassBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public ManualClassBuilder setType(String type) {
        this.type = type;
        return this;
    }
    public ManualClass build() {
        return new  ManualClass(name, type);
    }

}
