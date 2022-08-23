package org.example.webapp.jaxws;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.webapp.jaxws.models.Curso;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://localhost:8081/webapp-jaxrs/api").path("/cursos");

        System.out.println("========== por id ==========");
        Response response = rootUri.path("/2")
                .request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("========== listando ==========");
        listar(rootUri);

        System.out.println("========== creando ==========");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Spring Cloud");
        cursoNuevo.setDescripcion("Spring cloud eureka");
        cursoNuevo.setDuracion(250D);
        cursoNuevo.setInstructor("Andres Guzman");

        //Vamos a comentar este asunto para que no se publique xd
        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        /*curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);*/
        System.out.println(curso);
        listar(rootUri);

        cursoNuevo.setId(7L);
        System.out.println("========== editando =========");
        Curso cursoEditado = cursoNuevo;
        //cursoEditado.setNombre("microservicios con spring cloud eureka");
        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/"+cursoEditado.getId()).request(MediaType.APPLICATION_JSON)
                .put(entityHeader, Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("========== eliminando ==========");
        rootUri.path("/" + cursoEditado.getId())
                .request()
                .delete();
        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        System.out.println("========== lista actualizada ==========");

        Response response;
        response = rootUri.request(MediaType.APPLICATION_JSON)
                .get();
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
    }
}
