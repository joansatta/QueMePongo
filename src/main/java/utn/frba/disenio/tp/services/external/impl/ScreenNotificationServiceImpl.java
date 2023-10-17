package utn.frba.disenio.tp.services.external.impl;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import utn.frba.disenio.tp.services.external.ScreenNotificationService;

@Slf4j
@Service
public class ScreenNotificationServiceImpl implements ScreenNotificationService {

	public void notify(String message) {
		log.info(String.format("Notificación enviada a la pantalla: %s", message));
	}
	
}
