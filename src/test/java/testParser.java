import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by anthonyjones on 5/31/17.
 */
public class testParser {
    Parser parser;
    String output;

    @Before
    public void init() throws Exception {
        parser = new Parser();
        ClassLoader classLoader = getClass().getClassLoader();
      //  String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

         output = (new Main()).readRawDataToString();
    }


    @Test
    public void testPatternMatch() {
        //Given
        String given = output;
        String expected = "naMe";
        //When
        String actual = parser.patternMatch(given);
        //Then
        Assert.assertEquals("This should return a String with the first product", expected, actual);
    }


    @Test
    public void testLineBreaker() {
        //Given
        String given = output;
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        //When
        ArrayList<String> arrayListOfBrokenLines = parser.lineBreaker(given);
        String actual = arrayListOfBrokenLines.get(0);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);
    }
}
