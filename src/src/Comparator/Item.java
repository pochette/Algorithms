package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item {
    public final String name;
    public final int price;
    public final int popularity;

    public Item(String name, int price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", popularity=" + popularity +
                '}';
    }

    public static class ItemStringInSensitiveNameComparator implements Comparator<Item> {
        @Override
        public int compare(Item item1, Item item2) {
            return item1.name.compareToIgnoreCase(item2.name);
        }
    }

    public static class ItemPriceComparator implements Comparator<Item> {
//        @Override
//        public int compare(Item item1, Item item2) {
//            if (item1.price > item2.price) {
//                return 1;
//            } else if (item1.price < item2.price) {
//                return -1;
//            } else {
//                return 0;
//            }
//
//        }

        @Override
        public int compare(Item item1, Item item2) {
            return Integer.compare(item1.price, item2.price);
        }

    }

    public static class ItemPopularityComparator implements Comparator<Item> {
//        @Override
//        public int compare(Item item1, Item item2) {
//            if (item1.price > item2.price) {
//                return 1;
//            } else if (item1.price < item2.price) {
//                return -1;
//            } else {
//                return 0;
//            }
//
//        }

        @Override
        public int compare(Item item1, Item item2) {
            return Integer.compare(item1.popularity, item2.popularity);
        }

    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Рубашка", 1500, 5));
        items.add(new Item("Джинсы", 3000, 4));
        items.add(new Item("Куртка", 5000, 3));
        items.add(new Item("Платье", 4000, 5));
        items.add(new Item("Обувь", 3500, 4));
        items.add(new Item("Шапка", 1000, 2));

        System.out.println("До сортировки:");
        System.out.println(items);

        Comparator <Item> itemPopularityComparator = new ItemPopularityComparator();
        items.sort(itemPopularityComparator);
        items.sort(itemPopularityComparator);

        System.out.println("После сортировки:");
        System.out.println(items);

        ItemStringInSensitiveNameComparator itemStringInSensitiveNameComparator = new ItemStringInSensitiveNameComparator();
        items.sort(itemStringInSensitiveNameComparator);
        System.out.println("После сортировки по алфавиту: " + items);

        Comparator<Item> itemPriceComparator = new ItemPriceComparator();
        items.sort(itemPriceComparator.reversed());
        System.out.println("После обратной сортировки цены: " + items);

    }
}