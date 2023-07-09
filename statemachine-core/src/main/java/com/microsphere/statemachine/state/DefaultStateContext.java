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
public class DefaultStateContext<S, E> implements StateContext<S, E> {

    private final StateMachine<S, E> stateMachine;

    private final Transition<S, E> transition;

    private final E event;

    private final Param param;

    private Exception error;

    private FireResult result;

    public DefaultStateContext(StateMachine<S, E> stateMachine, Transition<S, E> transition, E event, Param params) {
        this.stateMachine = stateMachine;
        this.transition = transition;
        this.event = event;
        this.param = params;
        this.error = null;
    }

    @Override
    public E getEvent() {
        return this.event;
    }

    @Override
    public Transition<S, E> getTransition() {
        return transition;
    }

    @Override
    public StateMachine<S, E> getStateMachine() {
        return stateMachine;
    }

    @Override
    public Param getParam() {
        return param;
    }

    @Override
    public Exception getException() {
        return error;
    }

    @Override
    public FireResult getResult() {
        if (this.result == null){
            this.result = FireResult.Rejected;
        }

        return this.result;
    }

    public void abnormalRegistration(Exception ex) {
        this.error = ex;
    }

    public void resultRegistration(FireResult rs) {
        this.result = rs;
    }

    @Override
    public String toString() {
        return "DefaultStateContext{" +
                "transition=" + transition +
                '}';
    }
}
