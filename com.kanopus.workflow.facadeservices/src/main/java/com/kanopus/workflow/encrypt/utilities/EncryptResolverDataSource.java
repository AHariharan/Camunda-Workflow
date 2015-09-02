package com.kanopus.workflow.encrypt.utilities;

import org.jasypt.util.text.BasicTextEncryptor;
import org.apache.commons.dbcp2.BasicDataSource;

public class EncryptResolverDataSource extends BasicDataSource{
	
	@Override
	public void setPassword(String password) {
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword("wf@mpw");
		String result = textEncryptor.decrypt(password);
		super.setPassword(result);
	}

}
