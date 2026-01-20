package org.example.principles.solid.openClosed;

/*
    This bad design where we are taking type and for each type we are having cases now if we want
    to introduce division, we have to modify calculator (violation of open closed principle)
 */
public class BadCalculator {
    public int calculateNumer(int number1, int number2, String operation) {
        int result = 0;
        switch (operation) {
            case "sum":
                result = number1 + number2;
                break;
            case "sub":
                result = number1 - number2;
                break;
        }
        return result;
    }
}
