package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Денис", 100);
    Player player2 = new Player(2, "Сергей", 230);
    Player player3 = new Player(3, "Мария", 350);
    Player player4 = new Player(4, "Даша", 230);
    Player player5 = new Player(5, "Егор", 400);


    @Test
    public void shouldPrint1BecauseStrengthOfFirstMore() {
        game.register(player5);
        game.register(player4);

        game.round(player5.getName(), player4.getName());

        Assertions.assertEquals(1, game.round(player5.getName(), player4.getName()));
    }

    @Test
    public void shouldPrint2BecauseStrengthOfFirstBelow() {
        game.register(player1);
        game.register(player2);

        game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(2, game.round(player1.getName(), player2.getName()));
    }

    @Test
    public void shouldPrint0BecauseStrengthEqual() {
        game.register(player2);
        game.register(player4);

        game.round(player2.getName(), player4.getName());

        Assertions.assertEquals(0, game.round(player2.getName(), player4.getName()));
    }

    @Test
    public void shouldThrowsNotRegisteredExceptionBecauseRegisteredFirst() {

        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player5.getName());
        });
    }

    @Test
    public void shouldThrowsNotRegisteredExceptionBecauseRegisteredSecond() {

        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player4.getName());
        });
    }

    @Test
    public void shouldThrowsNotRegisteredExceptionBecauseNoRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player5.getName());
        });
    }
}