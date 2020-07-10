package com.uca.capas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Notas;

@Component
public class NotasDaoImpl implements NotasDao{

	@Autowired
	MateriasDAO materiaDao;
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Notas n) throws DataAccessException {
		n.setMateria(materiaDao.findOne(n.getId_materia()));
		n.setExpediente(estudianteDao.findOne(n.getId_expediente()));
		entityManager.persist(n);
	}

	@Override
	public List<Notas> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.TB_ESTUDIANTE_NOTA");
		Query query = entityManager.createNativeQuery(sb.toString(), Notas.class);

		List<Notas> res = query.getResultList();
		return res;
	}

}
