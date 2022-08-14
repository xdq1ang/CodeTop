import java.util.HashMap;
import java.util.Set;

/*
 *   @author : xdqiang
 */
public class LRUCacheMian{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));


    }
}
class LRUCache {
    HashMap<Integer, Integer> cache = null;
    int capacity = 0;
    int size = 0;
    TimeInfo timeInfo;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.timeInfo = new TimeInfo();
        timeInfo.setVal(null);
        timeInfo.next = timeInfo;
        timeInfo.last = timeInfo;
        this.capacity = capacity;

    }

    public int get(int key) {
        try{
        int e = cache.get(key);
        TimeInfo getNode = timeInfo.next;
        while (getNode != null){
            if(getNode.val == key){
                break;
            }
            getNode = getNode.next;
        }
        getNode.last.next = getNode.next;
        getNode.next.last = getNode.last;
        timeInfo.next.last = getNode;
        getNode.next = timeInfo.next;
        timeInfo.next = getNode;
        getNode.last = timeInfo;
        return e;
        }catch (NullPointerException e){
            return -1;
        }
    }

    public void put(int key, int value) {
        if (size == 0) {
            timeInfo.last = timeInfo.next;
        }
        Set<Integer> keySet = cache.keySet();
        boolean contains = keySet.contains(key);
        // 如果key存在
        if(contains){
            get(key);
        }else {
            if (size == capacity) {
                // remove node
                TimeInfo removeNode = timeInfo.last;
                int removeKey = removeNode.val;
                removeNode.last.next = timeInfo;
                timeInfo.last = removeNode.last;
                cache.remove(removeKey);
                size--;
            }

            // add node
            TimeInfo otherNode = timeInfo.next;
            timeInfo.next = new TimeInfo(key, otherNode, timeInfo);
            otherNode.last = timeInfo.next;
            size++;
        }
        cache.put(key, value);

    }
}

class TimeInfo{
    Integer val = 0;
    TimeInfo next = null;
    TimeInfo last = null;
    public TimeInfo(Integer val, TimeInfo next, TimeInfo last){
        this.val = val;
        this.next = next;
        this.last = last;
    }
    public TimeInfo(){}

    public void setVal(Integer val) {
        this.val = val;
    }

    public void setNext(TimeInfo next) {
        this.next = next;
    }

    public void setLast(TimeInfo last) {
        this.last = last;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */