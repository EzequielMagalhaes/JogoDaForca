import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman extends JFrame {

    private int errei = 0;
    private String [] palavras = {
        "ENFORCADO", "REPROVADO", "REARRUMADO", "FIGUEIRA",
        "EMPOSSADO", "MUDANÇA", "REFORMA", "GIROSCÓPIO"
    };
    private String palavraSorteada;
    private String palavraEscondida;
    private JLabel lbEscondida;

    public Hangman() {
        this.setTitle("Enforcado");
        this.setSize(600,400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        palavraSorteada = palavras[(int)(Math.random()*palavras.length)];
        esconderPalavra();
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(1,2)); // 1 linha, 2 colunas.
        lbEscondida = new JLabel(palavraEscondida);
        pn.add(new JLabel());
        pn.add(lbEscondida);
        this.add(pn);
        this.setVisible(true);
    }

    private void esconderPalavra() {
        palavraEscondida = "";
        for (int i = 0; i < palavraSorteada.length(); i += 1) {
            palavraEscondida += "_ ";
        }
    }

    private boolean verificarLetra(char c) {
        for (int i = 0; i < palavraSorteada.length(); i += 1) {
            if (c == palavraSorteada.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private void substituirTraco(char c) {
        String mnt = "";
        for (int i = 0; i < palavraSorteada.length(); i += 1) {
            if (c == palavraSorteada.charAt(i)) {
                mnt += "" + c + " ";
            } else {
                int x = i * 2;
                mnt += "" + palavraEscondida.charAt(x) + " ";
            }    
        }
        palavraEscondida = mnt;                
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(110,100,110,300);
        g.drawLine(110,100,210,100);
        g.drawLine(210,100,210,120);
        if (errei > 0) {
            // Cabeça
            g.drawOval(200,120,20,30);
        }
        if (errei > 1) {
            // Tronco
            g.drawLine(210,150,210,200);
        }
        if (errei > 2) {
            // Pernas
            g.drawLine(210,200,190,240);
        }
        if (errei > 3) {
            g.drawLine(210,200,230,240);
        }
        if (errei > 4) {
            // Braços
            g.drawLine(210,160,180,180);
        }
        if (errei > 5) {
            g.drawLine(210,160,240,180);
            g.setColor(new Color(255,0,0));
            g.fillOval(200,120,20,30);
        }
    }

    public static void main(String [] args) {
        new Hangman();
    }
}