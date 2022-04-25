package com.customer.categorizer.domain.customer;

public enum State {
    VALID("VALID"),
    NOT_VALID("NOT_VALID");



    private String stateName;

    State(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
    public static State getState(String stateName){
        State state = null;
        for (State t : State.values()) {
            if(t.stateName.equals(stateName)){
                state = t;
            }
        }
        return state;
    }
}
