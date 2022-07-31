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

    public void BFSAllGraph() {
        int i=0;
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        StringBuffer sb = new StringBuffer();
        sb.append("BFS All Graph : ");
        for(i=0; i<V; i++) {
            Iterator<Integer> it = adj[i].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        while (queue.size() != 0) {
            int s = queue.poll(); //deque the value
            sb.append(s).append(" ");
            Iterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if(!visited[n]) {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
        System.out.println(sb.toString());
    }

    void DFSUtil(int v, boolean visited[], StringBuffer sb)
    {
        // Mark the current node as visited and print it
        if(!visited[v]) {
            visited[v] = true;
            sb.append(v).append(" ");

            // Recur for all the vertices adjacent to this
            // vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited, sb);
            }
        }
    }
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        StringBuffer sb = new StringBuffer();
        sb.append("FFS from: ").append(v).append(" : ");
        DFSUtil(v, visited, sb);
        System.out.println(sb.toString());
    }
    void DFSAllGraph()
    {
        boolean visited[] = new boolean[V];
        StringBuffer sb = new StringBuffer();
        sb.append("DFS All Graph : ");
        for(int i=0; i<V; i++) {
            Iterator<Integer> it = adj[i].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                DFSUtil(n, visited, sb);
            }
        }
        System.out.println(sb.toString());
    }
}
