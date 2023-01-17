package com.cdc.factura.app.services;

import java.util.List;

import com.cdc.factura.app.model.invoceModel;

public interface IInvoceService {

	List<invoceModel> listarPorID(String numero_otorgante);
	List<invoceModel> listar();
	
}
