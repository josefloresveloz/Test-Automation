import com.intuit.karate.junit5.Karate;

public class runTest {
    @Karate.Test
    Karate testSample() {
        return Karate.run("classpath:ApiDemoBlazeTest.feature");
    }
}
