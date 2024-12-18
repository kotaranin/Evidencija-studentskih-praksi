/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paneli;

import forme.GlavnaForma;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Uros
 */
public class MeniPanel extends javax.swing.JPanel {

    private Window roditelj;
    private String[] stavke = {"Pocetna", "Dnevnici", "Studenti", "Zaposleni"};

    /**
     * Creates new form MeniPanel
     */
    public MeniPanel(Window roditelj) {
        initComponents();
        this.roditelj = roditelj;

        pnlGornji.setLayout(new BoxLayout(pnlGornji, BoxLayout.Y_AXIS));
        JLabel lblNaslov = new JLabel("<html><u>Evidencija<br>studentskih<br>praksi</u></html>");
        lblNaslov.setAlignmentX(LEFT_ALIGNMENT);
        lblNaslov.setFont(new Font("Sergoe UI", 0, 18));
        pnlGornji.add(lblNaslov);

        pnlDonji.setLayout(new BoxLayout(pnlDonji, BoxLayout.Y_AXIS));

        for (int i = 0; i < stavke.length; i++) {
            JLabel labela = new JLabel(stavke[i]);

            labela.setAlignmentX(LEFT_ALIGNMENT);
            labela.setFont(new Font("Sergoe UI", 0, 16));
            labela.setBorder(new EmptyBorder(8, 3, 8, 0));

            labela.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    JPanel pnlDesno = ((GlavnaForma) roditelj).getPnlDesno();
                    pnlDesno.setLayout(new BorderLayout());

                    switch (labela.getText()) {
                        case "Pocetna":
                            pnlDesno.add(new PocetnaPanel(roditelj));
                            break;
                        case "Dnevnici":
                            pnlDesno.add(new DnevniciPanel(roditelj));
                            break;
                        //Dodati ostale stranice
                        default:
                            throw new AssertionError("Neimplementirani paneli");
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    labela.setFont(new Font("Sergoe UI", Font.BOLD, 16));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    labela.setFont(new Font("Sergoe UI", 0, 16));
                }
            });
            pnlDonji.add(labela);
        }

        JLabel lblKorisnik = new JLabel("Korisnik: " + ((GlavnaForma) roditelj).getUlogovaniZaposleni());
        lblKorisnik.setAlignmentY(BOTTOM_ALIGNMENT);
        lblKorisnik.setFont(new Font("Sergoe UI", Font.ITALIC, 12));
        lblKorisnik.setBorder(new EmptyBorder(8, 0, 8, 0));
        pnlDonji.add(lblKorisnik);

        JButton btnOdjava = new JButton("Odjava");
        btnOdjava.setAlignmentY(BOTTOM_ALIGNMENT);
        btnOdjava.setFont(new Font("Sergoe UI", 0, 12));
        btnOdjava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((GlavnaForma) roditelj).odjaviSe();
            }
        });
        pnlDonji.add(btnOdjava);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGornji = new javax.swing.JPanel();
        pnlDonji = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(201, 488));

        javax.swing.GroupLayout pnlGornjiLayout = new javax.swing.GroupLayout(pnlGornji);
        pnlGornji.setLayout(pnlGornjiLayout);
        pnlGornjiLayout.setHorizontalGroup(
            pnlGornjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        pnlGornjiLayout.setVerticalGroup(
            pnlGornjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDonjiLayout = new javax.swing.GroupLayout(pnlDonji);
        pnlDonji.setLayout(pnlDonjiLayout);
        pnlDonjiLayout.setHorizontalGroup(
            pnlDonjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        pnlDonjiLayout.setVerticalGroup(
            pnlDonjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDonji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGornji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGornji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDonji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlDonji;
    private javax.swing.JPanel pnlGornji;
    // End of variables declaration//GEN-END:variables
}
