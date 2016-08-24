package chap2.livenessandperformance;

import java.math.BigInteger;

import chap2.threadsafety.servlet.Servlet;
import chap2.threadsafety.servlet.ServletRequest;
import chap2.threadsafety.servlet.ServletResponse;

public class CachedFactorizer implements Servlet {

    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRate() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        BigInteger i = extractFromRequest(request);

        synchronized(this) {
            hits++;
            if (i.equals(lastNumber)) {
                cacheHits++;
                encodeIntoResponse(lastFactors, response);
                return;
            }
        }
        BigInteger[] factors = factor(i);
        synchronized (this) {
            lastNumber = i;
            lastFactors = factors;
        }
        encodeIntoResponse(lastFactors, response);
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }

    private void encodeIntoResponse(BigInteger[] lastFactors2, ServletResponse response) {

    }

    private BigInteger extractFromRequest(ServletRequest request) {
        return null;
    }

}
