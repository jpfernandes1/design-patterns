package org.example.solid.interfaceSegregation.bad;

/*

    This dao (data access object) defined to support data access during file system
    or database system. So we have added openConnection and openFile for it
    this bad because we have accommodated all operation in single interface

 */
public interface BadDAOInterface {

    public void openConnection();
    public void createRecord();
    public void openFile();
    public void deleteRecord();
}
