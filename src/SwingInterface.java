import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import javax.swing.*;


public class SwingInterface implements Runnable {




    public void run() {
        JButton startButton = new JButton("Start");
        JButton quitButton = new JButton("Schließen");
        JTextField eingabeField = new JTextField();
        JTextField ausgabeField = new JTextField();

        JPanel text = new JPanel();
        text.add(new JLabel("--->"));

        Listening listener = new Listening(startButton,quitButton,eingabeField,ausgabeField);
        startButton.addActionListener(listener);
        quitButton.addActionListener(listener);

        JFrame frame = new JFrame("Hello, !");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contents = frame.getContentPane();
        contents.add(startButton,BorderLayout.NORTH);
        contents.add(quitButton, BorderLayout.SOUTH);
        //contents.add(text, BorderLayout.CENTER);
        contents.add(eingabeField, BorderLayout.CENTER);
       // contents.add(ausgabeField, BorderLayout.EAST);
        frame.setSize(400,300);

        frame.setVisible(true);

    }



    public static void main(String[] args){
        SwingInterface se = new SwingInterface();
        SwingUtilities.invokeLater(se);
    }
    public class Listening implements ActionListener{
        private JButton start;
        private JButton quit;
        private JTextField eingabe;
        private JTextField ausgabe;
        private Listening(JButton i, JButton q, JTextField f, JTextField t){
            start = i;
            quit = q;
            eingabe = f;
            ausgabe = t;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start){
                String o = "";
                String t = eingabe.getText();
                String ergebnis = "";
                Body work = new Body();
                try {

                    o = work.hash(t);

                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }
                try {

                    ergebnis = work.brute(4,'z',o);

                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }
                eingabe.setText(t +"-->"+ ergebnis);
            }

            if (e.getSource() == quit){
                System.exit(4);
            }
        }
    }


}
