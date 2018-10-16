/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author rueln
 */
public class AtLeastOne implements Criterion {

    private Criterion[] criteria;

    public AtLeastOne(Criterion... criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean complies(String line) {
        for (Criterion criterion : criteria) {
            if (criterion.complies(line)) {
                return true;
            }
        }
        return false;
    }

}
