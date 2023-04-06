package lesson03;

public class OneWayList {
    private static Node head;
    // Формируем список, состоящий из n случайных целочисленных элементов
    public OneWayList(int n) {
        Node node = null;
        // Создаём первый элемент списка
        if (n > 0) {
            head = new Node();
            head.value = (int) (Math.random() * 100);
            node = head;
        }
        // Создаём остальные элементы списка
        for(int i = 1; i < n; i++){
            node.next = new Node();
            node = node.next;
            node.value = (int) (Math.random() * 100);
        }
    }

    // Разворачивем список
    public void revert() {
        Node node = null;
        Node oldHead = head;
        while (oldHead.next != null) {
            node = oldHead.next;
            oldHead.next = node.next;
            node.next = head;
            head = node;
        }
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

    class Node {
        Node next;
        int value;
    }
}
