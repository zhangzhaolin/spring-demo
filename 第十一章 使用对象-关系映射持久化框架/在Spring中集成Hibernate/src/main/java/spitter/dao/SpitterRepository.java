package spitter.dao;

import spitter.domain.Spitter;
import spitter.utils.DataTableInput;
import spitter.utils.DataTableOutput;
// import spitter.utils.DataTableInput;

import java.util.Map;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUserName(String userName);

    DataTableOutput<Spitter> findAll(DataTableInput datatable);

    Long count();

}
