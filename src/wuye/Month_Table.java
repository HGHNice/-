package wuye;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

public class Month_Table extends JFrame {
    EstateSQL estateSQL;
    public Month_Table(EstateSQL estateSQL) {
        this.estateSQL = estateSQL;
    }
    public void run() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
    void init() {
        setTitle("月报表");
        JTable table;
        Object[][] tableData = estateSQL.getMonthTable();
        Object[] columnTitle = estateSQL.getMonthTableTitle();
        table = new JTable(tableData , columnTitle);
        add(new JScrollPane(table));
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
