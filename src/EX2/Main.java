public static void main(String[] args) {

    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(4);
    list1.add(5);
    list1.add(6);

    List<Integer> list2 = new ArrayList<>();

    ListIterator<Integer> reverseIterator = list1.listIterator(list1.size());
    while(reverseIterator.hasPrevious()) {
        Integer element = reverseIterator.previous();
        list2.add(element);
    }
    System.out.println("Original list: " + list1);
    System.out.println("Reversed list: " + list2);

}
