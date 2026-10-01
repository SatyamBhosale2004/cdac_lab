import java.util.*;

// Day 4 warm-up: run each snippet from the Day 3 revision quiz (day04-warmup.html)
public class Day3Recap {

    static class DNode { int data; DNode prev, next; DNode(int d) { data = d; } }

    static DNode dll(int... v) {
        DNode head = new DNode(v[0]), t = head;
        for (int i = 1; i < v.length; i++) { DNode n = new DNode(v[i]); t.next = n; n.prev = t; t = n; }
        return head;
    }

    static String fwd(DNode h) {
        StringBuilder sb = new StringBuilder();
        DNode last = null;
        for (DNode p = h; p != null; p = p.next) { sb.append(p.data).append(' '); last = p; }
        sb.append("| back: ");
        for (DNode p = last; p != null; p = p.prev) sb.append(p.data).append(' ');
        return sb.toString().trim();
    }

    static class Node { int data; Node next; Node(int d) { data = d; } }

    static int josephus(int n, int k) {
        Node first = new Node(1), prev = first;
        for (int i = 2; i <= n; i++) { prev.next = new Node(i); prev = prev.next; }
        prev.next = first;
        StringBuilder out = new StringBuilder("removed:");
        while (prev.next != prev) {
            for (int i = 1; i < k; i++) prev = prev.next;
            out.append(' ').append(prev.next.data);
            prev.next = prev.next.next;
        }
        System.out.println(out);
        return prev.data;
    }

    public static void main(String[] args) {
        System.out.println("Q1");
        DNode h = dll(10, 20, 30, 40);
        DNode p = h.next.next;                // 30
        p.prev.next = p.next;
        p.next.prev = p.prev;
        System.out.println(fwd(h));

        System.out.println("Q2");
        h = dll(10, 20, 40);
        p = h.next;                           // 20
        DNode n = new DNode(30);
        n.prev = p; n.next = p.next;
        p.next.prev = n; p.next = n;
        System.out.println(fwd(h));

        System.out.println("Q4");
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 2, 3));
        list.addFirst(0);
        list.removeLast();
        list.add(1, 9);
        System.out.println(list);

        System.out.println("Q6");
        Node a = new Node(1), b = new Node(2), c = new Node(3), d = new Node(4);
        a.next = b; b.next = c; c.next = d; d.next = a;
        Node tail = d;
        Node q = tail.next;
        StringBuilder sb = new StringBuilder();
        do { sb.append(q.data).append(' '); q = q.next; } while (q != tail.next);
        System.out.println(sb.toString().trim());

        System.out.println("Q7");
        System.out.println("survivor: " + josephus(5, 2));

        System.out.println("Q8");
        int[] data = {30, 10, 40, 20};
        int[] next = {2, 3, -1, 0};
        int head = 1;
        sb = new StringBuilder();
        for (int i = head; i != -1; i = next[i]) sb.append(data[i]).append(' ');
        System.out.println(sb.toString().trim());

        System.out.println("Q9");
        Node top = null;
        for (int x = 1; x <= 3; x++) { Node t = new Node(x); t.next = top; top = t; }
        int popped = top.data; top = top.next;
        System.out.println(popped + " then top = " + top.data);

        System.out.println("Q12");
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));
        try {
            for (Integer x : nums) if (x == 2) nums.remove(x);
        } catch (ConcurrentModificationException e) { System.out.println(e); }
        nums = new LinkedList<>(List.of(1, 2, 3, 4));
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) if (it.next() % 2 == 0) it.remove();
        System.out.println(nums);

        System.out.println("Q13");
        Map<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> e) { return size() > 3; }
        };
        lru.put("A", 1); lru.put("B", 2); lru.put("C", 3);
        lru.get("A");
        lru.put("D", 4);
        System.out.println(lru.keySet());
    }
}
