package Exchange;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args){
        RON leu = new RON(200.5F);
        ExchangeDesk exchangeDesk = new ExchangeDesk();
        try {
            System.out.println(exchangeDesk.convert(leu, USD.class));
            System.out.println(exchangeDesk.convert(leu, USD.class));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
