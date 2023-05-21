package lambda;

import java.util.ArrayList;

import org.junit.Test;
import java.util.List;
import java.util.function.Consumer;
import org.junit.Assert;



public class Consumer1 {
    @Test
    public void consumer_1(){
        List<String>list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Consumer<List<String>> consumer = l -> l.clear();
        consumer.accept(list);
        Assert.assertEquals(list. new Arraylist<>());
    }
@Test
    public void consumer_2() {
        List<String> list1 = new ArrayList<>(Arrays.asList("a","b","c"));
    List<String> list2 = new ArrayList<>(Arrays.asList("a","b","c", "first", "second"));

    Consumer<List<String>> c1 = list -> list.add("first");
    Consumer<List<String>> c2 = list -> list.add("second");

    Consumer<List<String>> consumer = c1.andThen(c2);
    consumer.accept(list1);

    Assert.assertEqualsList(list, new ArrayList<>());
}

}
