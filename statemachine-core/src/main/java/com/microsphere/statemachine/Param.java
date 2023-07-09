package com.microsphere.statemachine;

import com.microsphere.statemachine.support.MemoryParam;

import java.util.List;

/**
 * #: todo - what is this
 *
 * @author wunhwantseng@gmail.com
 * @since todo - since from which version
 */
public interface Param {

     Value bind(String name, Object value);

     Value get(String name);

    default  <T> T get(String name, Class<T> type){
        final Value paramValue = get(name);
        if (paramValue == null) {
            return null;
        }

        return paramValue.get(type);
    }

     List<String> getParametersName();

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

     static Param create(){
        return new MemoryParam();
    }

}
