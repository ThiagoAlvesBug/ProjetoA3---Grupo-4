import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4 || columnIndex == 5) { // Índices das colunas com botões
            return JButton.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 4 || column == 5; // Índices das colunas com botões
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        if (column == 4 || column == 5) { // Índices das colunas com botões
            // Lógica para lidar com o clique nos botões
            System.out.println("Botão pressionado na linha: " + row + ", coluna: " + column);
        } else {
            super.setValueAt(aValue, row, column);
        }
    }
}