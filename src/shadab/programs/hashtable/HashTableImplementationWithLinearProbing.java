package shadab.programs.hashtable;

import java.util.NoSuchElementException;

public class HashTableImplementationWithLinearProbing {
    private class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries;

    public HashTableImplementationWithLinearProbing(int size) {
        entries = new Entry[size];
    }

    private int count;

    private int getHash(String key) {
        int hash = 0;
        for (char ch: key.toCharArray()) {
            hash += (int)ch;
        }

        return hash % entries.length;
    }

    private int getIndexWithLinearProbing(String key) {
        int hash = getHash(key);
        if (entries[hash] != null && entries[hash].key != key) {
            //Do linear probing
            for (int i=hash+1; i<entries.length; i++) {
                if (entries[i] == null || entries[i].key == key) {
                    hash = i;
                    break;
                }

                if (i == entries.length-1) {
                    //Table is full
                    hash = -1;
                }
            }
        }

        return hash;
    }

    public void put(String key, String value) {
        int hash = getIndexWithLinearProbing(key);
        if (hash < 0) {
            throw new IllegalStateException("Table is full");
        }

        if (entries[hash] == null) {
            //Increase count only if we are adding
            count++;
        }

        entries[hash] = new Entry(key, value);
    }

    private int getEntryIndex(String key) {
        int hash = getHash(key);
        if (entries[hash] != null && entries[hash].key == key) {
            return hash;
        }

        //Do linear probing
        for (int i=hash+1; i<entries.length; i++) {
            if (entries[i] == null) {
                break;
            }

            if (entries[i].key == key) {
                return hash;
            }
        }

        return -1;
    }

    public String get(String key) {
        int hash = getEntryIndex(key);
        return hash != -1? entries[hash].value: null;
    }

    public void remove(String key) {
        int hash = getEntryIndex(key);
        if (hash == -1) {
            throw new NoSuchElementException();
        }
        entries[hash] = null;
        count--;
    }

    private int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        for (Entry entry: entries) {
            if (entry == null) {
                continue;
            }

            result += (entry.key + " = " + entry.value + ", ");
        }

        return result;
    }

    public static void main(String[] args) {
        HashTableImplementationWithLinearProbing hashtable = new HashTableImplementationWithLinearProbing(3);
//        System.out.println(hashtable.get(""));  //NoSuchElementException
        System.out.println("Size: " + hashtable.size());
        hashtable.put("1", "One");
        hashtable.put("add second", "Two");
        System.out.println("Size: " + hashtable.size());
        System.out.println("add second" + " = " + hashtable.get("add second"));
        System.out.println(hashtable.get("add"));   //null element not found
//        hashtable.put("add third", "Third"); //IllegalStateException table is full due to linear probing in previous step
//        hashtable.put("add more", "Four");  //IllegalStateException table is full
        System.out.println(hashtable);
        hashtable.put("1", "Can you update me");
        System.out.println("1" + " = " + hashtable.get("1"));
        hashtable.remove("add second");
        System.out.println(hashtable);
        System.out.println("Size: " + hashtable.size());
    }
}
