package v2;

import junit.framework.TestCase;
import org.apache.hadoop.io.Text;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NcdcRecordParserTest extends TestCase {
    private final NcdcRecordParser parser = new NcdcRecordParser();

    public void testParse() {
        String record ="0043012650999991949032412004+62300+010750FM-12+048599999V0202701N00461220001CN0500001N9+01111+99999999999";
        Text value = new Text(record);
        parser.parse(value);
        assertThat(parser.getAirTemperature(), is(111));
        System.out.println(record.substring(88, 92));
    }

    public void testTestParse() {
    }

    public void testIsValidTemperature() {
    }

    public void testGetYear() {
    }

    public void testGetAirTemperature() {
    }
}