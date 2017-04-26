/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compscipunk.discord.sandbotmaven;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 *
 * @author michael
 */
public class SandbotMaven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JDA api = new JDABuilder(AccountType.BOT).setToken("MjU4NDYzOTc1OTI1MDg4MjU2.Czd1gQ.k8fxV-vtuSfYPoYZ8o6w00TrSfE").addListener(new Commands()).buildBlocking();
            api.getPresence().setGame(Game.of("admin... | !help"));
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException ex) {
            Logger.getLogger(SandbotMaven.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
