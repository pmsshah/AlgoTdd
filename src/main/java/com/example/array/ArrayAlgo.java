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

    public List<String> TeliCombinations(String digits) {
        List<String> allCombi = new ArrayList<String>();
        HashMap<Character, String> telDigit = new HashMap<Character, String>();
        telDigit.put('2', "abc");
        telDigit.put('3', "def");
        telDigit.put('4', "ghi");
        telDigit.put('5', "jkl");
        telDigit.put('6', "mno");
        telDigit.put('7', "pqrs");
        telDigit.put('8', "tuv");
        telDigit.put('9', "wxyz");
        for(int i=0; i<digits.length(); i++) {
            String str = telDigit.get(digits.charAt(i));
            if(str != null) {
                allCombi = combination(allCombi, str);
            }
        }
        return allCombi;
    }

    public List<String> combination(List<String> strArr, String str) {
        List<String> newCombi = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        if(strArr.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                stringBuilder.append(str.charAt(i));
                newCombi.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
            return newCombi;
        } else {
            for (int i = 0; i < strArr.size(); i++) {
                String prvStr = strArr.get(i);
                for (int j = 0; j < str.length(); j++) {
                    stringBuilder.append(prvStr).append(str.charAt(j));
                    newCombi.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }
        }
        return newCombi;
    }

}
