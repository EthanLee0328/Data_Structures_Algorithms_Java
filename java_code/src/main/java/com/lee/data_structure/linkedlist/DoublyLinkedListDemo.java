package com.lee.data_structure.linkedlist;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DNode node01 = new DNode(1, "宋江", "及时雨");
        DNode node03 = new DNode(3, "卢俊义", "玉麒麟");
        DNode node05 = new DNode(5, "李逵", "死鬼");
        DNode node07 = new DNode(7, "林冲", "豹子头");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(node01);
        doublyLinkedList.add(node03);
        doublyLinkedList.add(node05);
        doublyLinkedList.add(node07);
        doublyLinkedList.list();

        DNode node08 = new DNode(7, "李银实", "够投资");
        doublyLinkedList.update(node08);
        doublyLinkedList.list();
        doublyLinkedList.add(new DNode(2, "jordan", "god"));
        doublyLinkedList.list();

        doublyLinkedList.delete(3);
        doublyLinkedList.list();

        doublyLinkedList.delete(2);
        doublyLinkedList.list();

    }


}

class DoublyLinkedList {
    private final DNode head = new DNode(0, "", "");

    public DNode getHead() {
        return head;
    }

    // 1 list
    public void list() {
        if (head.next == null) {
            System.out.println("该链表是空的");
            return;
        }
        DNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 2 add
    public void add(DNode node) {
        DNode temp = head;
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
            node.pre = temp;
            if (temp.next != null) {
                temp.next.pre = node;
            }
            temp.next = node;
        }
    }

    //3 update
    public void update(DNode node) {
        if (head.next == null) {
            System.out.println("该链表是空的,请直接添加即可");
        }
        DNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
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
        DNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.println("没找打删除个毛");
        }


    }

}

class DNode {
    public int id;
    public String name;
    public String nickname;
    public DNode pre;
    public DNode next;

    public DNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", nickname: " + nickname;
    }
}