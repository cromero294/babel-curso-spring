package es.babel.modelo.persistencia;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import es.babel.modelo.entidades.Texto;

@Repository
public class TextoDAO {
	public Texto consumir() {
        RestTemplate restTemplate = new RestTemplate();
        Texto historia = restTemplate.getForObject("http://172.10.5.41:8080/historia", Texto.class);
        return historia;
	}
}
