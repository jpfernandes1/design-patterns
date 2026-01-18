package org.example.solid.interfaceSegregation.bad;

public class BadDDBAOConnection implements BadDAOInterface {
    @Override
    public void openConnection() {
        // Connection logic
    }

    @Override
    public void createRecord() {
        // Record logic
    }

    @Override
    public void openFile() {
        // We are in DB Connection so no need to support open file
        throw new UnsupportedOperationException("Open File Not Supported");
    }

    @Override
    public void deleteRecord() {
        // This is fine
    }
}
