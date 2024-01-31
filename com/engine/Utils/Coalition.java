package com.engine.Utils;

/**
 * Created by user on 01 19 2024
 **/
public enum Coalition {
    WHITE{
        @Override
        public boolean isWhite() {
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }
        @Override
        public String toString(){
            return "White";
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

        @Override
        public String toString() {
            return "Black";
        }
    },
    ;

    public abstract boolean isWhite();
    public abstract boolean isBlack();
}
