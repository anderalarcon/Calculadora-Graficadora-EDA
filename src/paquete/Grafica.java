
package paquete;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Grafica {

    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String x;
    String y;

    public Grafica(String t, String x1, String y1) {
        titulo = t;
        x = x1;
        y = y1;
        grafica = ChartFactory.createXYLineChart(titulo, x, y,
                datos, PlotOrientation.VERTICAL, true, true, true);

    }

    public Grafica() {
        this("", "x", "y");

    }

    public void agregarGrafica(String id, double[] x, double[] y) {
        XYSeries a = new XYSeries(id);
        int n = x.length;
        for (int i = 0; i < n; i++) {
            a.add(x[i], y[i]);

        }
        datos.addSeries(a);
    }

    public void crearGrafica(String id, double[] x, double[] y) {
        datos.removeAllSeries();
        agregarGrafica(id, x, y);
    }

    public JPanel obtieneGrafica() {
        return new ChartPanel(grafica);

    }

}
