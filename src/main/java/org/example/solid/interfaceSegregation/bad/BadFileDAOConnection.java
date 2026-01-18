package org.example.solid.interfaceSegregation.bad;

public class BadFileDAOConnection implements BadDAOInterface{
    @Override
    public void openConnection() {
        // We can't open connection in file system
    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public void deleteRecord() {

    }
}
