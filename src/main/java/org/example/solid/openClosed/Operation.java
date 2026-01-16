package org.example.solid.openClosed;


/*

    This is good we keep adding new operation implementation
    and out calculator get extensions without modifying it main task
    that is performing calculation

 */
public interface Operation {
    public int perform(int number1, int number2);
}
