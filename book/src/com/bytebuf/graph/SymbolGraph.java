package com.bytebuf.graph;

import com.bytebuf.lang.In;
import com.bytebuf.lang.StdOut;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张新征
 * @date: 2020/10/23 8:57 下午
 */
public class SymbolGraph {
    private Map<String, Integer> map;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        map = new HashMap<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!map.containsKey(a[i])) {
                    map.put(a[i], map.size());
                }
            }
        }
        keys = new String[map.size()];
        for (String name : map.keySet()) {
            keys[map.get(name)] = name;
        }
        G = new Graph(map.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = map.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, map.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return map.containsKey(s);
    }

    public int index(String s) {
        return map.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }

    public static void main(String[] args) {
        SymbolGraph symbolGraph = new SymbolGraph("movie.txt", ",");
        StdOut.println(symbolGraph.G());
    }
}
