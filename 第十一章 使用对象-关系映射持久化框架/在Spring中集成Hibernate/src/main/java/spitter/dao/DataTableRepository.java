package spitter.dao;

import org.hibernate.Session;
import spitter.utils.DataTableInput;

import java.util.List;

public interface DataTableRepository<T> {

    public Session session();

    public Long countByDataTable(String tableName, DataTableInput input);

    public List<T> getAllByDataTable(String tableName,DataTableInput input);

    StringBuilder parseDataTableToString(DataTableInput input);
}
