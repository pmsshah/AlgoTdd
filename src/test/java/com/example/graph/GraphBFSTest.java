package com.example.graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GraphBFSTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void BFS() {
        GraphBFS g = new GraphBFS(4); //adj = new LinkedList[v];
        g.addEdge(0, 1);        //adj[0] --> 1
        g.addEdge(0, 2);    //adj[0] --> 1, 2
        g.addEdge(1, 2);    //adj[1] --> 2
        g.addEdge(2, 0);        //adj[2] --> 0
        g.addEdge(2, 3);    //adj[2] --> 0, 3
        g.addEdge(3, 3);    //adj[3] --> 3
        g.BFS(2);   //2031  add(2). pop(2)->(add 03TT). pop(0)->(add 312TTF). pop(3)->(add 3123TTFF)
        g.BFS(0);   //0123
        g.BFS(1);   //1203
        g.BFS(3);   //3
    }

    @Test
    void BFSAllGraphTest() {
        GraphBFS g = new GraphBFS(4); //adj = new LinkedList[v];
        g.addEdge(0, 1);        //adj[0] --> 1
        g.addEdge(0, 2);    //adj[0] --> 1, 2
        g.addEdge(1, 2);    //adj[1] --> 2
        g.addEdge(2, 0);        //adj[2] --> 0
        g.addEdge(2, 3);    //adj[2] --> 0, 3
        g.addEdge(3, 3);    //adj[3] --> 3
        g.BFSAllGraph();
    }
}