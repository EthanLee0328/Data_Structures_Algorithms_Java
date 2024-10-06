package com.lee.data_structure.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node01 = new Node(1, "宋江", "及时雨");
        Node node03 = new Node(3, "卢俊义", "玉麒麟");
        Node node05 = new Node(5, "李逵", "死鬼");
        Node node07 = new Node(7, "林冲", "豹子头");

        SingleLinkedList singleLinkedList01 = new SingleLinkedList();
        singleLinkedList01.add(node01);
        singleLinkedList01.add(node03);
        singleLinkedList01.add(node05);
        singleLinkedList01.add(node07);
//        singleLinkedList.list();
//        Node node05 = new Node(4, "林冲", "狗头");
//        singleLinkedList.update(node05);
//        singleLinkedList.list();
//        singleLinkedList.delete(2);
//        singleLinkedList.list();
//        System.out.println(singleLinkedList.validNode(singleLinkedList.getHead()));
//        System.out.println(singleLinkedList.findLatKNode(singleLinkedList.getHead(), 2));
//        singleLinkedList.reverse(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        singleLinkedList.reversePrint(singleLinkedList.getHead());

        System.out.println("测试链表合并 之前的链表");
        singleLinkedList01.list();
        System.out.println("测试链表合并 之后的链表");

        Node node02 = new Node(2, "李银实", "哈哈哈");
        Node node04 = new Node(4, "王敏杰", "嘿嘿嘿");
        Node node06 = new Node(6, "姚荷艳", "呼呼呼");
        Node node08 = new Node(8, "鲁丽中", "秒秒秒");
        SingleLinkedList singleLinkedList02 = new SingleLinkedList();
        singleLinkedList02.add(node02);
        singleLinkedList02.add(node04);
        singleLinkedList02.add(node06);
        singleLinkedList02.add(node08);


        SingleLinkedList mergeSingleLinkedList = singleLinkedList01.merge(singleLinkedList02);
        mergeSingleLinkedList.list();

    }
}

class SingleLinkedList {
    private final Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    // 1 add 添加独立节点 注意有编号 按照编号的大小条件 比如 4 要在2后面 6前面 要找到 添加节点位置的上一个节点 然后此节点的下一个节点的id要大于要添加的节点
    public void add(Node node) {
        Node temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            } else if (temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("已经有了这个节点");
        } else {

            node.next = temp.next;
            temp.next = node;

        }
    }


    // 2 list
    public void list() {
        if (head.next == null) {
            System.out.println("该链表是空的");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }


    }

    //3 update
    public void update(Node node) {
        if (head.next == null) {
            System.out.println("该链表是空的,请直接添加即可");
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("该链表是空的,请直接添加即可");
                break;
            }
            if (temp.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("没找到,请直接添加即可");
        }


    }

    //4 delete
    public void delete(int id) {
        if (head.next == null) {
            System.out.println("链表是空的 你删除个毛");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没找打删除个毛");
        }


    }

    // 5 统计有效节点个数
    public int validNode(Node head) {
        if (head.next == null) {
            System.out.println("没有有效节点");
            return 0;
        }
        Node current = head.next;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;

    }

    // 6 查找单链表中的倒数第k个节点

    /**
     * core mind 是 遍历次数=有效个数-k   for (int i = 0; i < size - k; i++)
     *
     * @param head
     * @param k
     * @return
     */
    public Node findLatKNode(Node head, int k) {
        if (head.next == null) {
            System.out.println("该链表为空，找不到倒数的" + k + "节点");
            return null;
        }
        int size = validNode(head);
        if (k <= 0 || k > size) {
            System.out.println("这个" + k + "不合适");
            return null;
        }
        Node current = head.next;
        for (int i = 0; i < size - k; i++) {
            current = current.next;
        }
        return current;
    }

    // 7 翻转链表
    public void reverse(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //准备工作 定义一个辅助指针 遍历链表
        Node current = head.next;
        Node next = null;//指向当前节点current 的下一个节点
        Node reverseHead = new Node(0, "", "");
        // 遍历原来的链表，每遍历一个节点，就将其取出，放在新的链表reverseHead的最前端
        while (current != null) {
            next = current.next;// 将当前节点current的下一个节点存到next中
            current.next = reverseHead.next;//将新的链表reverseHead的头节点的下一个节点给到当前节点的下一个节点 这个是翻转的关键
            reverseHead.next = current;//将当前节点给到头节点的下一个节点
            current = next;//往下走
        }
        head.next = reverseHead.next;
        reverseHead.next = null;
    }

    // 8 逆序打印
    public void reversePrint(Node head) {
        if (head.next == null) {
            System.out.println("链表是空的");
            return;
        }

        Stack<Node> stack = new Stack<>();

        Node current = head.next;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


    }

// 9 合并两个有序的单链表，返回一个新的合并后的链表，原链表不变
    public SingleLinkedList merge(SingleLinkedList otherList) {
        // 创建一个新的链表对象，将合并后的链表赋值给它
        SingleLinkedList mergedList = new SingleLinkedList();
        // 创建一个新的链表头结点，作为虚拟头结点
        Node dummyHead = new Node(0, "", "");
        Node current = dummyHead;

        if (otherList == null) {
            mergedList.getHead().next = this.getHead().next;
            return mergedList;
        }


        // 当前链表和其他链表的头节点
        Node node1 = this.getHead().next;
        Node node2 = otherList.getHead().next;

        // 遍历两个链表，依次比较它们的节点
        while (node1 != null && node2 != null) {
            if (node1.id <= node2.id) {
                current.next = new Node(node1.id, node1.name, node1.nickname); // 创建新节点，避免改变原链表
                node1 = node1.next;
            } else {
                current.next = new Node(node2.id, node2.name, node2.nickname); // 创建新节点，避免改变原链表
                node2 = node2.next;
            }
            current = current.next;
        }

        // 如果其中一个链表还有剩余的节点，直接添加到新的链表中
        while (node1 != null) {
            current.next = new Node(node1.id, node1.name, node1.nickname);
            node1 = node1.next;
            current = current.next;
        }
        while (node2 != null) {
            current.next = new Node(node2.id, node2.name, node2.nickname);
            node2 = node2.next;
            current = current.next;
        }


        mergedList.getHead().next = dummyHead.next;

        return mergedList;
    }


}

class Node {
    public int id;
    public String name;
    public String nickname;
    public Node next;

    public Node(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", nickname: " + nickname;
    }
}