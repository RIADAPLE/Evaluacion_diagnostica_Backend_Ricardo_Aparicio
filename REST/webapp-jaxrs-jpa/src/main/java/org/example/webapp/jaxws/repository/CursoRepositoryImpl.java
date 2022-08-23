package org.example.webapp.jaxws.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.webapp.jaxws.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository {
    @PersistenceContext(name="ejemploJpa")
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("select c from Curso c left outer join fetch c.instructor", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        if(curso.getId() != null && curso.getId()>0){
            em.merge(curso);
        } else {
            em.persist(curso);
        }
        return curso;
    }

    @Override
    public Curso porId(Long id) {
        return em
                .createQuery("select c from Curso c left outer join fetch c.instructor where c.id=:id", Curso.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        Curso c = porId(id);
        em.remove(c);
    }
}
