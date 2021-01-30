package v1;
// == MaxTemperatureReducerTestV1
import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.*;

public class MaxTemperatureReducerTest {
  
  //vv MaxTemperatureReducerTestV1
  @Test
  public void returnsMaximumIntegerInValues() throws IOException,
      InterruptedException {
    new ReduceDriver<Text, IntWritable, Text, IntWritable>()
      .withReducer(new MaxTemperatureReducer())
      .withInput(new Text("1950"),
          Arrays.asList(new IntWritable(10), new IntWritable(5)))
      .withOutput(new Text("1950"), new IntWritable(10))
      .runTest();
  }
  //^^ MaxTemperatureReducerTestV1

  // my test
  @Test
  public void returnsMaximumIntegerInValues2() throws IOException {
    new ReduceDriver<Text ,IntWritable,Text,IntWritable>()
            .withReducer(new MaxTemperatureReducer())
            .withInput(new Text("1999")
                    ,Arrays.asList(new IntWritable(20),new IntWritable(30)))
            .withOutput(new Text("1999"),new IntWritable(30))
    .runTest();
  }

}
