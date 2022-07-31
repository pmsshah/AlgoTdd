package com.example.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    private int V;
    private LinkedList<Integer> adj[]; //list of linked list.

    public GraphBFS(int v) {
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        StringBuffer sb = new StringBuffer();
        sb.append("BFS from: ").append(s).append(" : ");
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll(); //deque the value
            sb.append(s).append(" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
