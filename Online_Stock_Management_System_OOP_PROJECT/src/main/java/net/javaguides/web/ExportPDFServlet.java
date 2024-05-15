package net.javaguides.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document; // Add this import statement
import com.itextpdf.text.DocumentException; // Add this import statement
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.javaguides.dao.SupplierDAO;
import net.javaguides.model.Supplier;

@WebServlet("/exportPDF")
public class ExportPDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SupplierDAO supplierDAO;

    public void init() {
        supplierDAO = new SupplierDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Address");
            table.addCell("Email");
            table.addCell("Phone");

            List<Supplier> listSuppliers = supplierDAO.selectAllSuppliers();

            for (Supplier supplier : listSuppliers) {
                table.addCell(String.valueOf(supplier.getId()));
                table.addCell(supplier.getName());
                table.addCell(supplier.getAddress());
                table.addCell(supplier.getEmail());
                table.addCell(supplier.getPhone());
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
