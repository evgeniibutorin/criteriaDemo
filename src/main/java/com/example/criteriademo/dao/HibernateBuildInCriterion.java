package com.example.criteriademo.dao;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HibernateBuildInCriterion {
    private static final int PARAMETER_LIMIT = 800;

    /**
     * An utility method to build the Criterion Query IN clause if the number of parameter
     * values passed has a size more than 1000. Oracle does not allow more than
     * 1000 parameter values in a IN clause. Doing so a {@link SQLException} is
     * thrown with error code, 'ORA-01795: maximum number of expressions in a list is 1000'.
     * @param propertyName
     * @param values
     * @return
     */
    public static Criterion buildInCriterion1(String propertyName, List<?> values) { // пимер с 1001
        Criterion criterion = null;
        int listSize = values.size();//1001 размер списка параметров
        for (int i = 0; i < listSize; i += PARAMETER_LIMIT) {//0 1001 800 потом? 00 1001 1600 не понятно i += PARAMETER_LIMIT эквивалент i = i+PARAMETER_LIMIT Зачем?
            List<?> subList;
            if (listSize > i + PARAMETER_LIMIT) {
                subList = values.subList(i, (i + PARAMETER_LIMIT));
            } else {
                subList = values.subList(i, listSize);
            }
            if (criterion != null) {
                criterion = Restrictions.or(criterion, Restrictions.in(propertyName, subList));
            } else {
                criterion = Restrictions.in(propertyName, subList);
            }
        }
        return criterion;
    }

}
