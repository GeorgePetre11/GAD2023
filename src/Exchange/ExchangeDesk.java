package Exchange;

import javax.swing.plaf.ColorUIResource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ExchangeDesk {
    private float rate = 0.23f;
    public <T extends Currency, F extends  Currency> F convert (T currency, Class<F> toCurrencyClass, Float rate) throws Exception {

        Class[] cArg = new Class[1];
        cArg[0] = Float.class;

        Constructor<F> ct = toCurrencyClass.getDeclaredConstructor(cArg);
        return ct.newInstance(rate * currency.getValue());

    }

    public <T extends Currency, F extends Currency> F convert (T currency, Class<F> toCurrencyClass) throws Exception {
        return convert(currency, toCurrencyClass, rate);
    }

}
