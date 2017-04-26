/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compscipunk.discord.sandbotmaven;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.MessageHistory;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author michael
 */
public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContent();
        User author = event.getAuthor();
        DateFormat date = new SimpleDateFormat("EEE dd MMM yyyy");
        DateFormat time = new SimpleDateFormat("hh:mm:ss aa");
        Date d = new Date();

        if (!"".equals(msg)) {
            if (event.isFromType(ChannelType.TEXT)) {
                if ("!".equals(msg.substring(0, 1))) {
                    String[] commandArray = msg.split(" ");
                    if (commandArray[0].equalsIgnoreCase("!help")) {
                        event.getChannel().sendMessage("DM has been sent to " + author.getAsMention()).queue();
                        author.openPrivateChannel().queue(success -> {
                            EmbedBuilder eb = new EmbedBuilder();
                            eb.setColor(Color.MAGENTA);
                            eb.setFooter(author.getName() + " | " + date.format(d) + " at " + time.format(d), author.getAvatarUrl());
                            eb.setDescription("!help - Sends A DM with all commands.\n"
                                    + "!hello - friendly greeting.\n"
                                    + "!bf1stats<ps4, xbox, pc> <origin id> - Display BTR graphic of origin user");
                            MessageEmbed e = eb.build();
                            MessageBuilder mb = new MessageBuilder();
                            mb.setEmbed(e);
                            Message m = mb.build();
                            author.getPrivateChannel().sendMessage(m).queue();
                        });
                    } else if (commandArray[0].equalsIgnoreCase("!bf1stats")) {
                        String platform = "0";
                        String originUser = commandArray[2];
                        if (commandArray[1].equalsIgnoreCase("xbox")) {
                            platform = "1";
                        } else if (commandArray[1].equalsIgnoreCase("ps4")) {
                            platform = "2";
                        } else if (commandArray[1].equalsIgnoreCase("pc")) {
                            platform = "3";
                        } else {
                            event.getChannel().sendMessage("Incorrect platform type").queue();
                        }
                        if (!"0".equals(platform)) {
                            EmbedBuilder eb = new EmbedBuilder();
                            eb.setColor(Color.GREEN);
                            eb.setImage("http://bots.tracker.network/bf1/bf1.php?platform=" + platform + "&username=" + originUser);
                            eb.setDescription(("https://battlefieldtracker.com/bf1/profile/" + commandArray[1]) + ("/" + originUser));
                            MessageEmbed e = eb.build();
                            MessageBuilder mb = new MessageBuilder();
                            mb.setEmbed(e);
                            Message m = mb.build();

                            event.getChannel().sendMessage(m).queue();

                            //event.getChannel().sendMessage(("https://battlefieldtracker.com/bf1/profile/" + commandArray[1]) + ("/" + commandArray[2])).queue();
                        }
                    } else if (commandArray[0].equalsIgnoreCase("!clean")) {
                        //MessageHistory mh = new MessageHistory(event.getChannel());
                        int i = Integer.parseInt(commandArray[1]);
                        //mh.retrieveFuture(i);

                        //event.getTextChannel().deleteMessages(mh);
                    } else if (commandArray[0].equalsIgnoreCase("!hello")) {
                        event.getChannel().sendMessage("Hello " + author.getAsMention()).queue();
                    } else {
                        event.getChannel().sendMessage("Invalid command").queue();
                    }
                }
            }

        }
    }

    /*
        
     */
}
