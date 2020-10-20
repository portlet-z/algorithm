package com.bytebuf.graph;

import com.bytebuf.lang.In;
import com.bytebuf.lang.StdOut;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: 张新征
 * @date: 2020/10/20 7:34 上午
 */
public class BreadFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public BreadFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In("tinyCG.txt"));
        StdOut.println(G);
        BreadFirstPath dfp = new BreadFirstPath(G, 0);
        Stack<Integer> stack = dfp.pathTo(5);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
