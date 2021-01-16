package managment;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.content.*;
import mindustry.game.Team.*;
import mindustry.game.EventType.*;
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
            Events.fire(new EventType.GameOverEvent(Team.crux));
        });
    }
}
