package Producer;

import org.junit.Assert;
import org.junit.Test;
import java.util.function.Predicate;

public class PredicatesTest {
    @Test
    public void predicate_1() {
        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> notPredicate = p1.negate();
        Assert.assertFalse(notPredicate.test(""));
        Assert.assertTrue(notPredicate.test("Not empty!"));
    }

    @Test
    public void predicate_2() {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();
        Predicate<String> p3 = p1.and(p2);

        Assert.assertFalse(p3.test(""));
        Assert.assertFalse(p3.test(null));
        Assert.assertTrue(p3.test("Not empty!"));
    }

    @Test
    public void predicate_3() {
        Predicate<String> p1 = s -> s.length() == 4;
        Predicate<String> p2 = s -> s.startsWith("J");
        Predicate<String> p3 = p1.and(p2.negate()).or(p2.and(p1.negate()));
        assert p3.test("True");
        assert p3.test("Julia");
        assert !p3.test("Java");
    }
}
