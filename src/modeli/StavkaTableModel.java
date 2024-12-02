package modeli;

import domen.StavkaDnevnika;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StavkaTableModel extends AbstractTableModel {

    private List<StavkaDnevnika> stavke;
    private String[] kolone = {"Objekat", "Redni broj", "Zadatak", "Trajanje (h)"};

    public StavkaTableModel(List<StavkaDnevnika> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        if (stavke == null) {
            return 0;
        }
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (stavke == null) {
            return null;
        }
        StavkaDnevnika stavka = stavke.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return stavka;
            case 1:
                return (rowIndex + 1) + ".";
            case 2:
                return stavka.getZadatak();
            case 3:
                return stavka.getTrajanje();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRed(StavkaDnevnika stavka) {
        stavke.add(stavka);
        fireTableRowsInserted(stavke.size() - 1, stavke.size() - 1);
    }

    public List<StavkaDnevnika> getStavke() {
        return stavke;
    }

}
