package pl.exsio.gol.db;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Cursor;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import pl.exsio.gol.main.Main;
import pl.exsio.gol.model.Cell;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DbManager {
    
    private Main m;
    private Database db;
    private Table tab;

    public DbManager(Main m) {

        this.m = m;
        try {
            this.init();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   private void init() throws SQLException {

         File file = new File("db.mdb");
         if (file.exists()) {

             try {
                db = Database.open(new File("db.mdb"));
                tab = db.getTable("schemas");

            } catch (IOException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }

         } else {

            try {
                db = Database.create(new File("db.mdb"));
                tab = new TableBuilder("schemas")
                        .addColumn(new ColumnBuilder("id")
                                     .setSQLType(Types.INTEGER).setAutoNumber(true)
                                     .toColumn())
                          .addColumn(new ColumnBuilder("name")
                                     .setSQLType(Types.VARCHAR)
                                     .toColumn())
                          .addColumn(new ColumnBuilder("mesh")
                                     .setSQLType(Types.LONGVARCHAR)
                                     .toColumn())
                          .toTable(db);

            } catch (IOException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }

         }

    }

   public void saveSchema(Cell[][] Grid) {

            String name = JOptionPane.showInputDialog("Enter schema name");
            if (name!=null) {

                   LinkedList mesh = new LinkedList();

                   for (int i=0; i<Grid.length;i++) {
                        for (int j=0; j<Grid[i].length;j++) {
                            if (Grid[i][j].isPopulated())
                                mesh.add(i+"~"+j);
                        }
                    }

                    try {

                        Map<String, Object> row = Cursor.findRow(tab, Collections.singletonMap("name", (Object) name));
                        if(row == null)
                        {

                                tab.addRow("",name, mesh.toString().substring(1, mesh.toString().length()-1));
                                m.updateSchemasList();

                        } else
                                JOptionPane.showMessageDialog(null, "This schema already exists!");

                    } catch (IOException ex) {
                        Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
   }

   public DefaultComboBoxModel getSchemas() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("= empty =");
        for(Map<String, Object> row : tab) 
            model.addElement(row.get("name").toString());

        return model;

   }

   public String[] getTooltips() {

        String[] schemas = new String[tab.getRowCount()+1];
        int i = 1;
        schemas[0] = "pusta siatka";
        for(Map<String, Object> row : tab) {

           schemas[i] = row.get("name").toString();
           i++;

        }
        return schemas;
   }

   public void openSchema(Cell[][] Grid) {
        m.clearGrid();
        try {

                Map<String, Object> row = Cursor.findRow(tab, Collections.singletonMap("name", (Object) m.getSelectedSchema()));
          
                try {

                         this.loadSchema(Grid, row.get("mesh").toString());

                 } catch(Exception e) {

                }
        } catch (IOException ex) {

            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);

        }

   }

   public void deleteSchema() {
        try {

            Cursor cur=Cursor.createCursor(tab);
            while (1==1) {

              if(cur.getNextRow().get("name").toString().equals(m.getSelectedSchema()))
              {
                  cur.deleteCurrentRow();
                  break;
              }

           }
            
           m.updateSchemasList();

        } catch (IOException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) { 
        }
   }

   private void loadSchema(Cell[][] Grid,String mesh) {

       String[] cells = mesh.split(",");
       for (int i=0; i<cells.length;i++) {
                try {

                        this.loadCell(Grid,cells[i]);

                } catch(Exception e) {

                }
       }

   }

   private void loadCell(Cell[][] Grid, String cell) {

        String c[] = cell.split("~");
        Grid[Integer.parseInt(c[0].trim())][Integer.parseInt(c[1].trim())].setPopulated(true);

   }
}
