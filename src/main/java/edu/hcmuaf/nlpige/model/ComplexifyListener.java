package edu.hcmuaf.nlpige.model;

/**
 * Created by IntelliJ on Sunday, 09 December, 2018 at 23:43.
 *
 * @author Joseph Maria
 */
public interface ComplexifyListener {
    /**
     * Method is called when password complexity calculation is done.
     *
     * @param isValid    true if password is valid, false otherwise
     * @param complexity Number form range [0.0, 100.0] where greater number represents greater complexity
     */
    void onSuccess(boolean isValid, double complexity);
}
