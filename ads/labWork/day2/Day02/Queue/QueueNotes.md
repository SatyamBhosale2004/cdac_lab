# Queue Notes and Explanation

## 1. What is a Queue?
A **queue** is a linear data structure that follows the **FIFO** rule:
- **F**irst **I**n, **F**irst **O**ut
- The first element inserted is removed first.

Real-life example:
- People standing in a line at a ticket counter.

---

## 2. Basic Queue Operations

### Enqueue
- Inserts an element at the **rear** (end) of the queue.

### Dequeue
- Removes an element from the **front** (beginning) of the queue.

### Peek / Front
- Returns the front element without removing it.

### isEmpty
- Checks whether the queue has no elements.

### isFull (for array implementation)
- Checks whether the queue has reached maximum capacity.

---

## 3. Linear Queue (Array-Based)
Used in: `QueueDemo.java`

### How it works
- Two pointers/indexes are used:
  - `front` -> first valid element
  - `rear` -> last inserted element
- Enqueue increases `rear`.
- Dequeue increases `front`.

### Limitation
In a normal array queue, after multiple dequeues, free spaces may appear at the beginning, but they cannot be reused directly. This causes **wasted space**.

---

## 4. Circular Queue
Used in: `CircularQueueDemo.java`

### Why Circular Queue?
It solves the wasted-space problem of a linear queue.

### Core idea
- Treat the array like a circle.
- After reaching the last index, next position becomes index `0`.
- Movement is done using modulo:
  - `nextIndex = (currentIndex + 1) % size`

### Full condition
A circular queue is full when the next position of `rear` is `front`.

### Empty condition
Queue is empty when `front == -1`.

---

## 5. Time Complexity
For both linear and circular queue (array implementation):
- Enqueue: **O(1)**
- Dequeue: **O(1)**
- Peek: **O(1)**
- Display all elements: **O(n)**

---

## 6. Difference: Linear Queue vs Circular Queue

| Feature | Linear Queue | Circular Queue |
|---|---|---|
| Space usage | Can waste space after dequeues | Reuses freed space |
| Rear movement | Only forward | Wraps around |
| Full condition | `rear == max - 1` | `(rear + 1) % max == front` |
| Efficiency | Lower in long-running usage | Better overall |

---

## 7. Small Example (Circular Queue)
Assume size = 5

1. Enqueue: 10, 20, 30
2. Dequeue one element (10 removed)
3. Enqueue: 40, 50, 60
4. `rear` wraps to start and uses freed slots

Final queue order from `front` to `rear` remains valid in FIFO order.

---

## 8. Key Interview Points
- Queue follows FIFO.
- Circular queue prevents memory wastage in array queues.
- `front` and `rear` management is the main logic.
- Modulo `%` is essential for wrap-around in circular queues.

---

## 9. Related Files in This Project
- `QueueDemo.java` -> linear queue demo
- `CircularQueueDemo.java` -> circular queue demo
