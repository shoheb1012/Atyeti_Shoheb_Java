| **Day** | **Focus Area**                                             |
|---------|------------------------------------------------------------|
| Day 1   | Collection Hierarchy + List (ArrayList in-depth)           |
| Day 2   | LinkedList, Vector, Stack                                  |
| Day 3   | Set, HashSet, LinkedHashSet, TreeSet                       |
| Day 4   | Map, HashMap, LinkedHashMap, TreeMap, Hashtable            |
| Day 5   | Queue, PriorityQueue, Deque                                |
| Day 6   | Comparator vs Comparable + Custom Sorting                  |
| Day 7   | Real-World Scenarios + Coding Practice + Mock Interview Qs |

          Collection (Interface)
                |
    ------------------------------------
    |                |               |
 List                Set             Queue
   |                  |                |
ArrayList          HashSet        PriorityQueue
LinkedList         TreeSet        Deque (ArrayDeque)
Vector LinkedHashSet

          Map (Interface)
            |
    ---------------------
    |        |         |
HashMap TreeMap LinkedHashMap

Key Interfaces Overview
Interface Description
Collection Root of the collection hierarchy
List Ordered collection (allows duplicates)
Set Unordered collection (no duplicates)
Map Key-value pairs
Queue FIFO structure
Deque Double-ended queue

## ArrayList :
==============
Backed by dynamic array.
Grows 50% when size exceeds.defaultCapacity(10)
Not thread-safe.

Constructors:
List<String> list1 = new ArrayList<>();
List<Integer> list2 = new ArrayList<>(20); // initial capacity
List<String> list3 = new ArrayList<>(Collection c); // copy constructor

Use Cases:
Frequent read operations.
Index-based access is important.
Not suitable for frequent insertion/removal in between.

What happens during insertion/removal in the middle?

1. Insertion in between (e.g., list.add(2, element)):
   All elements after index 2 need to be shifted one position to the right.

Time complexity: O(n) in the worst case.

2. Removal in between (e.g., list.remove(2)):
   All elements after index 2 must be shifted one position to the left to fill the gap.

Time complexity: O(n) in the worst case.

 Q1: How does ArrayList grow?
Default capacity = 10
When full: newCapacity = oldCapacity + (oldCapacity/2) (i.e., 1.5x growth)

 Q2: Difference between ArrayList and LinkedList?
Feature	    ArrayList	       LinkedList
Backed by	Dynamic Array	   Doubly Linked List
Access   	Faster (O(1))	   Slower (O(n))
Insertion	Slower (O(n))	   Faster (O(1)) in middle
Memory	    Less (contiguous)  More (node + pointer)

🔹 Problem 5 (MCQs / Theory)
Answer these:
What is the default capacity of ArrayList?
=> default capacity of array is 10;
How does ArrayList grow?
=> newCapacity=oldCapacity+(oldCapacity/2);
Can ArrayList store nulls?
=>Yes arrayList Stores nulls and duplicate
Is ArrayList synchronized?
=> no arayyList  not a thread safe we have to use copyONArrayList for thread safety
When to use ArrayList vs LinkedList?
=> Array list is best to fetch the element linked list best to insert delete in middle 

Q)What happens if you add 10000 elements to ArrayList?
Grows multiple times (1.5x)
May copy arrays 10+ times
That’s why always use constructor with capacity if possible
List<Integer> list = new ArrayList<>(10000);

## LinkedList :
===============
📚 What You’ll do Today:
#	Topic
1	List Interface — features & role
2	ArrayList vs LinkedList — use-case based
3	LinkedList internals (how it works in memory)
4	Iterator vs ListIterator
5	Interview-level questions on LinkedList
6	Advanced POC using both Lists
7	Assignments: Logic + Real-world scenario


Internals of LinkedList
private static class Node<E> {
E item;
Node<E> next;
Node<E> prev;
}
It's a doubly-linked list, each node has pointer to next & prev.

Fast for:

Inserting at start/mid

Deleting from start/mid

