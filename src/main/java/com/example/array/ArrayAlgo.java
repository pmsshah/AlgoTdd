package com.example.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public String intToRoman(int num) {
        int Num[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String roman[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder romanSb=new StringBuilder();
        int max = Num.length-1;
        while(num>0) {
            if(num>=Num[max]) {
                num = num-Num[max];
                romanSb.append(roman[max]);
            } else {
                max = max-1;
            }
        }
        return romanSb.toString();
    }

    public int maxArea(int[] height) {
        int area = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=height.length-1; j>=0 && j>i; j--) {
                int currentHight = height[i];
                if(currentHight > height[j])
                    currentHight = height[j];
                int currentArea = currentHight * (j-i);
                if(currentArea>area)
                    area = currentArea;
            }
        }
        return area;
    }
}
