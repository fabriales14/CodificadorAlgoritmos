/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import libcomp.Alfabeto;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Meli
 */
public class DAOAlfabetos implements IValidable {

    ArrayList<Alfabeto> alfabetos = new ArrayList<>();

    public DAOAlfabetos() {
        alfabetos = leerExcel();
    }
    

    @Override
    public boolean validar(Object obj) {
        Alfabeto a = (Alfabeto) obj;
        for (int i = 0; i < a.getSimbolos().length(); i++){
            char caracter = a.getSimbolos().charAt(i);
            int count = 0;
            for (int j = 0; j < a.getSimbolos().length(); j++){
                if (a.getSimbolos().charAt(j) == caracter)
                    count++;
            }
            if (count >= 2)
                return false;
        }
        for (int i = 0; i < a.getSimbolos_ignorados().length(); i++){
            char c = a.getSimbolos_ignorados().charAt(i);
            for (int j = 0; j < a.getSimbolos().length(); j++){
                if (a.getSimbolos().charAt(j) == c)
                    return false;
            }
        }
        for (Alfabeto alfabeto : alfabetos) {
            if (alfabeto.getId() == a.getId() || alfabeto.getNombre().equals(a.getNombre())
                    || alfabeto.getSimbolos().equals(a.getSimbolos())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList getAlfabetos() {
        this.alfabetos = leerExcel();
        return alfabetos;
    }

    public void setAlfabetos(ArrayList<Alfabeto> alfabetos) {
        this.alfabetos = alfabetos;
        reescribirExcel();
    }       

    public boolean agregar(Alfabeto alfabeto) {
        if (validar(alfabeto)) {
            this.alfabetos.add(alfabeto);
            reescribirExcel();
            return true;
        }
        return false;
    }

    public Alfabeto consultar(int id) {
        for (Alfabeto a : alfabetos) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Alfabeto consultar(String nombre) {
        for (Alfabeto a : alfabetos) {
            if (a.getNombre().trim().equals(nombre.trim())) {
                return a;
            }
        }
        return null;
    }

    public boolean modificar(int i, Alfabeto a) {
        for (Alfabeto alfabeto : alfabetos) {
            if (alfabeto.getId() == a.getId()) {
                alfabeto.setNombre(a.getNombre());
                alfabeto.setSimbolos(a.getSimbolos());;
                alfabeto.setSimbolos_ignorados(a.getSimbolos_ignorados());;
                reescribirExcel();
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(int id) {
        for (Alfabeto alfabeto : alfabetos) {
            if (alfabeto.getId() == id) {
                alfabetos.remove(alfabeto);
                reescribirExcel();
                return true;
            }
        }
        return false;
    }

    private void reescribirExcel() {
        File file = new File("Alfabetos.xls");
        if (file.exists()) {
            file.delete();
        }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Alfabetos");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("Nombre");
        cell = row.createCell(2);
        cell.setCellValue("Simbolos");
        cell = row.createCell(3);
        cell.setCellValue("Ignorados");

        for (int i = 0; i < alfabetos.size(); i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(alfabetos.get(i).getId());
            cell = row.createCell(1);
            cell.setCellValue(alfabetos.get(i).getNombre());
            cell = row.createCell(2);
            cell.setCellValue(alfabetos.get(i).getSimbolos());
            cell = row.createCell(3);
            cell.setCellValue(alfabetos.get(i).getSimbolos_ignorados());
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    private ArrayList leerExcel() {
        ArrayList<Alfabeto> lista = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File("Alfabetos.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(0);
                int id = (int) cell.getNumericCellValue();
                cell = row.getCell(1);
                String nombre = cell.getStringCellValue();
                cell = row.getCell(2);
                String simbolos = cell.getStringCellValue();
                cell = row.getCell(3);
                String ignorados = cell.getStringCellValue();
                Alfabeto a = new Alfabeto(id, nombre, simbolos, ignorados);
                lista.add(a);
            }
            file.close();
            FileOutputStream out
                    = new FileOutputStream(new File("Alfabetos.xls"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
