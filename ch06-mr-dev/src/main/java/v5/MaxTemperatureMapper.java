package v5;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxTemperatureMapper  extends Mapper<LongWritable, Text,Text, IntWritable> {

    enum Temperature {
        // 格式错误
        MALFORMED
    }
    NcdcRecordParser parser=new NcdcRecordParser();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       //super.map(key, value, context);
        parser.parse(value);
        if(parser.isValidTemperature()){
            int airTemperature = parser.getAirTemperature();
            context.write(new Text(parser.getYear()),new IntWritable(airTemperature));
        }else {
            System.err.println("Ignoring possibly corrupt input: " + value);
            context.getCounter(Temperature.MALFORMED).increment(1);
        }
    }
}
