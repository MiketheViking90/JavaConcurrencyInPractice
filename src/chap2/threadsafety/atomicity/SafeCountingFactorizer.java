package chap2.threadsafety.atomicity;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import annotations.NotThreadSafe;
import chap2.threadsafety.servlet.Servlet;
import chap2.threadsafety.servlet.ServletRequest;
import chap2.threadsafety.servlet.ServletResponse;
import lombok.Getter;

@NotThreadSafe
public class SafeCountingFactorizer implements Servlet {

    @Getter
    private AtomicLong count = new AtomicLong(0);

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        BigInteger i  = extractFromRequest(request);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(response, factors);
    }


    private BigInteger extractFromRequest(ServletRequest request) {
        return null;
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse response, BigInteger[] factors) {
    }

}
