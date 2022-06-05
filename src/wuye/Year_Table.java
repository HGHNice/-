package wuye;

import javax.swing.*;

public class Year_Table extends JFrame{
    EstateSQL estateSQL;
    public Year_Table(EstateSQL estateSQL) {
        this.estateSQL = estateSQL;
    }
    public void run() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
    void init() {
        setTitle("年报表");
        JTable table;
        Object[][] tableData = estateSQL.getYearTable();
        Object[] columnTitle = estateSQL.getMonthTableTitle();
        table = new JTable(tableData , columnTitle);
        add(new JScrollPane(table));
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
