package com.cdc.factura.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdc.factura.app.model.invoceModel;
import com.cdc.factura.app.repository.invoceRepository;
import com.cdc.factura.app.services.IInvoceService;

@Service
public class invoceServiceImpl implements IInvoceService {

	@Autowired
	private invoceRepository invoceRespository;
	
	@Override
	public List<invoceModel> listarPorID(String numeroOtorgante) {

		return invoceRespository.findBynumeroOtorgante(numeroOtorgante);
	}

	@Override
	public List<invoceModel> listar() {
		// TODO Auto-generated method stub
		return (List<invoceModel>) invoceRespository.findAll();
	}

}
