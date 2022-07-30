package com.example.array;

import java.util.Stack;

public class ArrayAlgo {
    public boolean balanceBracket(String stmt) {
        Stack<Character> characterStackStmt = new Stack<Character>();
        char[] charsStmt = stmt.toCharArray();
        for(int i=0; i<charsStmt.length; i++) {
            char c = charsStmt[i];
            if(c == '{' || c == '(') {
                characterStackStmt.push(c);
            } else if(c == '}') {
                if(characterStackStmt.peek() == '{')
                    characterStackStmt.pop();
                else
                    characterStackStmt.push(c);
            } else if(c == ')') {
                if(characterStackStmt.peek() == '(')
                    characterStackStmt.pop();
                else
                    characterStackStmt.push(c);
            }
        }
        if(characterStackStmt.empty())
            return true;
        return false;
    }
}
