/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Dnevnik;
import domen.Fakultet;
import domen.StavkaDnevnika;
import domen.Student;
import domen.Zaposleni;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import kontroler.Kontroler;
import modeli.StavkaTableModel;

public class FormaDnevnik extends javax.swing.JDialog {

    private Dnevnik dnevnik;

    public FormaDnevnik(java.awt.Frame parent, Dnevnik dnevnik, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.dnevnik = dnevnik;

        popuniComboStudenata(Kontroler.getInstanca().vratiStudente());
        popuniComboFakulteta(Kontroler.getInstanca().vratiFakultete());
        popuniComboZaposlenih(Kontroler.getInstanca().vratiZaposlene());
        comboStudenti.setSelectedItem(null);
        comboFakulteti.setSelectedItem(null);
        comboZaposleni.setSelectedItem(null);
        popuniTabeluStavki(null);

        if (dnevnik != null) {
            comboStudenti.getModel().setSelectedItem(dnevnik.getStudent());
            comboZaposleni.getModel().setSelectedItem(dnevnik.getZaposleni());
            popuniTabeluStavki(dnevnik.getStavke());
            lblUkupnoTrajanje.setText("Ukupno trajanje prakse: " + dnevnik.getUkupnoTrajanje() + "h");
            txtMisljenje.setText(dnevnik.getMisljenjeKompanije());
            lblOcena.setText("Ocena (1-5): " + dnevnik.getOcena());
            lblDatum.setText("Datum izdavanja: " + dnevnik.getDatumIzdavanja());
        } else {
            otkljucajKomponente(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboZaposleni = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        lblUkupnoTrajanje = new javax.swing.JLabel();
        comboStudenti = new javax.swing.JComboBox<>();
        comboFakulteti = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMisljenje = new javax.swing.JTextArea();
        lblOcena = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        btnGenerisiIzvestaj = new javax.swing.JButton();
        btnIzmeniDnevnik = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Student:");

        jLabel2.setText("Fakultet:");

        jLabel3.setText("Mentor:");

        comboZaposleni.setEnabled(false);

        jLabel4.setText("Aktivnosti i zadaci");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStavke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStavkeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblStavke);

        lblUkupnoTrajanje.setText("Ukupno trajanje:");

        comboStudenti.setEnabled(false);
        comboStudenti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStudentiActionPerformed(evt);
            }
        });

        comboFakulteti.setEnabled(false);

        jLabel6.setText("<html>Misljenje<br>kompanije:</html>");

        txtMisljenje.setEditable(false);
        txtMisljenje.setColumns(20);
        txtMisljenje.setLineWrap(true);
        txtMisljenje.setRows(5);
        jScrollPane2.setViewportView(txtMisljenje);

        lblOcena.setText("Ocena: ");

        lblDatum.setText("Datum:");

        btnGenerisiIzvestaj.setText("Generisi dokument");
        btnGenerisiIzvestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerisiIzvestajActionPerformed(evt);
            }
        });

        btnIzmeniDnevnik.setText("Izmeni dnevnik");
        btnIzmeniDnevnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniDnevnikActionPerformed(evt);
            }
        });

        btnDodajStavku.setText("Dodaj aktivnost");
        btnDodajStavku.setEnabled(false);
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerisiIzvestaj)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboZaposleni, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboStudenti, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboFakulteti, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajStavku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIzmeniDnevnik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDatum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblOcena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblUkupnoTrajanje))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboStudenti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFakulteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboZaposleni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDodajStavku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUkupnoTrajanje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblOcena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDatum)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerisiIzvestaj)
                    .addComponent(btnIzmeniDnevnik))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStavkeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStavkeMousePressed
        // dodati
    }//GEN-LAST:event_tblStavkeMousePressed

    private void btnGenerisiIzvestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerisiIzvestajActionPerformed
        // dodati
    }//GEN-LAST:event_btnGenerisiIzvestajActionPerformed

    private void btnIzmeniDnevnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniDnevnikActionPerformed
        if (btnIzmeniDnevnik.getText().equals("Izmeni dnevnik")) {
            otkljucajKomponente(true);
            dnevnik.setDatumIzdavanja(LocalDate.now());
            lblDatum.setText("Datum izdavanja: " + LocalDate.now());
            btnIzmeniDnevnik.setText("Sacuvaj izmene");
        } else {
            otkljucajKomponente(false);

            dnevnik.setStudent((Student) comboStudenti.getSelectedItem());
            dnevnik.setZaposleni((Zaposleni) comboZaposleni.getSelectedItem());
            dnevnik.setStavke(vratiStavkeIzTabele());
            dnevnik.setMisljenjeKompanije(txtMisljenje.getText());
            dnevnik.setOcena(izracunajOcenu(dnevnik.getUkupnoTrajanje()));
            dnevnik.setDatumIzdavanja(LocalDate.now());

            Kontroler.getInstanca().izmeniDnevnik(dnevnik);

            btnIzmeniDnevnik.setText("Izmeni dnevnik");
        }
    }//GEN-LAST:event_btnIzmeniDnevnikActionPerformed

    private void comboStudentiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStudentiActionPerformed
        Student student = (Student) comboStudenti.getSelectedItem();
        if (student != null)
            comboFakulteti.getModel().setSelectedItem(student.getFakultet());
    }//GEN-LAST:event_comboStudentiActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        FormaStavka formaStavka = new FormaStavka(this, dnevnik, true);
        formaStavka.setVisible(true);
    }//GEN-LAST:event_btnDodajStavkuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnGenerisiIzvestaj;
    private javax.swing.JButton btnIzmeniDnevnik;
    private javax.swing.JComboBox<Fakultet> comboFakulteti;
    private javax.swing.JComboBox<Student> comboStudenti;
    private javax.swing.JComboBox<Zaposleni> comboZaposleni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblOcena;
    private javax.swing.JLabel lblUkupnoTrajanje;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextArea txtMisljenje;
    // End of variables declaration//GEN-END:variables

    private void popuniComboStudenata(List<Student> studenti) {
        for (Student student : studenti) {
            comboStudenti.addItem(student);
        }
    }

    private void popuniComboFakulteta(List<Fakultet> fakulteti) {
        for (Fakultet fakultet : fakulteti) {
            comboFakulteti.addItem(fakultet);
        }
    }

    private void popuniComboZaposlenih(List<Zaposleni> zaposleni) {
        for (Zaposleni z : zaposleni) {
            comboZaposleni.addItem(z);
        }
    }

    public void popuniTabeluStavki(List<StavkaDnevnika> stavke) {
        tblStavke.setModel(new StavkaTableModel(stavke));
        tblStavke.getColumnModel().getColumn(0).setMinWidth(0);
        tblStavke.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void otkljucajKomponente(boolean kljuc) {
        comboStudenti.setEnabled(kljuc);
        comboZaposleni.setEnabled(kljuc);
        btnDodajStavku.setEnabled(kljuc);
        btnGenerisiIzvestaj.setEnabled(!kljuc);
        txtMisljenje.setEditable(kljuc);
    }

    public int izracunajOcenu(int ukupnoTrajanje) {
        if (ukupnoTrajanje < 20) {
            return 1;
        }
        if (ukupnoTrajanje < 30) {
            return 2;
        }
        if (ukupnoTrajanje < 40) {
            return 3;
        }
        if (ukupnoTrajanje < 50) {
            return 4;
        }
        return 5;
    }

    public int izracunajUkupnoTrajanje(List<StavkaDnevnika> stavke) {
        int ukupnoTrajanje = 0;
        for (StavkaDnevnika stavkaDnevnika : stavke) {
            ukupnoTrajanje += stavkaDnevnika.getTrajanje();
        }
        return ukupnoTrajanje;
    }

    public void popuniPodatke() {
        int ukupnoTrajanje = izracunajUkupnoTrajanje(((StavkaTableModel) tblStavke.getModel()).getStavke());
        lblUkupnoTrajanje.setText("Ukupno trajanje prakse: " + ukupnoTrajanje + "h");
        lblOcena.setText("Ocena (1-5): " + izracunajOcenu(ukupnoTrajanje));
    }

    private List<StavkaDnevnika> vratiStavkeIzTabele() {
        List<StavkaDnevnika> stavke = new ArrayList<>();
        for (int i = 0; i < tblStavke.getRowCount(); i++) {
            StavkaDnevnika stavka = (StavkaDnevnika) tblStavke.getValueAt(i, 0);
            stavke.add(stavka);
        }
        return stavke;
    }

    public JTable getTblStavke() {
        return tblStavke;
    }

}
