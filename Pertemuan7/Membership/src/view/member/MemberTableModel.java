package tugas7.Membership.src.view.member;

import java.util.List;
import javax.swing.table.*;
import tugas7.Membership.src.model.Member;

public class MemberTableModel extends AbstractTableModel{
    private String[] columnNames = {"Nama", "Jenis Member"};
    private List<Member> data;

    public MemberTableModel(List<Member> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Object getValueAt(int row, int column) {
        Member member = data.get(row);
        String value = "";
        switch (column){
            case 0:
                value = member.getNama();
                break;
            case 1:
                value = member.getJenisMember().getNama();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void add (Member value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}