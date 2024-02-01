package com.engine.player;

import com.engine.Utils.Coalition;

/**
 * Created by user on 01 19 2024
 **/
public class BlackPlayer extends Player{
    private final Coalition playerCoalition;

    public BlackPlayer(){
        this.playerCoalition = Coalition.BLACK;
    }

    @Override
    public Coalition getPlayerCoalition() {
        return this.playerCoalition;
    }
}
