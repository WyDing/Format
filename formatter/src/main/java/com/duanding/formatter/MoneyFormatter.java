package com.duanding.formatter;

/**
 * Created by duanding on 16/5/11.
 */
public class MoneyFormatter implements IFormat {

    public static final int COUNT_NODE = 3;
    private int countLen;
    private InsertionFormatter insertionFormatter;
    public MoneyFormatter(){
        insertionFormatter = new InsertionFormatter();
        insertionFormatter.setInsertStr(",");
        countLen = COUNT_NODE;
    }
    @Override
    public String format(String str) {
        int count = str.length()/countLen;
        int [] counts = new int[count + 1];
        int first = str.length() - count * countLen;
        if(0 == first){
            counts[0] = 3;
        }else {
            counts[0] = str.length() - count * countLen;
        }
        for (int i = 0; i < count; i ++){
            counts[i + 1] = countLen;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i ++){
            sb.append(counts[i]);
        }
        insertionFormatter.setNodeStr(sb.toString());
        return insertionFormatter.format(str);
    }
}
