package com.lee.data_structure.queue;

import java.util.Scanner;

public class ArraySimulateCircleQueueFirstEdition {
    public static void main(String[] args) {
// 1 创建一个对象
        ArraySimulateCircleQueue arraySimulateCircleQueue = new ArraySimulateCircleQueue(4);
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
                    arraySimulateCircleQueue.show();
                    break;
                case 'a':
                    try {
                        System.out.println("请输入你要添加的数");
                        int value = scanner.nextInt();
                        arraySimulateCircleQueue.enqueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int data = arraySimulateCircleQueue.dequeue();
                        System.out.println(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int data = arraySimulateCircleQueue.head();
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

class ArraySimulateCircleQueue {
    int maxSize;//这个队列即数组最大的元素个数
    int front;// 队列的头部 ①初始化为0  ②指向的是队列的第一个元素位置 即假如队列的第一个元素的index是0 那么front就是0 如果第一个元素index是1 那么front就是1 ③每次取出一个元素 front都会+1 直到front等于了rear那么就空了
    int rear;//队列的尾部 ① 初始化是0 ②指向的是队列的最后一个元素的后一个位置 比如队列最后一个元素的index是2 那么rear就是3 ③每次加一个元素都会rear+1 直到(rear +1) % maxSize == front 还要注意边界问题==取余 循环==环形队列 也就是这个问题
    // 比如 数组大小为4 那么有效元素最大为3 有效元素最大index是 2 那么rear最大为3 那么这个时候只要比如 index为0 1 2 位置是空 即有位置的时候 那么还可以存数据 这个时候如果存数据那么 index为3的位置就会存上数据 那么rear变为0
    // 因为 rear=（rear+1)%maxSize
    int[] array;// 用于存储数据的数组

    // 构造器 new一个你需要的数组
    public ArraySimulateCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    //判断下 这个数组array是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断下是否空
    public boolean isEmpty() {
        return front == rear;
    }


    // 添加元素  入队列
    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        array[rear] = value;

        rear = (rear + 1) % maxSize;

    }

    // 取出元素 出队列
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 判断数组有效的元素个数
    public int validData() {
        return (rear + maxSize - front) % maxSize;
    }


    // 展示队列的元素
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <front + validData(); i++) {
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    //展示队列的第一个元素
    public int head() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return array[front];
        }
    }


}