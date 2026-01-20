package org.example.principles.solid.interfaceSegregation.good;
/*
    The Interface Segregation principle says that we should create interfaces in a way
    that it have only the methods that the clients really needs to implement.
    We should not force the client to implement methods they will not need.
    So we can segregate a generic interface in more specific ones.
 */

    // This is good we will only include the dao operation and segregate
    // connection part, so consumer can implement only the required interfaces
public interface DAOInterface {

    public void createRecord();
    public void deleteRecord();
}
