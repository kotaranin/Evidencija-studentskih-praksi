package modeli;

import domen.Dnevnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DnevnikTableModel extends AbstractTableModel {

    private List<Dnevnik> dnevnici;
    private String[] kolone = {"Objekat", "Student", "Zaposleni", "Datum izdavanja"};

    public DnevnikTableModel(List<Dnevnik> dnevnici) {
        this.dnevnici = dnevnici;
    }

    @Override
    public int getRowCount() {
        return dnevnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dnevnik dnevnik = dnevnici.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dnevnik;
            case 1:
                return dnevnik.getStudent();
            case 2:
                return dnevnik.getZaposleni();
            case 3:
                return dnevnik.getDatumIzdavanja();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

}
