package com.engine.Utils;

/**
 * Created by user on 01 19 2024
 **/
public enum Coalition {
    WHITE(){
        @Override
        public boolean isWhite() {
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }
    },
    BLACK {
        @Override
        public boolean isWhite() {
            return false;
        }

        @Override
        public boolean isBlack() {
            return true;
        }
    },
    ;

    public abstract boolean isWhite();
    public abstract boolean isBlack();
}
