package chap2.locking;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import annotations.NotThreadSafe;
import chap2.threadsafety.servlet.Servlet;
import chap2.threadsafety.servlet.ServletRequest;
import chap2.threadsafety.servlet.ServletResponse;

@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        BigInteger value = extractFromRequest(request);

        if (value.equals(lastNumber.get())) {
            encodeIntoResponse(response, lastFactors.get());
        } else {
            BigInteger[] factors = factor(value);
            lastNumber.set(value);
            lastFactors.set(factors);
            encodeIntoResponse(response, lastFactors.get());
        }
    }

    private BigInteger[] factor(BigInteger value) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse response, BigInteger[] bigIntegers) {
    }

    private BigInteger extractFromRequest(ServletRequest request) {
        return null;
    }

}
