package com.microsphere.statemachine.state;

import com.microsphere.statemachine.Param;
import com.microsphere.statemachine.StateMachine;
import com.microsphere.statemachine.enumerate.FireResult;
import com.microsphere.statemachine.transition.Transition;

/**
 * #: todo - what is this
 *
 * @author wunhwantseng@gmail.com
 * @since 0.0.1
 */
public interface StateContext<S, E> {

    E getEvent();

    Transition<S, E> getTransition();

    StateMachine<S, E> getStateMachine();

    Param getParam();

    Exception getException();

    FireResult getResult();

}
