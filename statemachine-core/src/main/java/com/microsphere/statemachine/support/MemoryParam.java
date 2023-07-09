package com.microsphere.statemachine.support;

import com.microsphere.statemachine.Param;
import com.microsphere.statemachine.Value;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.map.MutableMap;

import java.util.List;

/**
 * #: todo - what is this
 *
 * @author wunhwantseng@gmail.com
 * @since todo - since from which version
 */
public final class MemoryParam implements Param {

    private final MutableMap<String, ParamValue> paramValues = Maps.mutable.empty();

    @Override
    public Value bind(String name, Object value) {
        final ParamValue param = new ParamValue(value);

        return paramValues.putIfAbsent(name, param);
    }

    @Override
    public Value get(String name) {
        return paramValues.get(name);
    }

    @Override
    public List<String> getParametersName() {
        return List.copyOf(paramValues.keySet());
    }

    @Override
    public int size() {
        return paramValues.size();
    }

}
