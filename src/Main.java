import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        //1.Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
        System.out.println(transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparingInt(Transaction::getValue))
                .collect(toList()));

        //2.Вывести список неповторяющихся городов, в которых работают трейдеры
        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList()));

        //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(comparing(Trader::getName))
                .collect(toList()));

        //4.  Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке
        String tradersNames = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted()
                .collect(joining(" "));
        System.out.println(tradersNames);

        //5. Выяснить, существует ли хоть один тредер из Милана
        System.out.println(transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity())));

        //6. Вывести суммы всех транзакций трейдеров из Кембриджа
        System.out.println(transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(toList()));

        //7. Какова максимальная сумма среди всех транзакций?
        System.out.println(transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo).get());

        //8. Найти транзакцию с минимальной суммой
        System.out.println(transactions.stream()
                .map(Transaction::getValue)
                .min(Integer::compareTo).get());
    }
}