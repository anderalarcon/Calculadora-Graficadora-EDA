/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaficadora;

//hfhfjh
/**
 *
 * @author NOBLEX
 */
public class CalculadorC {

    private javax.swing.JTextField jTextField1;

    double disp[] = new double[10];
    double[] memoria = new double[50];
    int i = 0;
    int deci = 0;
    int j = 0;
    int doit = 0;
    int nodob = 0, nodobt = 1;
    int trig = 0;
    double mpn = Math.PI / 180;

    public void setMpn(double mpn) {
        this.mpn = mpn;
    }
    String m = "";

    public CalculadorC(javax.swing.JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    void setNumero(int u) {

        if (deci == 1) {
            i = -i;
            disp[j] = disp[j] + (double) (u * Math.pow(10.0000, i) * 100) / 100;
        } else {
            disp[j] = (disp[j] * 10) + u;
        }

        imprimir();

        if (deci == 1) {
            i = -i;
        }

        i++;
        nodob = 1;
    }

    void imprimir() {
        if (trig == 1) {
            jTextField1.setText(disp[j - 1] + m + disp[j] + "");
        } else {
            jTextField1.setText(disp[j] + "");
        }
    }

    public void setComa() {
        if (nodob == 3 || deci == 1) {
            return;
        }
        i = 1;
        deci = 1;
        nodob = 3;
    }

    void setMedio(int z) {
        if (nodob == 0) {
            return;
        }

        i = 0;
        deci = 0;
        nodobt = 1;
        doit = z;
        nodob = 0;
        j++;
        if (j > 9) {
            j = 0;
        }
    }

    public void getResultado() {

        String olay = "";
        if (nodob == 0) {
            return;
        }

        switch (doit) {
            //SUMA
            case (2):
                disp[j] = disp[j - 1] + disp[j];
                break;
            //RESTA
            case (3):
                disp[j] = disp[j - 1] - disp[j];
                break;
            //DIVISION
            case (4):
                if (disp[j] == 0) {
                    olay = "NO SE PUEDE DIVIDIR SOBRE CERO";
                    disp[j] = 0;
                } else {
                    disp[j] = disp[j - 1] / disp[j];
                }
                break;
            //MULTIPLICACION
            case (5):
                disp[j] = disp[j - 1] * disp[j];
                break;
            //SENO
            case (6):
                if (mpn == Math.PI / 180 && disp[j] == 0) {
                    trig = 0;
                    jTextField1.setText(disp[j] + olay);
                    nodobt = 1;
                } else {
                    disp[j] = disp[j - 1] * Math.sin(disp[j] * mpn);
                    trig = 0;
                }
                break;
            //COSENO
            case (7):
                if (mpn == Math.PI / 180 && disp[j] == 90) {
                    disp[j] = 0;
                    trig = 0;
                    jTextField1.setText(disp[j] + olay);
                    nodobt = 1;
                } else {

                    disp[j] = disp[j - 1] * Math.cos(disp[j] * mpn);
                    trig = 0;
                }
                break;
            //TANGENTE
            case (8):
                if (mpn == Math.PI / 180 && disp[j] == 90) {

                    trig = 0;
                    olay = "ESTA OPERACIÓN NO SE PUEDE EFECTUAR";
                    jTextField1.setText(disp[j] + olay);
                    nodobt = 1;
                } else {
                    disp[j] = disp[j - 1] * Math.tan(disp[j] * mpn);
                    trig = 0;
                }
                break;
        }

        jTextField1.setText(disp[j] + olay);
        j++;
        disp[j] = 0;
        nodob = 0;
        nodobt = 1;
        i = 0;
    }

    void purgar() {
        i = 0;
        j = 0;
        doit = 0;
        deci = 0;
        jTextField1.setText("0");
        for (int u = 0; u <= 9; u++) {
            disp[u] = 0;
        }
        nodob = 0;
        trig = 0;
        m = "";
        nodobt = 1;
    }

    int t = 0;

    public void mMas() {
        memoria[t] = disp[j];
        t++;
        purgar();
        jTextField1.setText(memoria[t - 1] + " ->sumado");
    }

    public void mMenos() {
        memoria[t] = -disp[j];
        t++;
        jTextField1.setText(memoria[t - 1] + " ->restado");
    }

    public void setMemoria() {
        int temp = 0;
        for (int g = 0; g < t; g++) {
            temp += memoria[g];
        }
        jTextField1.setText(temp + "");
    }

    public void limpiarMemoria() {
        t = 0;
        jTextField1.setText("MEMORIA BORRADA");
    }

    public void cuadrado() {
        disp[j] = Math.pow(disp[j], 2);
        jTextField1.setText(disp[j] + "");
    }

    public void raiz() {
        disp[j] = Math.pow(disp[j], 0.5);
        jTextField1.setText(disp[j] + "");
    }

    public void ce() {
        disp[j] = 0;
        j = j - 1;
        i = 0;
        doit = 0;
        jTextField1.setText("");
    }

    public void pi() {
        disp[j] = Math.PI;
        jTextField1.setText(disp[j] + "");
    }

    void trigono(String k, int tt) {
        if (nodobt == 0) {
            return;
        }
        if (disp[j] == 0) {
            jTextField1.setText(k);
            disp[j] = 1;
        } else {
            jTextField1.setText(disp[j] + k);
        }
        doit = tt;
        nodobt = 0;
        m = k;
        imprimir();
        j++;
        trig = 1;
    }

}
