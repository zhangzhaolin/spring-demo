package dao;

import pojo.Spitter;

public interface SpitterRepository {

    public Spitter save(Spitter spitter);

    public Spitter findOneByUserName(String username);
}
