
package com.ds_intelligence_arm.utils;

import com.ds_intelligence_arm.storage.model.list_am_DataRecord;

public class DataStructures {

    public static class Queue {
        public Node front;
        public Node rear;

        public class Node {
            list_am_DataRecord data;
            Node next;

            Node(list_am_DataRecord data) {
                this.data = data;
                this.next = null;
            }
        }

        public void enqueue(list_am_DataRecord record) {
            Node newNode = new Node(record);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public list_am_DataRecord dequeue() {
            if (front == null) {
                return null;
            }
            list_am_DataRecord record = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return record;
        }

    }
}
