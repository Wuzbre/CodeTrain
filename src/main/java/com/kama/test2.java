package com.kama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {

    public static double getPower(List<Node> nodes, int index) {
        int left = 0;
        int right = 2;
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(left).val > index) return nodes.get(left).loss;
            if (nodes.get(right).val < index) return nodes.get(right).loss;
            if (nodes.get(right).val - index == index - nodes.get(left).val) {
                return (nodes.get(right).loss + nodes.get(left).loss) / 2;
            }
            if (nodes.get(i).val == index) return nodes.get(i).loss;
            if (nodes.get(i).val > index && nodes.get(left).val < index) {
                return nodes.get(i).val - index > index - nodes.get(left).val ? nodes.get(left).loss : nodes.get(i).loss;
            }
            if (nodes.get(i).val < index && nodes.get(right).val > index) {
                return index - nodes.get(i).val > nodes.get(right).val - index ? nodes.get(right).loss : nodes.get(i).loss;
            }
            left++;
            right++;
            if (right > nodes.size() - 1) break;
        }
        return 0.0;
    }

    static class Node {
        public int val;
        public double loss;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, double loss) {
            this.val = val;
            this.loss = loss;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int index = 0;
        List<Node> nodes = new ArrayList<>();
//        System.out.println(1);
        int index = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (String s1 : split) {
            String[] split1 = s1.split(":");
            Node node = new Node(Integer.parseInt(split1[0]), Double.parseDouble(split1[1]));
            nodes.add(node);
        }
        double power = getPower(nodes, index);
        System.out.println(power);


    }
}
