package com.parser.trigger;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class MessageTriggerManager {
    public static List<MessageTrigger> triggers = new ArrayList<>();

    public MessageTriggerManager() {}

    public static void init() {
        try {
            triggers = new ArrayList<>();

            Set<Class<? extends MessageTrigger>> classes = new Reflections("com.parser.trigger")
                    .getSubTypesOf(MessageTrigger.class);

            for (Class<? extends MessageTrigger> t : classes)
                triggers.add(t.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
