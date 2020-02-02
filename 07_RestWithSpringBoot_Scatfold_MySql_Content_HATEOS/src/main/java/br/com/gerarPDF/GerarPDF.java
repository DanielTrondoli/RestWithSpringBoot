package br.com.gerarPDF;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.yaml.snakeyaml.constructor.BaseConstructor;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class GerarPDF {

	
    
	public static void main(String[] args) {
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("MEuPDF.pdf"));
			
			document.open();
			Image image = Image.getInstance("c:\\Users\\ddepaulatron\\Documents\\Outros Projetos\\RestWithSpringBoot\\logo_UNESP_completo.png");
			
			document.add(image);
			
			document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.TIMES_ITALIC,12,Font.BOLD)));
			document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.TIMES_ITALIC,12,Font.BOLD)));
			document.add(new Paragraph("\n", FontFactory.getFont(FontFactory.TIMES_ITALIC,12,Font.BOLD)));
		
			document.add(new Paragraph("ATESTADO DE MATRÍCULA"));
			document.add(new Paragraph("ATESTO, para os devidos fins, que Daniel de Paula Trondoli, RA nº 152421981, portador da cédula de identidade 13.056.872-48, expedido pela SSP/BA, é aluno regularmente matriculado no 2º semestre do ano letivo de 2019, no Curso de Ciências econômicas - período Noturno (Curso reconhecido pela Portaria CEE/GP n° 38, de 17/02/2016, publicada no D.O.E. de 18/02/2016, republicada em 19/10/2016.), da Faculdade de Ciências e Letras - UNESP - Câmpus de Araraquara.",
										FontFactory.getFont(FontFactory.TIMES_ITALIC,11)));
			
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRO NA criacao do PDF");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Desktop.getDesktop().open(new File("MEuPDF.pdf"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
