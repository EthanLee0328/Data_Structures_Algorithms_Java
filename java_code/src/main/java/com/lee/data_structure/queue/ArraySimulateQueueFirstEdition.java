package com.lee.data_structure.queue;

import java.util.Scanner;

public class ArraySimulateQueueFirstEdition {
    public static void main(String[] args) {

        // 1 创建一个对象
        ArraySimulateQueue arraySimulateQueue = new ArraySimulateQueue(3);
        // 2 键盘
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 展示队列数据");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 加数据");
            System.out.println("g(get): 取数据");
            System.out.println("h(head): 展示第一个数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arraySimulateQueue.show();
                    break;
                case 'a':
                    try {
                        System.out.println("请输入你要添加的数");
                        int value = scanner.nextInt();
                        arraySimulateQueue.enqueue(value);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 'g':
                    try {
                        int data = arraySimulateQueue.dequeue();
                        System.out.println(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int data = arraySimulateQueue.head();
                        System.out.println(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;


            }


        }
        System.out.println("over");


    }
}

// 第一版的 用数组模拟队列
class ArraySimulateQueue {
    int maxSize;//这个队列即数组最大的元素个数
    int front;// 队列的头部 ①初始化为-1 ②指向的是队列的第一个元素前面位置 即假如队列的第一个元素的index是0 那么front就是-1 如果第一个元素index是1 那么front就是0 ③每次取出一个元素 front都会+1 直到front等于了rear那么就空了
    int rear;//队列的尾部 ① 初始化是-1 ②指向的是队列的最后一个元素的位置 比如队列最后一个元素的index是2 那么rear就是2 ③每次加一个元素都会rear+1 直到rear=maxSize-1
    int[] array;// 用于存储数据的数组

    // 构造器 new一个你需要的数组
    public ArraySimulateQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断下 这个数组array是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断下是否空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加元素  入队列
    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        array[++rear] = value;
    }

    // 取出元素 出队列
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return array[++front];
    }

    // 展示队列的元素
    public void show() {
        if (isEmpty()) System.out.println("Queue is empty");
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(array[i] + " ");
        }
    }

    //展示队列的第一个元素
    public int head() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return array[front + 1];
        }
    }
}