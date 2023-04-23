package lesson03;
// Класс для разворота двусвязного списка
public class TwoWayList {
    private static Node head;
    private static Node tail;
    
    // Формируем список, состоящий из n случайных целочисленных элементов
    public TwoWayList(int n) {
        // Создаём первый элемент списка
        if (n > 0) {
            head = new Node();
            head.value = (int) (Math.random() * 100);
            tail = head;
        }
        // Создаём остальлные элементы списка
        for(int i = 1; i < n; i++){
            tail.next = new Node();
            tail.next.previous = tail;
            tail = tail.next;
            tail.value = (int) (Math.random() * 100);
        }
    }

    // Разворот двусвязного списка 
    public void revert() {
        Node node = head;
        Node tmp;
        // В цикле меняем местами ссылки на следующий элемент и на предыдущий элемент
        while (node != null) {
            tmp = node.next;
            node.next = node.previous;
            node.previous = tmp;
            node = node.previous;
        }
        // И меняем местами глову и хвост
        node = head;
        head = tail;
        tail = node;
    }

    // Выводим список в виде строки
    public String print(){
        StringBuilder ans = new StringBuilder("");
        Node node = head;
        while (node != null){
            ans.append(node.value + " ");
            node = node.next;
        }
        return ans.toString();
    }
    
    class Node{
        Node next;
        Node previous;
        int value;
    }
}
