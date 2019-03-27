package net.rodor.springmvc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Controller
@RequestMapping("/summernote")
public class SummerNoteController {
	
	@RequestMapping("/")
	public String goSummerNote(){
		System.out.println("Entrando en goSummerNote");
		return "summernote/HelloSummer";
	}
	@RequestMapping(value = "/generarPDFWithSummerNote", method = RequestMethod.POST)
	public String generarPDF(@ModelAttribute("textoSM") String textoSM, ModelMap model) {

		System.out.println("generarPDF con el siguiente texto..." + textoSM);

		Document document = null;
        byte[] ficheroPdfBytes = null;
		document = new Document(PageSize.A4);
		document.setMargins(60, 60, 60, 60);
		File tmp;
		try {
			/***/
			tmp = File.createTempFile("C:/Java/pruebackeditor", ".pdf");

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(tmp));

			document.open();
			// cabeceras y pies
			HeaderFooter event = new HeaderFooter();
			writer.setPageEvent(event);
			
						
			// limpiar lo que no le gusta
			textoSM = textoSM.replace("<br>", "");
			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
					new ByteArrayInputStream(textoSM.getBytes()));

			document.close();

			FileInputStream fIn = new FileInputStream(tmp);
            ficheroPdfBytes = new byte[(int) tmp.length()];
            fIn.read(ficheroPdfBytes);
            fIn.close();
/****/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "summernote/HelloSummer";
	}
}
