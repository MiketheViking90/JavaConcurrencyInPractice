package chap2.threadsafety.servlet;

import java.math.BigInteger;

public class StatelessFactorizer implements Servlet {

    @Override
    public void Service(ServletRequest request, ServletResponse response) {
        BigInteger i = extractFromRequest(request);
        BigInteger[] factors = factor(i);
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
