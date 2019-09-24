package com.hampcode.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.hampcode.model.entity.OrdenInsumo;
import com.hampcode.util.Message;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfController {
	public void generarPdf(OrdenInsumo ordenInsumo) throws FileNotFoundException, DocumentException {
		FileOutputStream archivo = new FileOutputStream("Orden de Insumo_" + ordenInsumo.getId() + ".pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();

		Paragraph parrafo = new Paragraph("Orden Insumo");
		parrafo.setAlignment(1);
		documento.add(parrafo);
		
		documento.add(new Paragraph("Id:" + ordenInsumo.getId()));
		documento.add(new Paragraph("Orden de compra:" + ordenInsumo.getOrdenCompra().getDescripcion()));
		documento.add(new Paragraph("Insumo:" + ordenInsumo.getInsumo().getNombreInsumo()));
		documento.add(new Paragraph("Cantidad:" + ordenInsumo.getCantidad()));
		documento.add(new Paragraph("Costo:" + ordenInsumo.getCosto()));
		documento.close();

		Message.messageInfo("Documento generado exitosamente");
	}
}
