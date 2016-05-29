package by.bsu.kolodyuk;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class InvertedIndex {


    public static void main(String[] args) throws Exception {
        JobClient client = new JobClient();

        JobConf conf = new JobConf(InvertedIndex.class);
        conf.setJobName("InvertedIndex");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        conf.setMapperClass(InvertedIndexMapper.class);
        conf.setReducerClass(InvertedIndexReducer.class);
        FileInputFormat.addInputPath(conf, new Path("input"));
        FileOutputFormat.setOutputPath(conf, new Path("output"));

        client.setConf(conf);

        JobClient.runJob(conf);
    }
}
