package devarea.fr.utils;

import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import discord4j.core.object.component.Label;
import discord4j.core.object.component.LayoutComponent;
import discord4j.core.object.component.MessageComponent;
import discord4j.core.object.component.TextInput;

public class ModalUtils {

    /**
     * Renvoie la valeur du TextInput à la position {@code index} dans une modale soumise.
     * Les champs sont enveloppés dans un {@link Label} (ou un ActionRow pour les anciennes modales).
     */
    public static String getValue(final ModalSubmitInteractionEvent event, final int index) {
        MessageComponent component = event.getComponents().get(index);
        if (component instanceof Label label)
            component = label.getComponent();
        else if (component instanceof LayoutComponent layout)
            component = layout.getChildren().get(0);
        return ((TextInput) component).getValue().orElse("");
    }

}
