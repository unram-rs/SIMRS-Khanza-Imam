/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class WarnaTableRanap extends DefaultTableCellRenderer {
    public int kolom = 15;      // kolom Ttl. Biaya
    public int statbayar = 20;  // kolom Status Bayar
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // warna default genap-ganjil
        if (row % 2 == 1){
            component.setBackground(new Color(255,244,244));
        } else {
            component.setBackground(new Color(255,255,255));
        } 
        component.setForeground(Color.BLACK);

        try {
            // ambil status bayar
            String status = table.getValueAt(row, statbayar).toString().trim();

            // ambil biaya
            String biayaStr = table.getValueAt(row, kolom).toString().replaceAll("[^\\d]", "");
            long biaya = Long.parseLong(biayaStr);

            // kondisi: status belum bayar + biaya > 3.000.000
            if (status.equalsIgnoreCase("Belum Bayar") && biaya > 3000000) {
                component.setBackground(Color.RED);
                component.setForeground(Color.WHITE);
            }

        } catch (Exception e) {
            // abaikan error parsing
        }

        return component;
    }
}




