package com.cdc.factura.app.auth;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;
import org.scribe.services.SignatureService;

public class FacturacionAuthService extends DefaultApi10a {

	private static class InstanceHolder {
		private static final FacturacionAuthService INSTANCE = new FacturacionAuthService();
	}

	public static FacturacionAuthService instance() {
		return InstanceHolder.INSTANCE;
	}

	public FacturacionAuthService() {
	}

	@Override
	public SignatureService getSignatureService() {
		return new HMACSha256SignatureService();
	}

	@Override
	public String getAccessTokenEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthorizationUrl(Token arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestTokenEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

}
