package org.example.dao.project;

import org.example.enitty.Client;
import org.example.enitty.Project;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.Duration;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    @Override
    public void deleteById (Long id) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Project existing = session.get(Project.class, id);
            session.remove(existing);
            transaction.commit();
        }
    }

    @Override
    public List<Project> getLongestProjects () {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Duration maxDuration = session.createQuery("select MAX(trunc(finishDate - startDate)) as days from Project", Duration.class)
                    .getSingleResult();
            return session
                    .createQuery("FROM Project WHERE trunc(finishDate - startDate) = :maxDuration", Project.class)
                    .setParameter("maxDuration", maxDuration)
                    .list();
        }
    }
}
