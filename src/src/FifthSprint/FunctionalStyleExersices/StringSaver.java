package FifthSprint.FunctionalStyleExersices;

import java.util.*;



@FunctionalInterface
interface StringsSaverOnSaveListener {
    /**
     * Дополнительное действие при сохранении
     */
    void onSave(String line);
}

@FunctionalInterface
interface StringsSaverOnRemoveListener {
    /**
     * Дополнительное действие при удалении
     */
    void onRemove(String line);
}

@FunctionalInterface
interface StringSaverTransformer {

    //как нужно преобразовать сохраняемую строку?
    String transform(String line);

}

public class StringSaver {
    public static final int MAX_SIZE = 10_000;

    private List<String> saved = new LinkedList<>();
    private StringSaverTransformer transformer;
    private StringsSaverOnSaveListener onSaveListener;
    private StringsSaverOnRemoveListener onRemoveListener;

    public void setTransformer(StringSaverTransformer transformer) {
        this.transformer = transformer;
    }

    public void setOnSaveListener(StringsSaverOnSaveListener onSaveListener) {
        this.onSaveListener = onSaveListener;
    }

    public void setOnRemoveListener(StringsSaverOnRemoveListener onRemoveListener) {
        this.onRemoveListener = onRemoveListener;
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            saved.remove(0);
        }
        if (onSaveListener != null) {
            onSaveListener.onSave(line);
        }
        if (transformer != null) {
            line = transformer.transform(line);
        }
        saved.add(line);
    }

    public void remove(String line) {
        if (onRemoveListener != null) {
            onRemoveListener.onRemove(line);
        }
    }

    public List<String> getSaved() {
        return saved;
    }
}
class StringSaverTest {
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





