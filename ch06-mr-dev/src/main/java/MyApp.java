import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MyApp extends Configured implements Tool {

    public int run(String[] args) throws Exception {
//        // Configuration processed by ToolRunner
//        Configuration conf = getConf();
//
//        // Create a JobConf using the processed conf
//        JobConf job = new JobConf(conf, MyApp.class);
//
//        // Process custom command-line options
//        Path in = new Path(args[1]);
//        Path out = new Path(args[2]);
//
//        // Specify various job-specific parameters
//        job.setJobName("my-app");
//        FileInputFormat.setInputPaths(job, in);
//        FileOutputFormat.setOutputPath(job,out);
////        job.setInputPath(in);
////        job.setOutputPath(out);
//        job.setMapperClass(MaxTemperatureMapper.class);
//        job.setReducerClass(MaxTemperatureReducer.class);
//
//        // Submit the job, then poll for progress until the job is complete
//        JobClient.runJob(job);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        // Let ToolRunner handle generic command-line options
        int res = ToolRunner.run(new Configuration(), new MyApp(), args);

        System.exit(res);
    }

}
