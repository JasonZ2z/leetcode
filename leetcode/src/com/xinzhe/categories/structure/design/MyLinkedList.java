package com.xinzhe.categories.structure.design;

/**
 * @author Xin
 * @create 2020/4/23
 * Title : 707. 设计链表
 * Description : 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *      在链表类中实现这些功能：
 *          get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *          addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *          addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *          addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *          deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * link : https://leetcode-cn.com/problems/design-linked-list
 * Level : Medium
 */
//todo need to review
    //单链表实现
public class MyLinkedList {
    int size = 0;
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        Node cur = head.next;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        Node pre = head;
        for (int i = 0; i < index; ++i) {
            pre = pre.next;
        }
        pre.next = new Node(val, pre.next);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node pre = head;
        for (int i = 0; i < index; ++i) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    static class Node{
        int val;
        Node next;

        public Node() {
            this.next = null;
            this.val = 0;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
