package com.practice.leetcode;
//Problem from https://leetcode.com/discuss/interview-question/124858/First-non-repeating-word-in-a-file-File-size-can-be-100GB./

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class NonRepeatedWord {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            String value = firstUnrepeatedWord(readTextFromFile());
            System.out.println(value);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String readTextFromFile() throws FileNotFoundException {

        File f = new File("C:\\Users\\I069066\\Desktop\\Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String firstUnrepeatedWord(String text) {
        String[] tokens = text.split(" ");
        Map<String, Integer> map = new Hashtable<>();
        for (String str : tokens) {
            //System.out.println(map.get(str)==null);
            try {
                //int v = map.get(str);
                if (map.get(str) == null) {
                    map.put(str, new Integer(1));
                } else {
                    map.put(str, map.get(str) + new Integer(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
            }


        }

        for (String str1 : tokens) {
            if (map.get(str1) == 1) {
                return str1;
            }
        }
        return "";
    }
}
