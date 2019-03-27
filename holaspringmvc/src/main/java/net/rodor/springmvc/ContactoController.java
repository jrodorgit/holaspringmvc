package net.rodor.springmvc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Controller
@RequestMapping("/contact")
public class ContactoController {

	@RequestMapping("/")
	public String goContact(ModelMap model) {
		System.out.println("Entrando en goContact");
		return "contact/contacto";
	}

	@RequestMapping(value = "/generarPDF", method = RequestMethod.POST)
	public String generarPDF(@ModelAttribute("editor1") String editor1, ModelMap model) {

		System.out.println("generarPDF..." + editor1);

		Document document = null;
        byte[] ficheroPdfBytes = null;
		document = new Document(PageSize.A4);
		File tmp;
		try {
			
			tmp = File.createTempFile("C:/Java/pruebackeditor", ".pdf");

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(tmp));

			document.open();

			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
					new ByteArrayInputStream(editor1.getBytes()));

			document.close();

			FileInputStream fIn = new FileInputStream(tmp);
            ficheroPdfBytes = new byte[(int) tmp.length()];
            fIn.read(ficheroPdfBytes);
            fIn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "contact/contacto";
	}
}
