package FifthSprint.FunctionalStyleExersices;

import java.util.*;
@FunctionalInterface
interface StringConsumer {
    void accept(String value);
}
@FunctionalInterface
interface StringSaverTransformer {

    //как нужно преобразовать сохраняемую строку?

    String transform(StringConsumer line);

}

@FunctionalInterface
interface StringSaverOnSaveListener {
    //дополнительное действие при сохранении строки

    void onSave(StringConsumer line);
}

@FunctionalInterface
interface StringSaverOnRemoveListener {
    void onRemove(StringConsumer line);
}


public class StringSaver {
    public static final int MAX_SIZE = 10_000;

    private List<String> saved = new LinkedList<>();
    private StringSaverTransformer config;
    private StringSaverOnSaveListener onSaveListener;
    private StringSaverOnRemoveListener onRemoveListener;


    public StringSaver(StringSaverTransformer config) {
        this.config = config;
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            String removedLine = saved.remove(0);
            if (onRemoveListener != null) {
                onRemoveListener.
            }
        }

    public List<String> getSaved() {
        return saved;
    }

    public static void main(String[] args) {
        List<String> people = new ArrayList<>(List.of(
                "Мария Зуева",
                "Анна Дарк",
                "Кирилл Филимонов",
                "Ева Пинк"
        ));

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.split(" ")[1].length(), o2.split(" ")[1].length());
            }
        };
        Collections.sort(people, comparator);
        System.out.println(people);
    }
}
