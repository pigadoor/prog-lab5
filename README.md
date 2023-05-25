# prog-lab5
![](lab5.svg)

### Разработанная программа должна удовлетворять следующим требованиям:

- Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.  
- Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.  
- Для хранения необходимо использовать коллекцию типа `java.util.TreeMap`
- При запуске приложения коллекция должна автоматически заполняться значениями из файла.  
- Имя файла должно передаваться программе с помощью: `переменная окружения`.  
- Данные должны храниться в файле в формате `json` 
- Чтение данных из файла необходимо реализовать с помощью класса `java.util.Scanner`  
- Запись данных в файл необходимо реализовать с помощью класса `java.io.BufferedOutputStream`  
- Все классы в программе должны быть задокументированы в формате `javadoc`.  
- Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).  


### В интерактивном режиме программа должна поддерживать выполнение следующих команд:  

- `help` : вывести справку по доступным командам  
- `info` : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.). 
- `show` : вывести в стандартный поток вывода все элементы коллекции в строковом представлении  
- `insert null {element}` : добавить новый элемент с заданным ключом  
- `update id {element}` : обновить значение элемента коллекции, id которого равен заданному  
- `remove_key null` : удалить элемент из коллекции по его ключу  
- `clear` : очистить коллекцию  
- `save` : сохранить коллекцию в файл  
- `execute_script file_name` : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.  
- `exit` : завершить программу (без сохранения в файл)  
- `remove_greater {element}` : удалить из коллекции все элементы, превышающие заданный  
- `history` : вывести последние 8 команд (без их аргументов)  
- `remove_lower_key null` : удалить из коллекции все элементы, ключ которых меньше, чем заданный  
- `count_less_than_height height` : вывести количество элементов, значение поля height которых меньше заданного  
- `filter_greater_than_health health` : вывести элементы, значение поля health которых больше заданного  
- `print_descending` : вывести элементы коллекции в порядке убывания  

### Формат ввода команд:

- Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.  
- Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.  
- При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")  
- Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).  
- При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.  
- Для ввода значений null использовать пустую строку.  
- Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.  

### Описание хранимых в коллекции классов:

```java
public class SpaceMarine {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int health; //Значение поля должно быть больше 0
    private Long heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private float height;
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле может быть null
}
public class Coordinates {
    private Double x; //Поле не может быть null
    private Float y; //Максимальное значение поля: 589, Поле не может быть null
}
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
}
public enum MeleeWeapon {
    CHAIN_SWORD,
    POWER_SWORD,
    MANREAPER,
    LIGHTING_CLAW,
    POWER_FIST;
}
```

### Отчёт по работе должен содержать:

- Текст задания.
- Диаграмма классов разработанной программы.
- Исходный код программы.
- Выводы по работе.

### Вопросы к защите лабораторной работы:

1. Коллекции. Сортировка элементов коллекции. Интерфейсы `java.util.Comparable` и `java.util.Comparator`.
2. Категории коллекций - списки, множества. Интерфейс `java.util.Map` и его реализации.
3. Параметризованные типы. Создание параметризуемых классов. Wildcard-параметры.
4. Классы-оболочки. Назначение, область применения, преимущества и недостатки. Автоупаковка и автораспаковка.
5. Потоки ввода-вывода в Java. Байтовые и символьные потоки. "Цепочки" потоков (`Stream Chains`).
6. Работа с файлами в Java. Класс `java.io.File`.
7. Пакет `java.nio` - назначение, основные классы и интерфейсы.
8. Утилита `javadoc`. Особенности автоматического документирования кода в Java.
