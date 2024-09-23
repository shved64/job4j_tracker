package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

class ValidateInputTest {

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"0"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Меню:");
        assertThat(selected).isEqualTo(0);
    }

    @Test
    void whenMultipleValidInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Меню:");
        assertThat(selected).isEqualTo(0);
        int selected1 = input.askInt("Меню:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Меню:");
        assertThat(selected2).isEqualTo(2);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Меню:");
        assertThat(selected).isEqualTo(-2);
    }
}