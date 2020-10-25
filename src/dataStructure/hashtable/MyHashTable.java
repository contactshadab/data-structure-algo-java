package dataStructure.hashtable;

import java.util.LinkedList;

public class MyHashTable {

    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<Entry>[] entries;

    public MyHashTable(int size) {
        entries = new LinkedList[size];
    }

    private int getHash(int key) {
        return Math.abs(key) % entries.length;
    }

    //Run time complexity: O(1) Average case, O(n) Worst case
    public void put(int key, String value) {
        int hash = getHash(key);

        //If no linkedlist is present in the index create one and populate it with the key,value
        if (entries[hash] == null) {
            entries[hash] = new LinkedList<>();
        }

        //If item is found, update it
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        //Add the item to the linked list
        entries[hash].addLast(new Entry(key, value));
    }

    private Entry getEntry(int key) {
        int hash = getHash(key);
        if (entries[hash] == null) {
            return null;
        }

        for (Entry entry: entries[hash]) {
            if (entry.key == key) {
                return entry;
            }
        }

        return null;
    }

    //Run time complexity: O(1) Average case, O(n) Worst case
    public String get(int key) {
        Entry entry = getEntry(key);
        return entry!=null? entry.value: null;
    }

    public void remove(int key) {
        int hash = getHash(key);
        Entry entry = getEntry(key);
        if (entry != null) {
            entries[hash].remove(entry);
            return;
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(5);
        hashTable.put(10, "Ten");
        hashTable.put(20, "Twenty");
        hashTable.put(30, "Thirty");
        hashTable.put(40, "Fourty");
        hashTable.put(-50, "Minus Fifty");
//        hashTable.put(100, "One more"); //IllegalStateException
        System.out.println(hashTable.get(10));
        System.out.println(hashTable.get(30));
        System.out.println(hashTable.get(-50));
        System.out.println(hashTable.get(0));
//        System.out.println(hashTable.get(-999));    //null
        hashTable.put(30, "Minus Thirty");
        System.out.println(hashTable.get(30));
        hashTable.remove(20);
        System.out.println(hashTable.get(20));
        hashTable.put(50, "Fifty");
        hashTable.put(60, "Sixty"); //Try to add more than table size, should not be any issue
        System.out.println(hashTable.get(60));
    }

}
