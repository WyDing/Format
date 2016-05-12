package com.duanding.formatter;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 嵌入式格式化
 * Created by duanding on 16/5/11.
 */
public class InsertionFormatter implements IFormat{

    /**
     * 需要插入的字符串
     */
    public String insertStr;

    /**
     * 节点串
     */
    public String nodeStr;

    public InsertionFormatter(){
        //默认是344格式
        insertStr = " ";
        nodeStr = "344";

    }

    public InsertionFormatter(String insertStr, String nodeStr){
        this.insertStr = insertStr;
        this.nodeStr = nodeStr;
    }

    @Override
    public String format(String str) {
        if(StringUitl.isStrInString(nodeStr,"123456789")){
            return str;
        }

        int len = nodeStr.length();
        if(len == 1){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int [] counts = new int[len + 1];
        counts[0] = 0;
        for(int i = 1; i < len + 1; i ++){
            counts[i] = Integer.parseInt(String.valueOf(nodeStr.charAt(i - 1)));
        }
        int count = 0;
        for(int i = 0; i < len - 1; i ++) {
            if (count + counts[i + 1] > str.length() - 1) {
                break;
            }
            sb.append(str.substring(count, count += counts[i + 1])).append(insertStr);
        }

        sb.append(str.substring(count));
        return sb.toString();
    }

    public String getInsertStr() {
        return insertStr;
    }

    public void setInsertStr(String insertStr) {
        this.insertStr = insertStr;
    }

    public String getNodeStr() {
        return nodeStr;
    }

    public void setNodeStr(String nodeStr) {
        this.nodeStr = nodeStr;
    }
}
