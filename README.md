# MultiThreading
Multithreading in Java
Programming Tasks
(1) Run the given program in which multiple threads add and remove
elements from a linked list (using the java.util.LinkedList). Explain
how the program works and explain how the list may get corrupted.
[see LinkedListThread.zip folder]
(2) Implement a Queue class whose add and remove methods are
synchronized. Create one thread, called the Producer, which keeps inserting
strings into the queue as long as there are fewer than 10 elements in it. When
the queue gets full, the thread waits.
As sample strings, simply use time stamps:
new java.util.Date().toString()
Supply a second thread, called the Consumer, that keeps removing and
printing strings from the queue as long as the queue is not empty. When the
queue is empty, the thread waits. Both the consumer and producer threads
should run for 100 iterations.
Comments:
*It would be good to include a delay, as seen in the previous examples, to see the results more
clearly.
*Queue.zip contains a sample queue class that can be modified and used for question 2.
*See the sample Thread programs. Make sure both Threads are using the same queue.
