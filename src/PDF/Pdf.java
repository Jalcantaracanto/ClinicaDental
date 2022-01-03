/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;

/**
 *
 * @author Zuukens
 */
public class Pdf {
       
    
    public void Crearpdf(String texto) throws IOException{
        PdfWriter writer = new PdfWriter ("D:\\Universidad\\Proyectos Java\\ClinicaDental\\PDF\\CodigoDental.pdf");
        PdfDocument pdf = new PdfDocument (writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(texto));
        document.close();
    }

}
