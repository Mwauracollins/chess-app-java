package com.engine.player;

import com.engine.Utils.Coalition;

/**
 * Created by user on 01 19 2024
 **/
public class WhitePlayer extends Player{
    private final Coalition playerCoalition;
    public WhitePlayer() {
        this.playerCoalition = Coalition.WHITE;

    }

    @Override
    public Coalition getPlayerCoalition() {
        return this.playerCoalition;
    }
}
