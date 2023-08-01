package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    FileBucket[] table;
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        this.table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        Long key = getKey(value);
        return key != null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = key.hashCode();
        int index = indexFor(hash, table.length);
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table) {
            Entry e = fileBucket.getEntry();
            while (e != null) {
                if (e.value.equals(value)) {
                    return e.getKey();
                }
                e = e.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        int index = indexFor(key.hashCode(), table.length);
        Entry e = table[index].getEntry();
        while (e != null) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    final Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }
        int hash = key.hashCode();
        for (Entry e = table[indexFor(hash, table.length)].getEntry(); e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new FileBucket();
        }

        transfer(newTable);

        for (FileBucket fileBucket : table) {
            fileBucket.remove();
        }

        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (FileBucket fileBucket : table) {
            Entry e = fileBucket.getEntry();
            while (e != null) {
                Entry next = e.next;
                int indexInNewTable = indexFor(e.getKey().hashCode(), newCapacity);
                e.next = newTable[indexInNewTable].getEntry();
                newTable[indexInNewTable].putEntry(e);
                e = next;
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (maxBucketSize > bucketSizeLimit) {
            resize(2 * table.length);
            bucketIndex = indexFor(key.hashCode(), table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;

        long currBucketSize = table[bucketIndex].getFileSize();
        if (currBucketSize > maxBucketSize) {
            maxBucketSize = currBucketSize;
        }
    }

}
