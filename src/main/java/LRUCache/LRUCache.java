package LRUCache;

/**
 * 2015.1.17
 */
public class LRUCache {
    private int capacity;
    private int size;
    private int[] keys;
    private int[] values;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.keys = new int[capacity];
        this.values = new int[capacity];
    }

    private int index(int key) {
        int[] keys = this.keys;
        for (int i = 0; i < this.size; i++) {
            if (keys[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int get(int key) {
        int idx = index(key);
        if (idx != -1) {
            int r = this.values[idx];
            set(key, r);
            return r;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (this.size >= this.capacity) {
            int idx = index(key);
            if (idx == -1) {
                for (int i = 0; i < this.size - 1; i++) {
                    this.keys[i] = this.keys[i + 1];
                    this.values[i] = this.values[i + 1];
                }
                this.keys[this.size - 1] = key;
                this.values[this.size - 1] = value;
            } else if (idx + 1 < this.size) {
                for (int i = idx; i < this.size - 1; i++) {
                    this.keys[i] = this.keys[i + 1];
                    this.values[i] = this.values[i + 1];
                }
                this.keys[this.size - 1] = key;
                this.values[this.size - 1] = value;
            } else if (idx + 1 == this.size) {
                this.values[this.size - 1] = value;
            }
        } else {
            int idx = index(key);
            if (idx == -1) {
                int i = this.size++;
                this.keys[i] = key;
                this.values[i] = value;
            } else if (idx + 1 < this.size) {
                for (int i = idx; i < this.size - 1; i++) {
                    this.keys[i] = this.keys[i + 1];
                    this.values[i] = this.values[i + 1];
                }
                this.keys[this.size - 1] = key;
                this.values[this.size - 1] = value;
            } else if (idx + 1 == this.size) {
                this.values[this.size - 1] = value;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(2, 2);
        lruCache.get(2);
        lruCache.set(1, 1);
        lruCache.set(4, 1);
        lruCache.get(2);
    }
}
