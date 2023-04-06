package lesson03;


class Main {
    public static void main(String[] args) {
        int Len = 25;
        // Создаём двусвязный список
        System.out.println("Исходный двусвязный список:");
        TwoWayList mylist = new TwoWayList(Len);
        System.out.println(mylist.print());
        // Разворачиваем двусвязный список
        mylist.revert();
        System.out.println("Двусвязный список после разворота:");
        System.out.println(mylist.print());

        // Создаём односвязный список
        System.out.println("Исходный односвязный список:");
        OneWayList oneList = new OneWayList(Len);
        System.out.println(oneList.print());
        // Разворачиваем односвязный список
        System.out.println("Односвязный список после разворота:");
        oneList.revert();
        System.out.println(oneList.print());
    }
}