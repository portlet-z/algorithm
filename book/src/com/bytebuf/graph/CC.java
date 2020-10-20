package com.bytebuf.graph;

import com.bytebuf.lang.In;
import com.bytebuf.lang.StdOut;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: 张新征
 * @date: 2020/10/20 7:53 上午
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In("tinyG.txt"));
        StdOut.println(G);
        CC cc = new CC(G);
        System.out.println(cc.count() + " components");
        int count = cc.count();
        Queue<Integer>[] queue = (LinkedList<Integer>[]) new LinkedList[count];
        for (int i = 0; i < count; i++) {
            queue[i] = new LinkedList<>();
        }
        for (int v = 0; v < G.V(); v++) {
            queue[cc.id(v)].add(v);
        }
        for (int i = 0; i < count; i++) {
            Queue<Integer> subQueue = queue[i];
            while (!subQueue.isEmpty()) {
                System.out.print(subQueue.poll() + " ");
            }
            StdOut.println();
        }
    }
}
