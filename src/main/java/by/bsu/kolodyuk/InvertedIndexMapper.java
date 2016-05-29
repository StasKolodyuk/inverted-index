package by.bsu.kolodyuk;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.StringTokenizer;

public class InvertedIndexMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

    private final static Text word = new Text();
    private final static Text location = new Text();

    public void map(LongWritable key, Text val, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        FileSplit fileSplit = (FileSplit) reporter.getInputSplit();
        String fileName = fileSplit.getPath().getName();
        location.set(fileName);


        System.out.println("**** Mapper ****");
        System.out.println("Key: " + key);
        System.out.println("File: " + fileName);
        System.out.println("Line: " + val);
        System.out.println("****************");

        String line = val.toString();
        StringTokenizer itr = new StringTokenizer(line.toLowerCase());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            output.collect(word, location);
        }
    }
}
