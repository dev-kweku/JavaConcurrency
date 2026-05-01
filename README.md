Java Concurrency understanding by building a parkinglot application for simultanous syncronization


The "Smart Parking" System (Concurrency & Logic)
This project focuses on Multithreading and Thread Safety—topics that always come up in technical interviews.

The Goal: Build a system that manages a parking garage with 500 spots. Multiple "Cars" (Threads) try to enter and exit at the same time.

Key Skills:

synchronized keywords and ReentrantLock.

PriorityQueues (to handle VIP parkers).

Using Java Time API to calculate fees based on duration.

The Challenge: Ensure two cars never take the same spot simultaneously (Race Condition).