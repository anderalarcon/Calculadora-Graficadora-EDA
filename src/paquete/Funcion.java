
package paquete;

import com.bestcode.mathparser.IMathParser;
import com.bestcode.mathparser.MathParserFactory;


public class Funcion {

    String definicion;
    IMathParser Parser = MathParserFactory.create();

    public Funcion(String defi) {
        definicion = defi;
        Parser.setExpression(defi);
    }

    public double eval(double x) throws Exception {
        double r = Double.NaN;
        Parser.setX(x);
        r = Parser.getValue();
        return r;
    }

    public double[] eval(double[] x) throws Exception {
        int n = x.length;
        double[] r = new double[n];
        for (int i = 0; i < n; i++) {
            r[i] = eval(x[i]);
        }
        return r;

    }

    public double[] rango(double x0, double xn, double d) {
        int n = (int) (Math.abs(xn - x0) / d);
        double[] r = new double[n];
        for (int i = 0; i < n; i++) {
            r[i] = x0;
            x0 += d;

        }
        return r;
    }

}
