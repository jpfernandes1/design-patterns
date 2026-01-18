package org.example.solid.interfaceSegregation.good;

// Here don't need to bother about db part
public class FileDAOConnection implements FileInterface, DAOInterface {

    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openFile() {

    }
}
