package spitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spitter.domain.Spitter;
import spitter.utils.DataTableInput;
import spitter.utils.DataTableOutput;

import java.io.Serializable;

@Repository
@Transactional
public class HibernateSpitterRepository extends HibernateDataTableRepository<Spitter> implements SpitterRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = getCurrentSession().save(spitter);
        spitter.setId((Long)id);
        return spitter;
    }

    @Override
    public Spitter findByUserName(String userName) {
        return getCurrentSession().find(Spitter.class,userName);
    }

    @Override
    public DataTableOutput<Spitter> findAll(DataTableInput datatable) {
        Long count = countByDataTable("Spitter",datatable);
        return new DataTableOutput<>(datatable.getDraw(),
                count,count,
                getAllByDataTable("Spitter",datatable));
    }

    @Override
    public Long count() {
        String sql = "SELECT COUNT(*) FROM Spitter";
        return Long.parseLong(getCurrentSession().createSQLQuery(sql).uniqueResult().toString());
    }
}
