package tests.sanity;

import org.testng.annotations.Test;

//@Test(groups = "sanity")
@Test(enabled = false)
public class iOSSanityTests {
    public void sanityTestOne() {
        System.out.println("This is sanity test one");
    }

    public void sanityTestTwo() {
        System.out.println("This is sanity test two");
    }
}
