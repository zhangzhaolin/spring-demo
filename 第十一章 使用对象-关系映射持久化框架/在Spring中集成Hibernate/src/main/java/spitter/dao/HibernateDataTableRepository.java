package spitter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spitter.utils.Column;
import spitter.utils.DataTableInput;
import spitter.utils.Order;

import java.util.List;

@Repository
public class HibernateDataTableRepository<T> implements DataTableRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long countByDataTable(String tableName, DataTableInput input) {
        System.out.println(input);
        String sql = "select count(*) from " + tableName + parseDataTableToString(input);
        Query<T> query = (Query<T>) session().createQuery(sql);
        query = namedParameterBound(query,input);
        return Long.valueOf(query.uniqueResult().toString());
    }

    @Override
    public List<T> getAllByDataTable(String tableName, DataTableInput input) {
        String sql = "from " + tableName + parseDataTableToString(input);
        Query<T> query = (Query<T>) session().createQuery(sql);
        query = namedParameterBound(query,input);
        return query.list();
    }

    @Override
    public StringBuilder parseDataTableToString(DataTableInput input) {
        StringBuilder sql = new StringBuilder();
        // where
        if(!"".equals(input.getSearch().getValue())){
            sql.append(" WHERE ");
            int index = -1;
            for(Column column:input.getColumns()){
                if (column.isSearchable() && !"".equals(input.getSearch().getValue()))
                {
                    sql.append(" ").append(column.getData()).append(" LIKE :").append(column.getData()).append(" OR");
                }
            }
            if((index = sql.lastIndexOf("OR")) > 0){
                sql = new StringBuilder(sql.substring(0,index));
            }
        }
        sql.append(" ORDER BY ");
        for (Order order:input.getOrder()){
            sql.append(input.getColumns().get(order.getColumn()).getData()).append(" ").append(order.getDir());
        }
        return sql;
    }

    // Named parameter bound
    private Query<T> namedParameterBound(Query<T> query,DataTableInput input){
        // where named parameter bound
        if(!"".equals(input.getSearch().getValue())){
            for(Column column:input.getColumns()){
                if (column.isSearchable() && !"".equals(input.getSearch().getValue()))
                {
                    query.setParameter(column.getData(),"%" + input.getSearch().getValue() + "%");
                }
            }
        }
        return query;
    }
}
