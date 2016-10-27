package studygui.examples.myswingexamples;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OTBA}|{HbIu` on 07.10.16.
 */
public class RssFeedTableModel extends AbstractTableModel implements TableModel{
    private List<FeedMessage> entries=new ArrayList<>();

    public void updateData(List<FeedMessage> entries){
        this.entries=entries;
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return entries.get(rowIndex).title;
            case 1:
                return entries.get(rowIndex).publicationDate;
        }

        return null;
    }
}
