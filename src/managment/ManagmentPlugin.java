package managment;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.core.GameState;
import mindustry.game.Team.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;

public  class ManagmentPlugin extends Plugin {
    @Override
    public void registerClientCommands(CommandHandler handler) {
        handler.register("ping", "Return \"Pong!\"", arg -> { Call.sendMessage("Pong!"); });

        handler.<Player>register("gameover", "End the game", arg -> {
            if(Vars.state.is(GameState.State.menu)) {
                Log.err("Not hosting game or map");
                return;
            }
            Events.fire(new EventType.GameOverEvent(Team.crux));
        });

    }
}
