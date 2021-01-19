package managment;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.content.*;
import mindustry.core.GameState;
import mindustry.game.Team.*;
import mindustry.game.EventType.*;
import mindustry.net.Administration;
import mindustry.gen.*;
import mindustry.mod.*;

public  class ManagmentPlugin extends Plugin {
    //register chat commands that can be invoked in-game
    @Override
    public void registerClientCommands(CommandHandler handler) {

        //simple command that retungs pong when called
        handler.register("ping", "Return \"Pong!\"", arg -> { Call.sendMessage("Pong!"); });

        //command that will cause GameOver.
        handler.<Player>register("gameover", "End the game", arg -> {
            if(Vars.state.is(GameState.State.menu)) {
                Log.err("Not hosting game or map");
                return;
            }
            Events.fire(new EventType.GameOverEvent(Team.crux));
        });

    }
}
