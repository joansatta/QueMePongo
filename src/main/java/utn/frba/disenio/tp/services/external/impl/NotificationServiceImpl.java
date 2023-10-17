package utn.frba.disenio.tp.services.external.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import utn.frba.disenio.tp.services.external.NotificationService;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {

	public void notify(String message) {
		log.info(String.format("Notificación enviada a la pantalla: %s", message));
	}
	
}
