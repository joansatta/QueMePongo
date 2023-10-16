package utn.frba.disenio.tp.services.external.impl;

import lombok.extern.slf4j.Slf4j;
import utn.frba.disenio.tp.services.external.MailSender;

@Slf4j
public class MailSenderImpl implements MailSender {

	public void send(String address, String message) {
		log.info(String.format("Correo enviado. Address: %s. Messge: %s"),address,message);
	}
}
