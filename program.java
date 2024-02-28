import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        
        // Заполнение телефонной книги
        phoneBook.put("Иванов", "123456789");
        phoneBook.put("Петров", "987654321");
        phoneBook.put("Сидоров", "555111222");
        phoneBook.put("Иванов", "999888777");
        
        // Создание новой структуры для хранения данных
        Map<String, Integer> phoneBookCount = new HashMap<>();
        
        // Обработка исходной телефонной книги
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            
            // Увеличение счетчика для каждого имени
            if (phoneBookCount.containsKey(key)) {
                phoneBookCount.put(key, phoneBookCount.get(key) + 1);
            } else {
                phoneBookCount.put(key, 1);
            }
        }
        
        // Сортировка по убыванию числа телефонов
        Map<String, Integer> sortedPhoneBook = new TreeMap<>((o1, o2) -> {
            int compare = phoneBookCount.get(o2).compareTo(phoneBookCount.get(o1));
            if (compare == 0) {
                return o1.compareTo(o2);
            }
            return compare;
        });
        
        sortedPhoneBook.putAll(phoneBookCount);
        
        // Вывод отсортированной телефонной книги
        for (Map.Entry<String, Integer> entry : sortedPhoneBook.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " телефон(ов)");
        }
    }
}
