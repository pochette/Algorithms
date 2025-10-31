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




public class StringSaver {
    public static final int MAX_SIZE = 10_000;

    private List<String> saved = new LinkedList<>();
    private StringSaverTransformer transformer;
    private StringConsumer onSaveListener;
    private StringConsumer onRemoveListener;

    public void onSave(StringConsumer listener) {
    }

    public void onRemove(StringConsumer listener) {

    }
    public StringSaver(StringSaverTransformer config) {
        this.transformer = config;
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            String removedLine = saved.remove(0);
            if (onRemoveListener != null) {
                onRemoveListener.accept(removedLine);
            }
        }
    }

            public List<String> getSaved () {
            return saved;
        }


        public static void main (String[] args){
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


