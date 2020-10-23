package com.bytebuf.graph;

import com.bytebuf.lang.In;
import com.bytebuf.lang.StdOut;

/**
 * @author: 张新征
 * @date: 2020/10/23 8:52 下午
 */
public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In("tinyG.txt"));
        StdOut.println(G);
        TwoColor twoColor = new TwoColor(G);
        System.out.println(twoColor.isBipartite());
    }
}
