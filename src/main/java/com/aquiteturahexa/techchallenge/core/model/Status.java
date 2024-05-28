package com.aquiteturahexa.techchallenge.core.model;

public enum Status {

    CREATED {
        @Override
        public Status advance() {
            return AWAITING_PAYMENT;
        }
    },
    AWAITING_PAYMENT {
        @Override
        public Status advance() {
            return PAID;
        }
    },
    PAID {
        @Override
        public Status advance() {
            return RECEIVED;
        }
    },
    RECEIVED {
        @Override
        public Status advance() {
            return IN_PREPARATION;
        }
    },
    IN_PREPARATION {
        @Override
        public Status advance() {
            return READY;
        }
    },
    READY {
        @Override
        public Status advance() {
            return FINISHED;
        }
    },
    FINISHED {
        @Override
        public Status advance() {
            throw new RuntimeException("final status");
        }
    },
    CANCELLED {
        @Override
        public Status advance() {
            throw new RuntimeException("final status");
        }
    };


    public abstract Status advance();
}
