package snake.main;

import snake.snake.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Option extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;

    private Main parent;
    private final Option before = this;

    private JSlider speed = new JSlider(0, 100, 50);
    private JSlider nbrCaseX = new JSlider(10, 100, 20);
    private JSlider nbrCaseY = new JSlider(10, 100, 20);
    private JButton but = new JButton("Valider");

    private JPanel block1 = new JPanel();
    private JPanel block2 = new JPanel();
    private JPanel block3 = new JPanel();
    private JPanel block4 = new JPanel();

    /**
     * Constructeur de la boite de dialog Option
     *
     * @param _parent Fenetre mere
     */
    public Option(Main _parent) {
        super(new JDialog(), "Options", true);

        this.parent = _parent;

        this.setResizable(true);
        this.setLayout(new GridLayout(4, 1));
        this.setPreferredSize(new Dimension(600, 140));

        block1.setLayout(new FlowLayout());

        speed.setMajorTickSpacing(10);
        speed.setPaintTicks(true);
        speed.setPaintLabels(true);

        block1.add(new JLabel("Vitesse: "));
        block1.add(speed);

        block2.setLayout(new FlowLayout());

        nbrCaseX.setMajorTickSpacing(10);
        nbrCaseX.setPaintTicks(true);
        nbrCaseX.setPaintLabels(true);

        block2.add(new JLabel("Nombre ligne: "));
        block2.add(nbrCaseX);

        block3.setLayout(new FlowLayout());

        nbrCaseY.setMajorTickSpacing(10);
        nbrCaseY.setPaintTicks(true);
        nbrCaseY.setPaintLabels(true);

        block3.add(new JLabel("Nombre colone: "));
        block3.add(nbrCaseY);

        but.addActionListener(arg0 -> {
            Data.NBRCASEX = (short) before.nbrCaseX.getValue();
            Data.NBRCASEY = (short) before.nbrCaseY.getValue();
            Data.SNAKESPEED = before.speed.getValue();

            before.dispose();
            parent.replay();
        });

        block4.setLayout(new FlowLayout());
        block4.add(but);

        this.add(block1);
        this.add(block2);
        this.add(block3);
        this.add(block4);

        this.setSize(new Dimension(350, 250));
    }

    public void actionPerformed(ActionEvent e) {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

