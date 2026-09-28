# Stack Notes and Explanation

## 1. What is a Stack?
A **stack** is a linear data structure that follows **LIFO**:
- **L**ast **I**n, **F**irst **O**ut
- The most recently inserted element is removed first.

Real-life examples:
- Stack of plates
- Browser back history
- Undo operations in editors

---

## 2. Basic Stack Operations

### Push
- Adds an element to the **top** of the stack.

### Pop
- Removes and returns the top element.
- If stack is empty, this causes **underflow**.

### Peek / Top
- Returns the top element without removing it.

### isEmpty
- Returns true if stack has no elements.

### isFull (for fixed-size array stack)
- Returns true when stack reaches maximum capacity.

---

## 3. Stack Representation (Array)
In array implementation, we maintain:
- `stack[]` -> array for storing values
- `top` -> index of current top element

Initial state:
- `top = -1` (stack is empty)

### Push logic
1. Check if full (`top == max - 1`)
2. Increment `top`
3. Store value at `stack[top]`

### Pop logic
1. Check if empty (`top == -1`)
2. Read value at `stack[top]`
3. Decrement `top`

---

## 4. Time Complexity
For array or linked-list stack:
- Push: **O(1)**
- Pop: **O(1)**
- Peek: **O(1)**
- Search: **O(n)**

---

## 5. Stack Overflow and Underflow

### Overflow
Occurs when we try to push into a full fixed-size stack.

### Underflow
Occurs when we try to pop from an empty stack.

Both conditions should always be checked before update operations.

---

## 6. Common Applications of Stack
- Expression conversion and evaluation (infix, postfix, prefix)
- Parentheses balancing
- Function call management (call stack)
- Backtracking algorithms
- Undo/redo systems
- String reversal

---

## 7. Example Flow
Assume stack is empty.

1. Push 10 -> [10]
2. Push 20 -> [10, 20]
3. Push 30 -> [10, 20, 30]
4. Pop -> removes 30
5. Peek -> 20

This confirms LIFO behavior.

---

## 8. Difference: Stack vs Queue

| Feature | Stack | Queue |
|---|---|---|
| Rule | LIFO | FIFO |
| Insert | Push at top | Enqueue at rear |
| Remove | Pop from top | Dequeue from front |
| Typical use | Undo, recursion, parsing | Scheduling, buffering |

---

## 9. Related Files in This Project
- `StackDemo.java` -> stack-based parenthesis matching demo
- `ReverseStringStackDemo.java` -> reversing string using stack idea
- `ParenthesisMatchDemo.java` -> bracket/parenthesis balancing
- `UndoOperationDemo.java` -> undo behavior using stack concept
- `ExpressionEvaluationDemo.java` -> expression processing with stack concepts
